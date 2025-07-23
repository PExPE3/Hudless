package me.zipestudio.hudless.mixin;

import com.mojang.blaze3d.pipeline.RenderPipeline;
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

@Mixin(DrawContext.class)
public class DrawContextMixin {

    @ModifyVariable(
            at = @At("HEAD"),
            method = "drawGuiTexture(Lcom/mojang/blaze3d/pipeline/RenderPipeline;Lnet/minecraft/util/Identifier;IIIII)V",
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

}