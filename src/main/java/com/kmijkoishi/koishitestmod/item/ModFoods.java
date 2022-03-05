package com.kmijkoishi.koishitestmod.item;

import net.minecraft.world.food.FoodProperties;

public class ModFoods {

    public static final FoodProperties TASTY_CREDIT = (new FoodProperties.Builder())
            .nutrition(4)
            .saturationMod(0.3F)
            .fast()
            .build();

}
