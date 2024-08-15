package net.luka.test_run.item;

import net.luka.testrun;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, testrun.MODID);

    public static final RegistryObject<CreativeModeTab> TESTRUNTAB = CREATIVE_MODE_TABS.register("testruntab",
            ()-> CreativeModeTab.builder().icon(() -> new ItemStack(Moditems.LISIANTHUS.get()))
                    .title(Component.translatable("creativetab.testrun_tab"))
                    .displayItems((pParameters, pOutput) ->
                    {
                        pOutput.accept(Moditems.LISIANTHUS.get());
                        pOutput.accept(Moditems.LISIANTHUS_SEEDS.get());
                    })
                    .build());

    public static void register(IEventBus eventBus)
    {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
