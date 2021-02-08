package com.github.handlederror.woj.server;

import java.util.List;
import java.util.ArrayList;
import com.github.handlederror.woj.server.Creature;

public class Earth {
    public String name;
    public Integer time;
    public Boolean mortal;
    public List<Creature> creatures;
    public Integer timePassed;

    public Earth(String name, Boolean mortal) {
        this.name = name;
        this.mortal = mortal;
    }

    public void summonCreature(Creature creature) {
        this.creatures.add(creature);
    }

    public void updateEarth() {
        this.timePassed++;
        
    }

    public Boolean isMortal() {
        return this.mortal;
    }

    public Boolean canKillCreature() {
        int isMortal;
        Boolean returnValue;

        if (this.isMortal()) {
            isMortal = 0;
        } else {
            isMortal = 1;
        }

        returnValue = switch (isMortal) {
            case 1 -> false;
            case 0 -> true;
            default -> throw new IllegalStateException("Unexpected value: " + isMortal);
        }; return returnValue;
    }
}
