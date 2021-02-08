package com.github.handlederror.woj.server;

import com.github.handlederror.woj.server.Earth;

public class Creature {
    public String name;
    public String type;
    public Integer age;
    public final Earth earth;
    public final Boolean mortal;

    public Creature(String name, String type, Earth earth, Boolean mortal) {
        this.name = name;
        this.type = type;
        this.earth = earth;
        this.mortal = mortal;
    }

    public String getType() {
        return this.type;
    }

    public Boolean isMortal() {
        return this.mortal;
    }

    public Boolean is(String type) {
        return this.type.equals(type);
    }

    public Boolean isCalled(String name) {
        return this.name.equals(name);
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
