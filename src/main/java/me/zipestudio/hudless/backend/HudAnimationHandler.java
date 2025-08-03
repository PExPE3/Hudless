package me.zipestudio.hudless.backend;

import lombok.Getter;
import me.zipestudio.hudless.client.HLClient;
import me.zipestudio.hudless.config.HLConfig;
import me.zipestudio.hudless.config.HudElement;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;

import java.util.Objects;

//? if >=1.21.6 {
import org.joml.Matrix3x2fStack;
//?} else {
/*import net.minecraft.client.util.math.MatrixStack;
import org.joml.Matrix3x2fStack;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
*///?}

public class HudAnimationHandler {

    private static double y = 0;
    private static double speed = 0;

    @Getter
    private static int alpha = 255;

    private static long lastHudVisibleTime;

    public static double getY() {
        HLConfig config = HLClient.getConfig();
        return -Math.min(Math.max(Objects.isNull(MinecraftClient.getInstance().currentScreen) ? y : config.getMaxY(), config.getMinY()), config.getMaxY());
    }

    public static void revealHud() {
        HLConfig config = HLClient.getConfig();

        y = config.getMaxY();
        speed = 0;
        alpha = 255;

        if (MinecraftClient.getInstance().world != null) {
            lastHudVisibleTime = MinecraftClient.getInstance().world.getTime();
        }
    }

    public static void render(float delta) {
        HLConfig config = HLClient.getConfig();

        if (!config.isEnableMod()) {
            if (y == config.getMaxY() && speed == 0 && alpha == 255) {
                return;
            }
            revealHud();
            return;
        }

        if (MinecraftClient.getInstance().world != null) {
            if (MinecraftClient.getInstance().world.getTime() - lastHudVisibleTime >= config.getVisibleTicks()) {
                if (y > config.getMinY()) {
                    speed += config.getHideSpeed() * delta;
                    y -= speed * delta;
                }
                alpha = Math.max(0, alpha - (int) (config.getHideFadeSpeed() * 255 * delta));
            }
        }
    }

    //? if >=1.21.6 {
    public static boolean beforeInject(HudElement element, DrawContext drawContext, boolean useTranslate) {
        Matrix3x2fStack matrices = drawContext.getMatrices();

        matrices.pushMatrix();
        HLConfig config = HLClient.getConfig();

        if (!config.isEnableMod() || element.functionDisabled()) {
            return true;
        }

        if (y <= config.getMinY() || getAlpha() <= 0) {
            matrices.popMatrix();
            return false;
        }

        if (useTranslate) {
            matrices.translate(0f, (float) getY());
        }

        HudElement.currentElement = element;
        return true;
    }
    //?} else {
    /*public static void beforeInject(HudElement element, DrawContext context, CallbackInfo ci) {
        beforeInject(element, context.getMatrices(), ci);
    }

    public static void beforeInject(HudElement element, MatrixStack matrices, CallbackInfo ci) {
        matrices.push();

        HLConfig config = HLClient.getConfig();
        if (!config.isEnableMod() || element.functionDisabled()) {
            return;
        }

        if (y <= config.getMinY() || getAlpha() <= 0) {
            ci.cancel();
            return;
        }

        if (element.isTranslate()) {
            matrices.translate(0, (float) getY(), 0);
        }

        HudElement.currentElement = element;
    }
    *///?}

    //? if >=1.21.6 {
    public static void afterInject(DrawContext drawContext) {
        Matrix3x2fStack matrices = drawContext.getMatrices();

        matrices.translate(0, HLClient.getConfig().getMaxY());
        matrices.popMatrix();

        HudElement.currentElement = null;
    }
    //?} else {
    /*public static void afterInject(DrawContext context) {
        afterInject(context.getMatrices());
    }

    public static void afterInject(MatrixStack matrices) {
        matrices.translate(0, HLClient.getConfig().getMaxY(), 0);
        matrices.pop();

        HudElement.currentElement = null;
    }
    *///?}
}