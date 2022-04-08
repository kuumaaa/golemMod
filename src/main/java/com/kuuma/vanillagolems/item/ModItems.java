package com.kuuma.vanillagolems.item;

import com.kuuma.vanillagolems.VanillaGolems;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, VanillaGolems.MOD_ID);

    //public static final RegistryObject<Item> testItem = ITEMS.register("testItem", () -> new Item(new Item.Properties().tab(ItemGroup)));



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }











}
