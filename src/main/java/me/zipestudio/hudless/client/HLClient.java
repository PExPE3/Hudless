package me.zipestudio.hudless.client;

import lombok.Getter;
import me.zipestudio.hudless.backend.HudAnimationHandler;
import me.zipestudio.hudless.config.HLConfig;
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
            HudAnimationHandler.render(delta.getTickDelta(false));
        });

//        HLKeybinding.register();

    }

}
