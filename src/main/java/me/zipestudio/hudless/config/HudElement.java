package me.zipestudio.hudless.config;

import me.zipestudio.hudless.client.HLClient;

import java.util.function.Supplier;

public enum HudElement {

    STATUS_BARS(() -> HLClient.getConfig().isHideStatusBars()),

    HOTBAR(() -> HLClient.getConfig().isHideHotbar()),
    HELD_ITEM_TOOLTIP(() -> HLClient.getConfig().isHideHeldItemTooltip()),
    INFO_BAR(() -> HLClient.getConfig().isHideExperienceBar()),

    CROSSHAIR(() -> HLClient.getConfig().isHideCrosshair(), false),
    STATUS_EFFECTS(() -> HLClient.getConfig().isHideEffects(), false),
    MOUNT_HEALTH(() -> HLClient.getConfig().isHideMountHealth()),

    SCOREBOARD(() -> HLClient.getConfig().isHideScoreboardSidebar(), false),
    MISC_OVERLAYS(() -> HLClient.getConfig().isHideMicsOverlays(), false);

    private final Supplier<Boolean> configGetter;
    private final boolean useTranslate;

    public static HudElement currentElement = null;

    HudElement(Supplier<Boolean> configGetter) {
        this(configGetter, true);
    }

    HudElement(Supplier<Boolean> configGetter, boolean useTranslate) {
        this.configGetter = configGetter;
        this.useTranslate = useTranslate;
    }

    public boolean functionDisabled() {
        return !configGetter.get();
    }

    public boolean isTranslate() {
        return useTranslate;
    }

}
