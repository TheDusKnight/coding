package Class3.TechbowBadgeSystem;


public class Badge {

    private final String badgeId;
    private String userId;

    public Badge(final String badgeId){
        this.badgeId = badgeId;
    }

    public void setUserId(String userId){
        this.userId = userId;
    }

    public String getBadgeId(){
        return badgeId;
    }

    public String getUserId(){
        return userId;
    }

}
