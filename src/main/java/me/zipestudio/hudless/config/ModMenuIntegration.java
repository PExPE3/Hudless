package me.zipestudio.hudless.config;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import dev.isxander.yacl3.api.*;
import dev.isxander.yacl3.gui.controllers.BooleanController;
import dev.isxander.yacl3.gui.controllers.string.number.DoubleFieldController;
import dev.isxander.yacl3.gui.controllers.string.number.IntegerFieldController;
import net.minecraft.text.Text;

public class ModMenuIntegration implements ModMenuApi {

    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return parent -> config().generateScreen(parent);
    }

    public static YetAnotherConfigLib config() {
        return YetAnotherConfigLib.create(HLConfig.GSON, (def, config, builder) -> builder

                .title(Text.translatable("hudless.modmenu.title"))

                .category(ConfigCategory.createBuilder()
                        .name(Text.translatable("hudless.category.general"))
                        .group(OptionGroup.createBuilder()

                                .option(Option.<Boolean>createBuilder()
                                        .name(Text.translatable("hudless.option.enableMod"))
                                        .description(OptionDescription.of(Text.translatable("hudless.option.enableMod.desc")))
                                        .stateManager(StateManager.createSimple(def.isEnableMod(), config::isEnableMod, config::setEnableMod))
                                        .customController(BooleanController::new)
                                        .build())

                                .option(Option.<Boolean>createBuilder()
                                        .name(Text.translatable("hudless.option.enableFade"))
                                        .description(OptionDescription.of(Text.translatable("hudless.option.enableFade.desc")))
                                        .stateManager(StateManager.createSimple(def.isEnableFade(), config::isEnableFade, config::setEnableFade))
                                        .customController(BooleanController::new)
                                        .build())

                                .option(Option.<Integer>createBuilder()
                                        .name(Text.translatable("hudless.option.visibleTicks"))
                                        .description(OptionDescription.of(Text.translatable("hudless.option.visibleTicks.desc")))
                                        .stateManager(StateManager.createSimple(def.getVisibleTicks(), config::getVisibleTicks, config::setVisibleTicks))
                                        .customController(IntegerFieldController::new)
                                        .build())

                                .option(Option.<Double>createBuilder()
                                        .name(Text.translatable("hudless.option.hideSpeed"))
                                        .description(OptionDescription.of(Text.translatable("hudless.option.hideSpeed.desc")))
                                        .stateManager(StateManager.createSimple(def.getHideSpeed(), config::getHideSpeed, config::setHideSpeed))
                                        .customController(DoubleFieldController::new)
                                        .build())

                                .option(Option.<Double>createBuilder()
                                        .name(Text.translatable("hudless.option.hideFadeSpeed"))
                                        .description(OptionDescription.of(Text.translatable("hudless.option.hideFadeSpeed.desc")))
                                        .stateManager(StateManager.createSimple(def.getHideFadeSpeed(), config::getHideFadeSpeed, config::setHideFadeSpeed))
                                        .customController(DoubleFieldController::new)
                                        .build())

//                                .option(Option.<Integer>createBuilder()
//                                        .name(Text.translatable("hudless.option.maxY"))
//                                        .description(OptionDescription.of(Text.translatable("hudless.option.maxY.desc")))
//                                        .stateManager(StateManager.createSimple(def.getMaxY(), config::getMaxY, config::setMaxY))
//                                        .customController(IntegerFieldController::new)
//                                        .build())

                                .option(Option.<Integer>createBuilder()
                                        .name(Text.translatable("hudless.option.minY"))
                                        .description(OptionDescription.of(Text.translatable("hudless.option.minY.desc")))
                                        .stateManager(StateManager.createSimple(def.getMinY(), config::getMinY, config::setMinY))
                                        .customController(IntegerFieldController::new)
                                        .build())

                                .build())
                        .build())

                .category(ConfigCategory.createBuilder()
                        .name(Text.translatable("hudless.category.triggers"))
                        .group(OptionGroup.createBuilder()

                                .option(Option.<Boolean>createBuilder()
                                        .name(Text.translatable("hudless.option.trigger.hunger"))
                                        .description(OptionDescription.of(Text.translatable("hudless.option.trigger.hunger.desc")))
                                        .stateManager(StateManager.createSimple(def.isTriggerHungerCondition(), config::isTriggerHungerCondition, config::setTriggerHungerCondition))
                                        .customController(BooleanController::new)
                                        .build())

                                .option(Option.<Boolean>createBuilder()
                                        .name(Text.translatable("hudless.option.trigger.health"))
                                        .description(OptionDescription.of(Text.translatable("hudless.option.trigger.health.desc")))
                                        .stateManager(StateManager.createSimple(def.isTriggerHealthCondition(), config::isTriggerHealthCondition, config::setTriggerHealthCondition))
                                        .customController(BooleanController::new)
                                        .build())

                                .option(Option.<Boolean>createBuilder()
                                        .name(Text.translatable("hudless.option.trigger.hotbar"))
                                        .description(OptionDescription.of(Text.translatable("hudless.option.trigger.hotbar.desc")))
                                        .stateManager(StateManager.createSimple(def.isTriggerHotbarCondition(), config::isTriggerHotbarCondition, config::setTriggerHotbarCondition))
                                        .customController(BooleanController::new)
                                        .build())

                                .option(Option.<Boolean>createBuilder()
                                        .name(Text.translatable("hudless.option.trigger.armor"))
                                        .description(OptionDescription.of(Text.translatable("hudless.option.trigger.armor.desc")))
                                        .stateManager(StateManager.createSimple(def.isTriggerArmorCondition(), config::isTriggerArmorCondition, config::setTriggerArmorCondition))
                                        .customController(BooleanController::new)
                                        .build())

                                .option(Option.<Boolean>createBuilder()
                                        .name(Text.translatable("hudless.option.trigger.air_bubbles"))
                                        .description(OptionDescription.of(Text.translatable("hudless.option.trigger.air_bubbles.desc")))
                                        .stateManager(StateManager.createSimple(def.isTriggerAirBubblesCondition(), config::isTriggerAirBubblesCondition, config::setTriggerAirBubblesCondition))
                                        .customController(BooleanController::new)
                                        .build())

                                .option(Option.<Boolean>createBuilder()
                                        .name(Text.translatable("hudless.option.trigger.effects"))
                                        .description(OptionDescription.of(Text.translatable("hudless.option.trigger.effects.desc")))
                                        .stateManager(StateManager.createSimple(def.isTriggerEffectsCondition(), config::isTriggerEffectsCondition, config::setTriggerEffectsCondition))
                                        .customController(BooleanController::new)
                                        .build())

                                .option(Option.<Boolean>createBuilder()
                                        .name(Text.translatable("hudless.option.trigger.mount_health"))
                                        .description(OptionDescription.of(Text.translatable("hudless.option.trigger.mount_health.desc")))
                                        .stateManager(StateManager.createSimple(def.isTriggerMountHealthCondition(), config::isTriggerMountHealthCondition, config::setTriggerMountHealthCondition))
                                        .customController(BooleanController::new)
                                        .build())

                                .build())
                        .build())

                .category(ConfigCategory.createBuilder()
                        .name(Text.translatable("hudless.category.hud"))
                        .group(OptionGroup.createBuilder()

                                .option(Option.<Boolean>createBuilder()
                                        .name(Text.translatable("hudless.option.status_bars"))
                                        .description(OptionDescription.of(Text.translatable("hudless.option.status_bars.desc")))
                                        .stateManager(StateManager.createSimple(def.isHideStatusBars(), config::isHideStatusBars, config::setHideStatusBars))
                                        .customController(BooleanController::new)
                                        .build())

                                .option(Option.<Boolean>createBuilder()
                                        .name(Text.translatable("hudless.option.experience"))
                                        .description(OptionDescription.of(Text.translatable("hudless.option.experience.desc")))
                                        .stateManager(StateManager.createSimple(def.isHideExperienceBar(), config::isHideExperienceBar, config::setHideExperienceBar))
                                        .customController(BooleanController::new)
                                        .build())

                                .option(Option.<Boolean>createBuilder()
                                        .name(Text.translatable("hudless.option.effects"))
                                        .description(OptionDescription.of(Text.translatable("hudless.option.effects.desc")))
                                        .stateManager(StateManager.createSimple(def.isHideEffects(), config::isHideEffects, config::setHideEffects))
                                        .customController(BooleanController::new)
                                        .build())

                                .option(Option.<Boolean>createBuilder()
                                        .name(Text.translatable("hudless.option.scoreboard"))
                                        .description(OptionDescription.of(Text.translatable("hudless.option.scoreboard.desc")))
                                        .stateManager(StateManager.createSimple(def.isHideScoreboardSidebar(), config::isHideScoreboardSidebar, config::setHideScoreboardSidebar))
                                        .customController(BooleanController::new)
                                        .build())

                                .option(Option.<Boolean>createBuilder()
                                        .name(Text.translatable("hudless.option.overlay"))
                                        .description(OptionDescription.of(Text.translatable("hudless.option.overlay.desc")))
                                        .stateManager(StateManager.createSimple(def.isHideOverlay(), config::isHideOverlay, config::setHideOverlay))
                                        .customController(BooleanController::new)
                                        .build())

                                .option(Option.<Boolean>createBuilder()
                                        .name(Text.translatable("hudless.option.hotbar"))
                                        .description(OptionDescription.of(Text.translatable("hudless.option.hotbar.desc")))
                                        .stateManager(StateManager.createSimple(def.isHideHotbar(), config::isHideHotbar, config::setHideHotbar))
                                        .customController(BooleanController::new)
                                        .build())

                                .option(Option.<Boolean>createBuilder()
                                        .name(Text.translatable("hudless.option.held_item_tooltip"))
                                        .description(OptionDescription.of(Text.translatable("hudless.option.held_item_tooltip.desc")))
                                        .stateManager(StateManager.createSimple(def.isHideHeldItemTooltip(), config::isHideHeldItemTooltip, config::setHideHeldItemTooltip))
                                        .customController(BooleanController::new)
                                        .build())

                                .option(Option.<Boolean>createBuilder()
                                        .name(Text.translatable("hudless.option.crosshair"))
                                        .description(OptionDescription.of(Text.translatable("hudless.option.crosshair.desc")))
                                        .stateManager(StateManager.createSimple(def.isHideCrosshair(), config::isHideCrosshair, config::setHideCrosshair))
                                        .customController(BooleanController::new)
                                        .build())

                                .option(Option.<Boolean>createBuilder()
                                        .name(Text.translatable("hudless.option.mount_jump"))
                                        .description(OptionDescription.of(Text.translatable("hudless.option.mount_jump.desc")))
                                        .stateManager(StateManager.createSimple(def.isHideMountJumpBar(), config::isHideMountJumpBar, config::setHideMountJumpBar))
                                        .customController(BooleanController::new)
                                        .build())

                                .option(Option.<Boolean>createBuilder()
                                        .name(Text.translatable("hudless.option.mount_health"))
                                        .description(OptionDescription.of(Text.translatable("hudless.option.mount_health.desc")))
                                        .stateManager(StateManager.createSimple(def.isHideMountHealth(), config::isHideMountHealth, config::setHideMountHealth))
                                        .customController(BooleanController::new)
                                        .build())

                                .build())
                        .build())
        );
    }
}