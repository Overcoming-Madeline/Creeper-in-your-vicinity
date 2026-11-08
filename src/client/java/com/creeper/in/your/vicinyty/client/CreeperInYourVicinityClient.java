package com.creeper.in.your.vicinyty.client;

import com.creeper.in.your.vicinyty.client.hud.CreeperHud;
import dev.isxander.yacl3.api.*;
import dev.isxander.yacl3.api.controller.TickBoxControllerBuilder;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.text.Text;
import org.apache.logging.log4j.core.config.builder.api.Component;


public class CreeperInYourVicinityClient implements ClientModInitializer {

    public static Boolean modEnabled = true;

	@Override
	public void onInitializeClient() {
		ClientTickEvents.END_CLIENT_TICK.register(client -> {
			if (client.player == null || client.world == null) return;
			CreeperChecker.tick();
		});



		HudRenderCallback.EVENT.register(CreeperHud::render);
	}
}