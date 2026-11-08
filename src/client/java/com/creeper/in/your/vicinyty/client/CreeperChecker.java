package com.creeper.in.your.vicinyty.client;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.util.math.Box;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CreeperChecker {

    private static final List<Entity> nearby = new ArrayList<>();

    public static void tick(){
        MinecraftClient client = MinecraftClient.getInstance();
        ClientPlayerEntity player = client.player;

        if(player == null) return;

        Box box = player.getBoundingBox().expand(3);

        assert client.world != null;
        nearby.addAll(client.world.getOtherEntities(player.getEntity(), box));

        CreeperState.setCreeperNearby(false);

        for (Entity entity : nearby){
            if(entity.getType().equals(EntityType.CREEPER)){
                CreeperState.setCreeperNearby(true);
                break;
            }
            CreeperState.setCreeperNearby(false);
        }
        nearby.clear();

    }
}
