package OOD.BuilderPattern;

public class User {
    private String name;
    private String email;
    private String address;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    private User(UserBuilder userBuilder) {
        this.name = userBuilder.name;
        this.email = userBuilder.email;
        this.address = userBuilder.address;
    }

    public UserBuilder toBuilder() {
        return new UserBuilder(this.name).setEmail(this.email).setAddress(this.address);
    }

    public static class UserBuilder {
        private String name;
        private String email;
        private String address;

        public UserBuilder(String name) {
            this.name = name;
        }

        public UserBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public UserBuilder setAddress(String address) {
            this.address = address;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}

class Main {
    public static void main(String[] args) {
        // 第一个new是用来new UserBuilder的
        User user = new User.UserBuilder("Trevor").setEmail("123").setAddress("hello").build();
        System.out.println(user.getAddress());
        User user2 = user.toBuilder().setAddress("world").build();
        System.out.println(user2.getAddress());
    }
}
