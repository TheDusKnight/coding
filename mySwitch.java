public class mySwitch {
    public static void main(String[] args) {
        boolean res = isRcsDisabled(4);
        System.out.println(res);
    }

    static boolean isRcsDisabled(int num) {
        switch (num) {
            case 1:
            case 2:
                return true;
            case 3:
                return false;
            case 4:
            case 5:
                return true;
        }

        throw new IllegalArgumentException("unsupported num: " + num);
    }
}
