public enum Type {
    Motor(1), Car(2), Bus(3);
    
    private int typeVal;

    Type(int typeVal) {
        this.typeVal = typeVal;
    }

    public int getTypeVal() {
        return typeVal;
    }
}
