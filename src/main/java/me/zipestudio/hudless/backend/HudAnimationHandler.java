package me.zipestudio.hudless.backend;

import lombok.Getter;
import me.zipestudio.hudless.client.HLClient;
import me.zipestudio.hudless.config.HLConfig;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.util.math.MatrixStack;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Objects;

public class HudAnimationHandler {

    private static double y = 0;
    private static double speed = 0;

    @Getter
    private static int alpha = 255;

    private static long lastRevealed;

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
            lastRevealed = MinecraftClient.getInstance().world.getTime();
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
            if (MinecraftClient.getInstance().world.getTime() - lastRevealed >= config.getVisibleTicks()) {

                if (y > config.getMinY()) {
                    speed += config.getHideSpeed() * delta;
                    y -= speed * delta;
                }

                alpha = Math.max(0, alpha - (int) (config.getHideFadeSpeed() * 255 * delta));

            }
        }
    }

    public static void beforeInject(HudElement element, DrawContext context, boolean useTranslate, CallbackInfo ci) {
        beforeInject(element, context.getMatrices(), useTranslate, ci);
    }

    public static void beforeInject(HudElement element, MatrixStack matrices, boolean useTranslate, CallbackInfo ci) {

        matrices.push();

        HLConfig config = HLClient.getConfig();
        if (!config.isEnableMod() || element.functionDisabled()) {
            return;
        }

        if (y <= config.getMinY() || getAlpha() <= 0) {
            ci.cancel();
            return;
        }

        if (useTranslate) {
            matrices.translate(0, getY(), 0);
        }

        HudElement.currentElement = element;
    }

    public static void afterInject(DrawContext context) {
        afterInject(context.getMatrices());
    }

    public static void afterInject(MatrixStack matrices) {

        matrices.translate(0, HLClient.getConfig().getMaxY(), 0);
        matrices.pop();

        HudElement.currentElement = null;
    }

}