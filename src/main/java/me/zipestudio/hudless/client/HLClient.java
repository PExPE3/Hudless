package me.zipestudio.hudless.client;

import lombok.Getter;
import me.zipestudio.hudless.backend.HudAnimationHandler;
import me.zipestudio.hudless.backend.HudElementReplacer;
import me.zipestudio.hudless.config.HLConfig;
import me.zipestudio.hudless.config.HudElement;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;

public class HLClient implements ClientModInitializer {

    @Getter
    private static HLConfig config;

    @Override
    public void onInitializeClient() {
        if (HLConfig.GSON.load()) {
            config = HLConfig.GSON.instance();
        }

        HudRenderCallback.EVENT.register((matrixStack, delta) -> {
            //? if >=1.21.5 {
            HudAnimationHandler.render(delta.getTickProgress(false));
            //?} else {
            /*HudAnimationHandler.render(delta.getTickDelta(false));
            *///?}
        });

        //? if >=1.21.6 {
        HudElementReplacer.register();
        //?}

    }

}
