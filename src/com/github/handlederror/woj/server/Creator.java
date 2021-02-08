package com.github.handlederror.woj.server;

import java.util.ArrayList;
import com.github.handlederror.woj.server.Earth;
import com.github.handlederror.woj.server.Creature;
import com.github.handlederror.woj.server.Garbage;

public class Creator {
    public Earth earth;
    public Garbage garbage;
    public String name;

    public Creator(String name, Earth earth, Garbage garbage) {
        this.earth = earth;
        this.garbage = garbage;
        this.name = name;

        this.earth.creatures = new ArrayList<Creature>();
        this.garbage.killedCreatures = new ArrayList<Creature>();
    }

    public void summonCreature(Creature creature) {
        this.earth.summonCreature(creature);
    }

    public void killCreature(String name, String type) {
        for (int index = 0; index < this.earth.creatures.size(); index++) {
            if (this.earth.creatures.get(index).name.equals(name)) {
                if (this.earth.creatures.get(index).type.equals(type)) {
                    this.garbage.killedCreatures.add(this.earth.creatures.remove(index));
                }
            }
        }
    }
}
