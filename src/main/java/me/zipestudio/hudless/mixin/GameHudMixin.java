package me.zipestudio.hudless.mixin;

import me.zipestudio.hudless.backend.HudElement;
import me.zipestudio.hudless.backend.HudAnimationHandler;
import me.zipestudio.hudless.backend.HudConditionHandler;
import me.zipestudio.hudless.client.HLClient;
import me.zipestudio.hudless.config.HLConfig;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.entity.JumpingMount;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.scoreboard.ScoreboardObjective;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InGameHud.class)
public abstract class GameHudMixin {

    @Inject(method = "tick()V", at = @At("HEAD"))
    private void injectIntoRender(CallbackInfo ci) {
        HudConditionHandler.tick();
    }

    @Inject(method = "renderExperienceBar", at = @At("HEAD"), cancellable = true)
    private void beforeXpBar(DrawContext context, int x, CallbackInfo ci) {
        HudAnimationHandler.beforeInject(HudElement.EXPERIENCE, context, true, ci);
    }

    @Inject(method = "renderExperienceBar", at = @At("RETURN"))
    private void afterXpBar(DrawContext context, int x, CallbackInfo ci) {
        HudAnimationHandler.afterInject(context);
    }

    @Inject(method = "renderExperienceLevel", at = @At("HEAD"), cancellable = true)
    private void beforeXpLevel(DrawContext context, RenderTickCounter tickCounter, CallbackInfo ci) {
        HudAnimationHandler.beforeInject(HudElement.EXPERIENCE, context, true, ci);
    }

    @Inject(method = "renderExperienceLevel", at = @At("RETURN"))
    private void afterXpLevel(DrawContext context, RenderTickCounter tickCounter, CallbackInfo ci) {
        HudAnimationHandler.afterInject(context);
    }

    @Inject(method = "renderStatusEffectOverlay", at = @At("HEAD"), cancellable = true)
    private void beforeStatusEffects(DrawContext context, RenderTickCounter tickCounter, CallbackInfo ci) {
        HudAnimationHandler.beforeInject(HudElement.EFFECTS, context, false, ci);
    }

    @Inject(method = "renderStatusEffectOverlay", at = @At("RETURN"))
    private void afterStatusEffects(DrawContext context, RenderTickCounter tickCounter, CallbackInfo ci) {
        HudAnimationHandler.afterInject(context);
    }

    @Inject(method = "renderStatusBars", at = @At("HEAD"), cancellable = true)
    private void beforeStatusBars(DrawContext context, CallbackInfo ci) {
        HudAnimationHandler.beforeInject(HudElement.STATUS_BARS, context, true, ci);
    }

    @Inject(method = "renderStatusBars", at = @At("RETURN"))
    private void afterStatusBars(DrawContext context, CallbackInfo ci) {
        HudAnimationHandler.afterInject(context);
    }

    @Inject(method = "renderOverlay", at = @At("HEAD"), cancellable = true)
    private void beforeOverlay(DrawContext context, Identifier texture, float opacity, CallbackInfo ci) {
        HudAnimationHandler.beforeInject(HudElement.OVERLAY, context, true, ci);
    }

    @Inject(method = "renderOverlay", at = @At("RETURN"))
    private void afterOverlay(DrawContext context, Identifier texture, float opacity, CallbackInfo ci) {
        HudAnimationHandler.afterInject(context);
    }

    @Inject(method = "renderScoreboardSidebar(Lnet/minecraft/client/gui/DrawContext;Lnet/minecraft/scoreboard/ScoreboardObjective;)V", at = @At("HEAD"), cancellable = true)
    private void beforeScoreboardSidebar(DrawContext drawContext, ScoreboardObjective objective, CallbackInfo ci) {
        HudAnimationHandler.beforeInject(HudElement.SCOREBOARD, drawContext, false, ci);
    }

    @Inject(method = "renderScoreboardSidebar(Lnet/minecraft/client/gui/DrawContext;Lnet/minecraft/scoreboard/ScoreboardObjective;)V", at = @At("RETURN"))
    private void afterScoreboardSidebar(DrawContext drawContext, ScoreboardObjective objective, CallbackInfo ci) {
        HudAnimationHandler.afterInject(drawContext);
    }

    @Inject(method = "renderHotbar", at = @At("HEAD"), cancellable = true)
    private void beforeHotbar(DrawContext context, RenderTickCounter tickCounter, CallbackInfo ci) {
        HudAnimationHandler.beforeInject(HudElement.HOTBAR, context, true, ci);
    }

    @Inject(method = "renderHotbar", at = @At("RETURN"))
    private void afterHotbar(DrawContext context, RenderTickCounter tickCounter, CallbackInfo ci) {
        HudAnimationHandler.afterInject(context);
    }

    @Inject(method = "renderHeldItemTooltip", at = @At("HEAD"), cancellable = true)
    private void beforeTooltip(DrawContext context, CallbackInfo ci) {
        HudAnimationHandler.beforeInject(HudElement.HELD_ITEM_TOOLTIP, context, true, ci);
    }

    @Inject(method = "renderHeldItemTooltip", at = @At("RETURN"))
    private void afterTooltip(DrawContext context, CallbackInfo ci) {
        HudAnimationHandler.afterInject(context);
    }

    @Inject(method = "renderCrosshair", at = @At("HEAD"), cancellable = true)
    private void beforeCrosshair(DrawContext context, RenderTickCounter tickCounter, CallbackInfo ci) {
        HudAnimationHandler.beforeInject(HudElement.CROSSHAIR, context, false, ci);
    }

    @Inject(method = "renderCrosshair", at = @At("RETURN"))
    private void afterCrosshair(DrawContext context, RenderTickCounter tickCounter, CallbackInfo ci) {
        HudAnimationHandler.afterInject(context);
    }

    @Inject(method = "renderMountJumpBar", at = @At("HEAD"), cancellable = true)
    private void beforeMountJumpBar(JumpingMount mount, DrawContext context, int x, CallbackInfo ci) {
        HudAnimationHandler.beforeInject(HudElement.MOUNT_JUMP, context, true, ci);
    }

    @Inject(method = "renderMountJumpBar", at = @At("RETURN"))
    private void afterMountJumpBar(JumpingMount mount, DrawContext context, int x, CallbackInfo ci) {
        HudAnimationHandler.afterInject(context);
    }

    @Inject(method = "renderMountHealth", at = @At("HEAD"), cancellable = true)
    private void beforeMountHealth(DrawContext context, CallbackInfo ci) {
        HudAnimationHandler.beforeInject(HudElement.MOUNT_HEALTH, context, true, ci);
    }

    @Inject(method = "renderMountHealth", at = @At("RETURN"))
    private void afterMountHealth(DrawContext context, CallbackInfo ci) {
        HudAnimationHandler.afterInject(context);
    }
}