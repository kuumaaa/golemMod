package com.kuuma.vanillagolems.entity.render;

import com.kuuma.vanillagolems.VanillaGolems;
import com.kuuma.vanillagolems.entity.custom.ObsidianGolemEntity;
import com.kuuma.vanillagolems.entity.model.ObsidianGolemModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.animal.IronGolem;

public class ObsidianGolemRenderer extends MobRenderer<ObsidianGolemEntity, ObsidianGolemModel<ObsidianGolemEntity>> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(VanillaGolems.MOD_ID, "textures/entities/obsidian_golem.png");

    public ObsidianGolemRenderer(EntityRendererProvider.Context context) {
        super(context, new ObsidianGolemModel<>(context.bakeLayer(ObsidianGolemModel.LAYER_LOCATION)), 1f);
    }

    @Override
    public ResourceLocation getTextureLocation(ObsidianGolemEntity pEntity) {
        return TEXTURE;
    }
}
