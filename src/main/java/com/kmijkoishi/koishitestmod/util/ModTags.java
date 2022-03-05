package com.kmijkoishi.koishitestmod.util;

import com.kmijkoishi.koishitestmod.KoishiTestMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;

public class ModTags
{
    public static class Blocks
    {
        public static final TagKey<Block> NAGISA_DOWSING_ROD_VALUABLES = tag("nagisa_dowsing_rod_valuables");

        private static TagKey<Block> tag(String name)
        {
            return BlockTags.create(new ResourceLocation(KoishiTestMod.MOD_ID, name));
        }

        private static TagKey<Block> forgeTag(String name)
        {
            return BlockTags.create(new ResourceLocation("forge", name));
        }

    }

    public static class Items
    {
        public static final Tags.Blocks NAGISA_DOWSING_ROD_VALUABLES = null;

        private static TagKey<Item> tag(String name)
        {
            return ItemTags.create(new ResourceLocation(KoishiTestMod.MOD_ID, name));
        }

        private static TagKey<Item> forgeTag(String name)
        {
            return ItemTags.create(new ResourceLocation("forge", name));
        }

    }
}