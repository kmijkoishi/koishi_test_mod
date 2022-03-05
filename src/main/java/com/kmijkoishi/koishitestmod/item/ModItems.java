package com.kmijkoishi.koishitestmod.item;

import com.kmijkoishi.koishitestmod.KoishiTestMod;
import com.kmijkoishi.koishitestmod.item.custom.FuukaFuel;
import com.kmijkoishi.koishitestmod.item.custom.NagisaDowsingRod;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ModItems
{
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, KoishiTestMod.MOD_ID);

    public static final RegistryObject<Item> MIKANIUM = ITEMS.register("mikanium",
            () -> new Item(new Item.Properties()
                    .tab(ModCreativeModeTab.JUST_MIKA)
            ));

    public static final RegistryObject<Item> COOKED_MIKANIUM = ITEMS.register("cooked_mikanium",
            () -> new Item(new Item.Properties()
                    .tab(ModCreativeModeTab.JUST_MIKA)
            ));

    public static final RegistryObject<Item> FUUKAFUEL = ITEMS.register("fuuka_fuel",
            () -> new FuukaFuel(new Item.Properties()
                    .tab(ModCreativeModeTab.JUST_MIKA)
            ));

    public static final RegistryObject<Item> TASTY_CREDIT = ITEMS.register("tasty_credit",
            () -> new Item(new Item.Properties()
                    .tab(ModCreativeModeTab.JUST_MIKA)
                    .food(ModFoods.TASTY_CREDIT)
            )
            {
                @Override
                public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
                    pTooltipComponents.add(new TranslatableComponent("tooltip.koishitestmod.tasty_credit"));
                }
            });

    public static final RegistryObject<Item> NAGISA_DOWSING_ROD = ITEMS.register("nagisa_dowsing_rod",
            () -> new NagisaDowsingRod(new Item.Properties()
                    .tab(ModCreativeModeTab.JUST_MIKA)
                    .durability(64)
            ));

    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }

}