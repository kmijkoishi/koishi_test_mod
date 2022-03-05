package com.kmijkoishi.koishitestmod.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab JUST_MIKA = new CreativeModeTab("justmika") {
        @Override
        public ItemStack makeIcon   () {
            return new ItemStack(ModItems.COOKED_MIKAMIUM.get());
        }
    };
}
