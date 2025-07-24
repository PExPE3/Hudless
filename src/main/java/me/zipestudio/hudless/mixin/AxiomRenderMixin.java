package me.zipestudio.hudless.mixin;

import me.zipestudio.hudless.backend.HudAnimationHandler;
import me.zipestudio.hudless.config.HudElement;
import net.minecraft.client.gui.DrawContext;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Pseudo
@Mixin(targets = "com.moulberry.axiom.hooks.ScreenRenderHook")
public class AxiomRenderMixin {

    //? if <=1.21.5 {
    /*@Inject(
            method = "renderHotbar(Lnet/minecraft/class_332;IIF)V",
            at = @At("HEAD"),
            cancellable = true
    )
    private static void onRenderHotbar(DrawContext drawContext, int width, int height, float tickDelta, CallbackInfo ci) {
       HudAnimationHandler.beforeInject(HudElement.HOTBAR, drawContext, ci);
    }

    @Inject(
            method = "renderHotbar(Lnet/minecraft/class_332;IIF)V",
            at = @At("RETURN")
    )
    private static void afterRenderHotbar(DrawContext drawContext, int width, int height, float tickDelta, CallbackInfo ci) {
        HudAnimationHandler.afterInject(drawContext);
    }
    *///?}

}
