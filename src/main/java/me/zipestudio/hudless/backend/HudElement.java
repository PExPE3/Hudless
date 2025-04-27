package me.zipestudio.hudless.backend;

import me.zipestudio.hudless.client.HLClient;

import java.util.function.Supplier;

public enum HudElement {

    STATUS_BARS(() -> HLClient.getConfig().isHideStatusBars()),
    EXPERIENCE(() -> HLClient.getConfig().isHideExperienceBar()),
    EFFECTS(() -> HLClient.getConfig().isHideEffects()),

    SCOREBOARD(() -> HLClient.getConfig().isHideScoreboardSidebar()),
    OVERLAY(() -> HLClient.getConfig().isHideOverlay()),
    HOTBAR(() -> HLClient.getConfig().isHideHotbar()),
    CROSSHAIR(() -> HLClient.getConfig().isHideCrosshair()),

    HELD_ITEM_TOOLTIP(() -> HLClient.getConfig().isHideHeldItemTooltip()),
    MOUNT_JUMP(() -> HLClient.getConfig().isHideMountJumpBar()),
    MOUNT_HEALTH(() -> HLClient.getConfig().isHideMountHealth());

    private final Supplier<Boolean> configGetter;

    public static HudElement currentElement = null;

    HudElement(Supplier<Boolean> configGetter) {
        this.configGetter = configGetter;
    }

    public boolean functionDisabled() {
        return !configGetter.get();
    }

}
