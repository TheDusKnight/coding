package OOD.BuilderPattern;

public class Phone {
    private String SoC; // 处理器，必填
    private int RAMCapacity; // RAM容量，必填
    private int ROMCapacity; // ROM容量，必填
    private double changePower; // 充电功率
    private double screenSize; // 屏幕大小
    private Phone(Builder builder) {
        this.SoC = builder.SoC;
        this.RAMCapacity = builder.RAMCapacity;
        this.ROMCapacity = builder.ROMCapacity;
        this.changePower = builder.changePower;
        this.screenSize = builder.screenSize;
    }
    public static class Builder {
        private String SoC;
        private int RAMCapacity;
        private int ROMCapacity;
        private double changePower;
        private double screenSize;
        // 必填参数通过Builder的构造方法设置
        public Builder(String SoC, int RAMCapacity, int ROMCapacity) {
            this.SoC = SoC;
            this.RAMCapacity = RAMCapacity;
            this.ROMCapacity = ROMCapacity;
        }
        public Builder setChangePower(double changePower) {
            this.changePower = changePower;
            return this;
        }
        public Builder setScreenSize(double screenSize) {
            this.screenSize = screenSize;
            return this;
        }
        public Phone build() {
            return new Phone(this);
        }
    }


    public static void main(String[] args) {
        Phone phone = new Phone.Builder("SoC", 4, 32).setScreenSize(18).build();
        System.out.println(phone.RAMCapacity);
    }
}
