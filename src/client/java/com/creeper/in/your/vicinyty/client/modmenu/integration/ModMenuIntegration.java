package com.creeper.in.your.vicinyty.client.modmenu.integration;

import com.creeper.in.your.vicinyty.client.CreeperInYourVicinityClient;
import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import dev.isxander.yacl3.api.*;
import dev.isxander.yacl3.api.controller.TickBoxControllerBuilder;
import net.minecraft.text.Text;
import org.apache.logging.log4j.core.config.builder.api.Component;

public class ModMenuIntegration implements ModMenuApi {
    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return parentScreen ->         YetAnotherConfigLib.createBuilder()
                .title(Text.literal("Used for narration. Could be used to render a title in the future."))
                .category(ConfigCategory.createBuilder()
                        .name(Text.literal("Main"))
                        .tooltip(Text.literal("Main category of this mod."))
                                .option(Option.<Boolean>createBuilder()
                                        .name(Text.literal("Mod Enabled"))
                                        .description(OptionDescription.of(Text.literal("Toggles the mod")))
                                        .binding(true, () -> CreeperInYourVicinityClient.modEnabled, newVal -> CreeperInYourVicinityClient.modEnabled = newVal)
                                        .controller(TickBoxControllerBuilder::create)
                                        .build())
                                .build())
                .build()
                .generateScreen(parentScreen);
    }
}
