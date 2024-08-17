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
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.level.NoteBlockEvent;
import org.apache.commons.lang3.ObjectUtils;

public class VoyagerBoots extends Item
{
    public VoyagerBoots(Properties pProperties)
    {
        super(pProperties);
    }

//    @Override
//    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected)
//    {
//        if (pEntity instanceof Player player)
//        {
//            boolean hasItem = false;
//
//            for (ItemStack itemStack : player.getInventory().items)
//            {
//                if (itemStack.is(this))
//                {
//                    hasItem = true;
//                    break;
//                }
//            }
//
//            if (hasItem)
//            {
//                player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED,20,2));
//                player.setMaxUpStep(1.0f);
//                //player.getAbilities().setWalkingSpeed(0.8f);
//            }
//            if (hasItem == false)
//            {
//                //player.removeEffect(MobEffects.MOVEMENT_SPEED);
//                player.setMaxUpStep(0.3f);
//                //player.getAbilities().setWalkingSpeed(0.1f);
//            }
//        }
//
//    }



    @Override
    public void onInventoryTick(ItemStack stack, Level level, Player player, int slotIndex, int selectedIndex) {

        if (player != null)
        {
            boolean hasItem = false;

            for (ItemStack itemStack : player.getInventory().items)
            {
                if (itemStack.is(this))
                {
                    if (!hasItem) {
                        System.out.println("hasItem changed from false to true");
                    }
                    hasItem = true;
                    break;
                }
            }

            if (hasItem)
            {
                player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 220, 2));
                player.setMaxUpStep(1.0f);
                //player.getAbilities().setWalkingSpeed(0.8f);
            }
            else
            {
                if (player.hasEffect(MobEffects.MOVEMENT_SPEED)) {
                    System.out.println("hasItem is false, removing movement speed effect");
                }
                player.removeEffect(MobEffects.MOVEMENT_SPEED);
                player.setMaxUpStep(0.3f);
                //player.getAbilities().setWalkingSpeed(0.1f);
            }
        }
    }

    //@Override
//    public UseAnim getUseAnimation(ItemStack pStack)
//    {
//        return UseAnim.NONE;
//    }


}