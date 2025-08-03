package me.zipestudio.hudless.mixin;


import me.zipestudio.hudless.backend.HudAnimationHandler;
import me.zipestudio.hudless.config.HudElement;
import me.zipestudio.hudless.client.HLClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.ColorHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

//? if >=1.21.6 {
import com.mojang.blaze3d.pipeline.RenderPipeline;
//?}

@Mixin(DrawContext.class)
public class DrawContextMixin {

    //? if >=1.21.6 {
    @ModifyVariable(
            at = @At("HEAD"),
            method = "drawTexture(Lcom/mojang/blaze3d/pipeline/RenderPipeline;Lnet/minecraft/util/Identifier;IIFFIIIII)V",
            argsOnly = true,
            index = 11
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
    //?} else if >=1.21.2 {
    /*@ModifyVariable(
            at = @At("HEAD"),
            method = "drawTexture(Ljava/util/function/Function;Lnet/minecraft/util/Identifier;IIFFIIIII)V",
            argsOnly = true,
            index = 11
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
    *///?} else {
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
    *///?}

}