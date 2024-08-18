package net.luka.test_run.item.custom;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class PlayerTickEventHandler {

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        Player player = event.player;

        // Code that runs every tick for each player
        if (event.phase == TickEvent.Phase.START) {
            boolean hasVoyagerBoots = false;

            // Check if the player has VoyagerBoots in their inventory
            for (ItemStack itemStack : player.getInventory().items) {
                if (itemStack.getItem() instanceof VoyagerBoots) {
                    hasVoyagerBoots = true;
                    break;
                }
            }
            if (VoyagerBoots.isInInventory) {
                player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 220, 2));
                player.setMaxUpStep(1.0f);
                System.out.println("Positive Effect has been done");
            }
            // Only proceed if the state of isInInventory has changed
            if (VoyagerBoots.isInInventory != hasVoyagerBoots) {
                VoyagerBoots.isInInventory = hasVoyagerBoots;

                 if (!VoyagerBoots.isInInventory){
                    player.removeEffect(MobEffects.MOVEMENT_SPEED);
                    player.setMaxUpStep(0.6f);
                    System.out.println("Negative Effect has been done");
                }

                // Debug output to verify the behavior
                System.out.println("VoyagerBoots in inventory: " + VoyagerBoots.isInInventory);
            }
        }
    }
}