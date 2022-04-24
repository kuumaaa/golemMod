package com.kuuma.events;

import com.kuuma.vanillagolems.VanillaGolems;
import com.kuuma.vanillagolems.entity.ModEntityTypes;
import com.kuuma.vanillagolems.entity.custom.BuffZombieEntity;
import com.kuuma.vanillagolems.entity.custom.IceGolemEntity;
import com.kuuma.vanillagolems.entity.custom.ObsidianGolemEntity;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = VanillaGolems.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CommonModEvents {


    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntityTypes.BUFF_ZOMBIE.get(), BuffZombieEntity.setCustomAttributes().build());
        event.put(ModEntityTypes.OBSIDIAN_GOLEM.get(), ObsidianGolemEntity.setAttributes());
        event.put(ModEntityTypes.ICE_GOLEM.get(), IceGolemEntity.setAttributes());
    }


}
