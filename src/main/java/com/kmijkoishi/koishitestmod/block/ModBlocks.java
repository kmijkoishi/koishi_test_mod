package com.kmijkoishi.koishitestmod.block;

import com.kmijkoishi.koishitestmod.KoishiTestMod;
import com.kmijkoishi.koishitestmod.block.custom.GetJunkoedBlock;
import com.kmijkoishi.koishitestmod.item.ModCreativeModeTab;
import com.kmijkoishi.koishitestmod.item.ModItems;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.Nullable;


import java.util.List;
import java.util.function.Supplier;

public class ModBlocks
{
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, KoishiTestMod.MOD_ID);


    public static final RegistryObject<Block> MIKANIUM_BLOCK = registerBlock("mikanium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(3f)
                    .requiresCorrectToolForDrops()
            ),
            ModCreativeModeTab.JUST_MIKA);
    public static final RegistryObject<Block> MIKANIUM_STAIRS = registerBlock("mikanium_stairs",
            () -> new StairBlock(
                    () -> ModBlocks.MIKANIUM_BLOCK.get().defaultBlockState(),
                    BlockBehaviour.Properties.of(Material.METAL)
                    .strength(3f)
                    .requiresCorrectToolForDrops()
            ),
            ModCreativeModeTab.JUST_MIKA);
    public static final RegistryObject<Block> MIKANIUM_SLAB = registerBlock("mikanium_slab",
            () -> new SlabBlock(
                    BlockBehaviour.Properties.of(Material.METAL)
                    .strength(3f)
                    .requiresCorrectToolForDrops()
            ),
            ModCreativeModeTab.JUST_MIKA);
    public static final RegistryObject<Block> MIKANIUM_FENCE = registerBlock("mikanium_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(3f)
                    .requiresCorrectToolForDrops()
            ),
            ModCreativeModeTab.JUST_MIKA);
    public static final RegistryObject<Block> MIKANIUM_FENCE_GATE = registerBlock("mikanium_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(3f)
                    .requiresCorrectToolForDrops()
            ),
            ModCreativeModeTab.JUST_MIKA);
    public static final RegistryObject<Block> MIKANIUM_WALL = registerBlock("mikanium_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(3f)
                    .requiresCorrectToolForDrops()
            ),
            ModCreativeModeTab.JUST_MIKA);


    public static final RegistryObject<Block> MIKANIUM_ORE = registerBlock("mikanium_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(3f)
                    .requiresCorrectToolForDrops()
            ),
            ModCreativeModeTab.JUST_MIKA);

    public static final RegistryObject<Block> PURE_MIKANIUM_BLOCK = registerBlock("pure_mikanium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(6f)
                    .requiresCorrectToolForDrops()
            ),
            ModCreativeModeTab.JUST_MIKA);

    public static final RegistryObject<Block> JUNKO_BLOCK = registerBlock("junko_block",
            () -> new GetJunkoedBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(3f)
                    .requiresCorrectToolForDrops()
            ),
            ModCreativeModeTab.JUST_MIKA,
            "tooltip.koishitestmod.block.junko_block");





    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block,
                                                                    CreativeModeTab tab, String tooltipKey, String shifttooltipKey)
    {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab, tooltipKey, shifttooltipKey);
        return toReturn;
    }

    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                           CreativeModeTab tab, String tooltipKey, String shifttooltipKey)
    {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(tab))
        {
            @Override
            public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
                if(Screen.hasShiftDown())
                {
                    pTooltip.add(new TranslatableComponent(shifttooltipKey));
                }else
                {
                    pTooltip.add(new TranslatableComponent(tooltipKey));
                }
            }
        });
    }




    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block,
                                                                    CreativeModeTab tab, String tooltipKey)
    {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab, tooltipKey);
        return toReturn;
    }

    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                           CreativeModeTab tab, String tooltipKey)
    {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(tab))
        {
            @Override
            public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
                pTooltip.add(new TranslatableComponent(tooltipKey));
            }
        });
    }



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
