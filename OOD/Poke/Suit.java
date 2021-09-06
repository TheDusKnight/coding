package OOD.Poke;

public enum Suit {
    Diamond("Diamond", 1),
    Club("Club", 2),
    Heart("Heart", 3),
    Spade("Spade", 4);

    private final String suitName;
    private final int suitValue;

    private Suit(String suitName, int suitValue) {
        this.suitName = suitName;
        this.suitValue = suitValue;
    }

    public String toString() {
        return suitName;
    }

    public int getSuitValue() {
        return suitValue;
    } 

}
