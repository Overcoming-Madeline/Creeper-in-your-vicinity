package com.creeper.in.your.vicinyty.client;

public class CreeperState {
    private static Boolean creeperNearby = false;

    public static Boolean getCreeperNearby() {
        return creeperNearby;
    }

    public static void setCreeperNearby(Boolean setCreeperNearby) {
        creeperNearby = setCreeperNearby;
    }
}
