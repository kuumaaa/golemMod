package com.kuuma.events;

import com.kuuma.vanillagolems.VanillaGolems;
import com.kuuma.vanillagolems.entity.ModEntityTypes;
import com.kuuma.vanillagolems.entity.custom.BuffZombieEntity;
import com.kuuma.vanillagolems.entity.custom.IceGolemEntity;
import com.kuuma.vanillagolems.entity.custom.ObsidianGolemEntity;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(modid = VanillaGolems.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CommonModEvents {

    @SubscribeEvent
    public static void commonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> SpawnPlacements.register(ModEntityTypes.ICE_GOLEM.get(),SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE,IceGolemEntity::canSpawn));
    }


    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntityTypes.BUFF_ZOMBIE.get(), BuffZombieEntity.setCustomAttributes().build());
        event.put(ModEntityTypes.OBSIDIAN_GOLEM.get(), ObsidianGolemEntity.setAttributes());
        event.put(ModEntityTypes.ICE_GOLEM.get(), IceGolemEntity.setAttributes());
    }


}
