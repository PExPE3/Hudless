package me.zipestudio.hudless.config;

import dev.isxander.yacl3.config.v2.api.ConfigClassHandler;
import dev.isxander.yacl3.config.v2.api.SerialEntry;
import dev.isxander.yacl3.config.v2.api.serializer.GsonConfigSerializerBuilder;
import dev.isxander.yacl3.platform.YACLPlatform;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class HLConfig {

    public static final ConfigClassHandler<HLConfig> GSON = ConfigClassHandler.createBuilder(HLConfig.class)
            .serializer(config -> GsonConfigSerializerBuilder.create(config)
                    .setPath(YACLPlatform.getConfigDir().resolve("hudless.json"))
                    .build())
            .build();


    // Settings

    @SerialEntry
    private boolean enableMod = true;

    @SerialEntry
    private boolean enableFade = true;

    @SerialEntry
    private int visibleTicks = 100;

    @SerialEntry
    private double hideSpeed = 0.2;

    @SerialEntry
    private double hideFadeSpeed = 0.05;

    @SerialEntry
    private int maxY = 0;

    @SerialEntry
    private int minY = -50;


    // Trigger Conditions
    @SerialEntry
    private boolean triggerHungerCondition = true;

    @SerialEntry
    private boolean triggerHealthCondition = true;

    @SerialEntry
    private boolean triggerHotbarCondition = true;

    @SerialEntry
    private boolean triggerArmorCondition = true;

    @SerialEntry
    private boolean triggerAirBubblesCondition = true;

    @SerialEntry
    private boolean triggerEffectsCondition = true;

    @SerialEntry
    private boolean triggerMountHealthCondition = true;


    // Hud
    @SerialEntry
    private boolean hideStatusBars = true;

    @SerialEntry
    private boolean hideExperienceBar = true;

    @SerialEntry
    private boolean hideEffects = true;

    @SerialEntry
    private boolean hideScoreboardSidebar = true;

    @SerialEntry
    private boolean hideOverlay = true;

    @SerialEntry
    private boolean hideHotbar = true;

    @SerialEntry
    private boolean hideHeldItemTooltip = true;

    @SerialEntry
    private boolean hideCrosshair = true;

    @SerialEntry
    private boolean hideMountJumpBar = true;

    @SerialEntry
    private boolean hideMountHealth = true;

}
