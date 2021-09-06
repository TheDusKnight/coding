

public abstract class Button {
    private final long id;
    protected final Status status;
    protected final int levelNumber;

    public Button(long id, Status status, int levelNumber) {
        this.id = id;
        this.status = status;
        this.levelNumber = levelNumber;
    }

   public long getButtonId() {
       return id;
   }

}
