package net.luka.test_run.item;

import net.luka.test_run.item.custom.Foodcan;
import net.luka.test_run.item.custom.VoyagerBoots;
import net.luka.testrun;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Moditems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, testrun.MODID);

    public static final RegistryObject<Item> LISIANTHUS = ITEMS.register("lisianthus",
            ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> LISIANTHUS_SEEDS = ITEMS.register("lisianthusseeds",
            ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> VOYAGERBOOTS = ITEMS.register("voyagerboots",
            ()-> new VoyagerBoots(new Item.Properties().durability(100)));
    public static final RegistryObject<Item> FOODCAN = ITEMS.register("foodcan",
            ()-> new Foodcan(new Item.Properties().durability(100)));


    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
//Marco's comment is better than lukas, Also I know that trump fucked a porn star
}
