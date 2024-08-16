package net.luka.test_run.block;

import net.luka.test_run.item.Moditems;
import net.luka.testrun;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.apache.commons.compress.compressors.lz77support.LZ77Compressor;
import org.apache.logging.log4j.core.pattern.AbstractStyleNameConverter;

import java.util.function.Supplier;

public class ModBlocks
{
    public static final DeferredRegister<Block>
    BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, testrun.MODID);

    public static final RegistryObject<Block>
            NEWBLOCK = registerBlock("new_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.REDSTONE_BLOCK).sound(SoundType.ANVIL)));
    public static final RegistryObject<Block>
            BALDZOHAIB = registerBlock("baldy",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.ANVIL)));



    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block)
    {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block)
    {
        return Moditems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }


    public static void register(IEventBus eventBus)
    {
        BLOCKS.register(eventBus);
    }
}
