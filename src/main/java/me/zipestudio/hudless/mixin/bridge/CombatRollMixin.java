package me.zipestudio.hudless.mixin.bridge;

import me.zipestudio.hudless.backend.HudAnimationHandler;
import me.zipestudio.hudless.config.HudElement;
import net.minecraft.client.gui.DrawContext;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Pseudo
@Mixin(targets = "net.combat_roll.client.gui.HudRenderHelper")
public class CombatRollMixin {

    //? if >=1.21.6 {
    @Inject(
            method = "render(Lnet/minecraft/client/gui/DrawContext;F)V",
            at = @At("HEAD"),
            cancellable = true
    )
    private static void onRenderCombatRollHUD(DrawContext context, float tickDelta) {
        HudAnimationHandler.beforeInject(HudElement.HOTBAR, context, HudElement.HOTBAR.isTranslate());
    }
    //?} else {
    /*@Inject(
            method = "render(Lnet/minecraft/client/gui/DrawContext;F)V",
            at = @At("HEAD"),
            cancellable = true
    )
    private static void onRenderCombatRollHUD(DrawContext context, float tickDelta, CallbackInfo ci) {
        HudAnimationHandler.beforeInject(HudElement.HOTBAR, context, ci);
    }
    *///?}

    @Inject(
            method = "render(Lnet/minecraft/client/gui/DrawContext;F)V",
            at = @At("RETURN")
    )
    private static void afterRenderCombatRollHUD(DrawContext context, float tickDelta, CallbackInfo ci) {
        HudAnimationHandler.afterInject(context);
    }

}
