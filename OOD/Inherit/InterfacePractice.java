package OOD.Inherit;

public interface InterfacePractice {
    void helloWorld();
}

class SayHello implements InterfacePractice {

    @Override
    public void helloWorld() {
        System.out.println("hello world");
    }
    
    public static void main(String[] args) {
        SayHello sayHello = new SayHello();
        sayHello.helloWorld();
    }
}
