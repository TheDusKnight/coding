public enum Suit {
    Diamond("Diamond", 1),
    Club("Clue", 2),
    Heart("Heart", 3),
    Spade("Club", 4);

    private String suitName;
    private int suitValue;

    Suit(String suitName, int suitValue) {
        this.suitName = suitName;
        this.suitValue = suitValue;
    }
}
