package me.zipestudio.hudless.backend;

import me.zipestudio.hudless.config.HudElement;
import net.fabricmc.fabric.api.client.rendering.v1.hud.HudElementRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.hud.VanillaHudElements;
import net.minecraft.util.Identifier;

public class HudElementReplacer {

    public static void register() {
        replace(VanillaHudElements.HEALTH_BAR, HudElement.STATUS_BARS);
        replace(VanillaHudElements.ARMOR_BAR, HudElement.STATUS_BARS);
        replace(VanillaHudElements.FOOD_BAR, HudElement.STATUS_BARS);
        replace(VanillaHudElements.AIR_BAR, HudElement.STATUS_BARS);

        replace(VanillaHudElements.HOTBAR, HudElement.HOTBAR);
        replace(VanillaHudElements.HELD_ITEM_TOOLTIP, HudElement.HELD_ITEM_TOOLTIP);
        replace(VanillaHudElements.INFO_BAR, HudElement.INFO_BAR);
        replace(VanillaHudElements.EXPERIENCE_LEVEL, HudElement.INFO_BAR);

        replace(VanillaHudElements.CROSSHAIR, HudElement.CROSSHAIR);
        replace(VanillaHudElements.STATUS_EFFECTS, HudElement.STATUS_EFFECTS);
        replace(VanillaHudElements.MOUNT_HEALTH, HudElement.MOUNT_HEALTH);

        replace(VanillaHudElements.SCOREBOARD, HudElement.SCOREBOARD);
        replace(VanillaHudElements.MISC_OVERLAYS, HudElement.MISC_OVERLAYS);
    }

    private static void replace(Identifier id, HudElement hudElement) {
        HudElementRegistry.replaceElement(id, original -> (drawContext, tick) -> {

            if (!HudAnimationHandler.beforeInject(hudElement, drawContext, hudElement.isTranslate())) {
                return;
            }

            original.render(drawContext, tick);

            HudAnimationHandler.afterInject(drawContext);
        });
    }

}
