public class WatchV3 extends Watch{
    Screen screen;

    public WatchV3(int battery, Screen screen) {
        super(battery);
        this.screen = screen;
        //TODO Auto-generated constructor stub
    }

    @Override
    public void displayBattery() {
        screen.displayBattery(battery);
    }
    
}
