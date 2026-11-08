package com.creeper.in.your.vicinyty;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class CustomSounds {
    private CustomSounds() {
    }

    public static final SoundEvent WARNING = registerSound("warning");

    private static SoundEvent registerSound(String id) {
        Identifier identifier = CreeperInYourVicinity.id(id);
        return Registry.register(Registries.SOUND_EVENT, identifier, SoundEvent.of(identifier));
    }

    public static void initialize() {
    }
}
