package Class2.MiBand;


import Class2.MiBand.DisplayableHardware.IdisplayableHardware;
import Class2.MiBand.DisplayableHardware.LEDArray;
import Class2.MiBand.DisplayableHardware.Screen;
import Class2.MiBand.DisplayableHardware.Speaker;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by FLK on 2020-06-20.
 */
public class MiBandV3 extends MiBand {
    private final Map<DisplayOption, IdisplayableHardware> hardwareMap;

    public MiBandV3(String id, final Screen screen) {
        super(id);
        hardwareMap = new HashMap<>();

        initHardWare();
    }

    private void initHardWare() {
        hardwareMap.put(DisplayOption.LED_ARRAY, new LEDArray("Techbow-LED"));
        hardwareMap.put(DisplayOption.SCREEN, new Screen("SC-123", "OLED"));
        hardwareMap.put(DisplayOption.VOICE, new Speaker("Speaker_123"));
    }

    public void updateNewHardware(final DisplayOption displayOption, final IdisplayableHardware hardware){
        hardwareMap.put(displayOption, hardware);
    }


    @Override
    public void displayBatteryLife(final DisplayOption displayOption) {
            final IdisplayableHardware hardware = hardwareMap.get(displayOption);

            if(hardware == null) {
                // consider throw a self-defined exception
                return;
            }

            hardware.displayNumber(getBatteryLife());
    }
}
