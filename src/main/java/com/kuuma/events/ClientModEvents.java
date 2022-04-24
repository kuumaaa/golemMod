package com.kuuma.events;

import com.kuuma.vanillagolems.VanillaGolems;
import com.kuuma.vanillagolems.entity.ModEntityTypes;
import com.kuuma.vanillagolems.entity.model.BuffZombieModel;
import com.kuuma.vanillagolems.entity.model.IceGolemModel;
import com.kuuma.vanillagolems.entity.model.ObsidianGolemModel;
import com.kuuma.vanillagolems.entity.render.BuffZombieRenderer;
import com.kuuma.vanillagolems.entity.render.IceGolemRenderer;
import com.kuuma.vanillagolems.entity.render.ObsidianGolemRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = VanillaGolems.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public final class ClientModEvents {

    private ClientModEvents() {}

    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(BuffZombieModel.LAYER_LOCATION, BuffZombieModel::createBodyLayer);
        event.registerLayerDefinition(ObsidianGolemModel.LAYER_LOCATION, ObsidianGolemModel::createBodyLayer);
        event.registerLayerDefinition(IceGolemModel.LAYER_LOCATION, IceGolemModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(ModEntityTypes.BUFF_ZOMBIE.get(), BuffZombieRenderer::new);
        event.registerEntityRenderer(ModEntityTypes.OBSIDIAN_GOLEM.get(), ObsidianGolemRenderer::new);
        event.registerEntityRenderer(ModEntityTypes.ICE_GOLEM.get(), IceGolemRenderer::new);

    }
}
