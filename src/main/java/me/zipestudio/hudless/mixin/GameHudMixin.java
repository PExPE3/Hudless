package me.zipestudio.hudless.mixin;

import me.zipestudio.hudless.backend.HudConditionHandler;
import net.minecraft.client.gui.hud.InGameHud;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InGameHud.class)
public abstract class GameHudMixin {

    @Inject(method = "tick()V", at = @At("HEAD"))
    private void injectIntoRender(CallbackInfo ci) {
        HudConditionHandler.tick();
    }

}