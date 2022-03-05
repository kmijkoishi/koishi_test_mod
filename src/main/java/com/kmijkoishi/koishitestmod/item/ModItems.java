package com.kmijkoishi.koishitestmod.item;

import com.kmijkoishi.koishitestmod.KoishiTestMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems
{
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, KoishiTestMod.MOD_ID);

    public static final RegistryObject<Item> MIKAMIUM = ITEMS.register("mikamium",
            () -> new Item(new Item.Properties()
                    .tab(ModCreativeModeTab.JUST_MIKA)
            ));

    public static final RegistryObject<Item> COOKED_MIKAMIUM = ITEMS.register("cooked_mikamium",
            () -> new Item(new Item.Properties()
                    .tab(ModCreativeModeTab.JUST_MIKA)
            ));

    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }

}