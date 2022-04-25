package com.kuuma.events;

import com.kuuma.vanillagolems.VanillaGolems;
import com.kuuma.vanillagolems.entity.ModEntityTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = VanillaGolems.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class CommonForgeEvents {

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void biomeLoading(BiomeLoadingEvent event) {


        if(event.getName().equals(new ResourceLocation("minecraft:snowy_peaks")) || event.getName().equals(new ResourceLocation("minecraft:frozen_taiga")) ||
                event.getName().equals(new ResourceLocation("minecraft:snowy_plains")) ||event.getName().equals(new ResourceLocation("minecraft:snowy_slopes"))) {
            event.getSpawns().addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(ModEntityTypes.ICE_GOLEM.get(),1,1,1));
        }
    }



}
