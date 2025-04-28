package me.zipestudio.hudless.mixin;

import me.zipestudio.hudless.backend.HudAnimationHandler;
import me.zipestudio.hudless.backend.HudElement;
import me.zipestudio.hudless.client.HLClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.util.math.ColorHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(DrawContext.class)
public class DrawContextMixin {

    //? if =1.21.1 {
    /*@ModifyVariable(
            at = @At("HEAD"),
            method = "drawTexturedQuad(Lnet/minecraft/util/Identifier;IIIIIFFFFFFFF)V",
            argsOnly = true,
            index = 14
    )
    private float injectDraw(float value) {
        if (!HLClient.getConfig().isEnableMod() || !HLClient.getConfig().isEnableFade()) {
            return value;
        }

        HudElement element = HudElement.currentElement;
        if (element == null || element.functionDisabled()) {
            return value;
        }

        return ColorHelper.Argb.getArgb(HudAnimationHandler.getAlpha(), 255, 255, 255);
    }
    *///?} else {
    @ModifyVariable(
            at = @At("HEAD"),
            method = "drawGuiTexture(Ljava/util/function/Function;Lnet/minecraft/util/Identifier;IIIII)V",
            argsOnly = true,
            index = 7
    )
    private int injectDraw(int value) {
        if (!HLClient.getConfig().isEnableMod() || !HLClient.getConfig().isEnableFade()) {
            return value;
        }

        HudElement element = HudElement.currentElement;
        if (element == null || element.functionDisabled()) {
            return value;
        }

        return ColorHelper.getArgb(HudAnimationHandler.getAlpha(), 255, 255, 255);
    }
    //?}
}