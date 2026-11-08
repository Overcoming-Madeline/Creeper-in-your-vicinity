package com.creeper.in.your.vicinyty.client.hud;

import com.creeper.in.your.vicinyty.CreeperInYourVicinity;
import com.creeper.in.your.vicinyty.CustomSounds;
import com.creeper.in.your.vicinyty.client.CreeperInYourVicinityClient;
import com.creeper.in.your.vicinyty.client.CreeperState;
import com.ibm.icu.text.ListFormatter;
import com.mojang.blaze3d.pipeline.RenderPipeline;
import com.mojang.blaze3d.platform.DepthTestFunction;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.RenderPipelines;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.client.sound.PositionedSoundInstance;
import net.minecraft.client.sound.SoundInstance;
import net.minecraft.text.ClickEvent;
import net.minecraft.util.Identifier;

public class CreeperHud {

    private static int Height = 1080;
    private static int Width = 1080;

    private static final int Size = 100;

    private static final Identifier sprite = Identifier.of(CreeperInYourVicinity.MOD_ID,"textures/gui/warning.png");

    private static PositionedSoundInstance instance = PositionedSoundInstance.music(CustomSounds.WARNING);

    public static void render(DrawContext ctx, RenderTickCounter tickCounter){
        Height = ctx.getScaledWindowHeight();
        Width = ctx.getScaledWindowWidth();




        MinecraftClient client = MinecraftClient.getInstance();
        if (client.player == null || client.options.hudHidden) return;



        if (CreeperState.getCreeperNearby() == false) {
            client.getSoundManager().stop(instance);
            return;
        }
        if (!CreeperInYourVicinityClient.modEnabled) return;

        //ctx.fill( Width,Height,Width-Size,Height-Size,0xFFFFFFFF);
        int x = Width - Size - 10;
        int y = Height - Size - 10;

        ctx.drawTexture(
                RenderPipelines.GUI_TEXTURED,
                sprite,
                x, y,
                0.0f, 0.0f,
                Size, Size,
                64, 64,
                64, 64,
                0xFFFFFFFF
        );
        if(!client.getSoundManager().isPlaying(instance)) {
            client.getSoundManager().play(instance);
        }



    }
}
