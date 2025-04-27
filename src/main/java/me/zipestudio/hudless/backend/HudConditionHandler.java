package me.zipestudio.hudless.backend;

import me.zipestudio.hudless.client.HLClient;
import me.zipestudio.hudless.config.HLConfig;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.LivingEntity;

public class HudConditionHandler {
    private static int prevSlot;
    private static int prevHealth;
    private static int prevHunger;
    private static int prevArmor;
    private static int prevAir;
    private static int prevEffects;
    private static int prevMountHealth;

    public static void tick() {
        MinecraftClient client = MinecraftClient.getInstance();
        ClientPlayerEntity player = client.player;
        HLConfig config = HLClient.getConfig();

        if (player == null || player.isSpectator()) {
            return;
        }

        //? if <1.21.5 {
        int currentSlot = player.getInventory().selectedSlot;
        //?} else {
         /*int currentSlot = player.getInventory().getSelectedSlot();
        *///?}

        if (currentSlot != prevSlot) {
            prevSlot = currentSlot;

            if (config.isHideHotbar() && config.isTriggerHotbarCondition()) {
                HudAnimationHandler.revealHud();
            }
        }

        int currentHealth = (int) player.getHealth();
        if (currentHealth != prevHealth) {
            prevHealth = currentHealth;

            if (config.isHideStatusBars() && config.isTriggerHealthCondition()) {
                HudAnimationHandler.revealHud();
            }
        }

        int currentHunger = player.getHungerManager().getFoodLevel();
        if (currentHunger != prevHunger) {
            prevHunger = currentHunger;

            if (config.isHideStatusBars() && config.isTriggerHungerCondition()) {
                HudAnimationHandler.revealHud();
            }
        }

        int currentArmor = player.getArmor();
        if (currentArmor != prevArmor) {
            prevArmor = currentArmor;

            if (config.isHideStatusBars() && config.isTriggerArmorCondition()) {
                HudAnimationHandler.revealHud();
            }
        }

        int currentAir = player.getAir();
        if (currentAir != prevAir) {
            prevAir = currentAir;

            if (config.isHideStatusBars() && config.isTriggerAirBubblesCondition()) {
                HudAnimationHandler.revealHud();
            }
        }

        int currentEffects = player.getStatusEffects().size();
        if (currentEffects != prevEffects) {
            prevEffects = currentEffects;

            if (config.isHideEffects() && config.isTriggerEffectsCondition()) {
                HudAnimationHandler.revealHud();
            }
        }

        if (player.hasVehicle() && player.getVehicle() instanceof LivingEntity mount) {
            int mountHealth = (int) mount.getHealth();
            if (mountHealth != prevMountHealth) {
                prevMountHealth = mountHealth;

                if (config.isHideMountHealth() && config.isTriggerMountHealthCondition()) {
                    HudAnimationHandler.revealHud();
                }
            }
        }
    }
}