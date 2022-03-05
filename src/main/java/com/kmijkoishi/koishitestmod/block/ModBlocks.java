package com.kmijkoishi.koishitestmod.block;

import com.kmijkoishi.koishitestmod.KoishiTestMod;
import com.kmijkoishi.koishitestmod.item.ModCreativeModeTab;
import com.kmijkoishi.koishitestmod.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import javax.tools.Tool;
import java.util.function.Supplier;

public class ModBlocks
{
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, KoishiTestMod.MOD_ID);


    public static final RegistryObject<Block> MIKAMIUM_BLOCK = registerBlock("mikamium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(3f)
                    .requiresCorrectToolForDrops()
            ),
            ModCreativeModeTab.JUST_MIKA);

    public static final RegistryObject<Block> MIKAMIUM_ORE = registerBlock("mikamium_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(3f)
                    .requiresCorrectToolForDrops()
            ),
            ModCreativeModeTab.JUST_MIKA);


    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab)
    {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                           CreativeModeTab tab)
    {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus)
    {
        BLOCKS.register(eventBus);
    }
}
