package net.luka.test_run.effect;

import net.luka.testrun;
import net.minecraft.data.worldgen.features.MiscOverworldFeatures;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Mob;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEffects
{
    public static final DeferredRegister<MobEffect> MOD_EFFECTS
            = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, testrun.MODID);

    public static final RegistryObject<MobEffect> SPEED = MOD_EFFECTS.register("speed",
            () -> new speedeffect(MobEffectCategory.BENEFICIAL, 2020202));

    public static void register(IEventBus eventBus)
    {
        MOD_EFFECTS.register(eventBus);
    }
}
