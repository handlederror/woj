package com.github.handlederror.woj.client;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import com.github.handlederror.woj.server.Time;
import com.github.handlederror.woj.server.Earth;
import com.github.handlederror.woj.server.Creature;
import com.github.handlederror.woj.server.types.Human;
import com.github.handlederror.woj.server.types.CustomType;
import com.github.handlederror.woj.server.Garbage;
import com.github.handlederror.woj.server.Creator;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Garbage garbage = new Garbage();
        Earth earth = new Earth("World", true);
        CustomType creatureCustomType = new CustomType(Human.name);
        Creature developer = new Creature("maDeveloper", creatureCustomType.name, earth, true);
        Creator creator = new Creator("maDeveloper", earth, garbage);

        Time time = new Time();
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                if (time.timePassed == null) {
                    time.timePassed = 0;
                } time.timePassed++;

                earth.updateEarth();
            }
        };

        timer.scheduleAtFixedRate(timerTask, 0, 1000);

        if (time.timePassed == null) {
            time.timePassed = 0;
        }

        creator.summonCreature(developer);
    }
}
