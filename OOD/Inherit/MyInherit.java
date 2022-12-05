package OOD.Inherit;

class Father {
    int a = 1;

    public void printFather() {
        System.out.println(this.a);
    }
}

class Son extends Father {
    int a = 2;

    @Override
    public void printFather() {
        System.out.println("Father override.");
    }

    public void printSon() {
        System.out.println(this.a);
    }
}

public class MyInherit {
    public int a = 0;
    protected int b = 1;
    private int c = 2;

    public static void main(String[] args) {
        Son t2 = new Son();
        t2.printSon();
        t2.printFather();
    }
}