package com.kuuma.vanillagolems.entity.render;

import com.kuuma.vanillagolems.VanillaGolems;
import com.kuuma.vanillagolems.entity.custom.FireGolemEntity;
import com.kuuma.vanillagolems.entity.model.FireGolemModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class FireGolemRenderer extends MobRenderer<FireGolemEntity, FireGolemModel<FireGolemEntity>> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(VanillaGolems.MOD_ID, "textures/entities/fire_golem.png");

    public FireGolemRenderer(EntityRendererProvider.Context context) {
        super(context, new FireGolemModel<>(context.bakeLayer(FireGolemModel.LAYER_LOCATION)), 1f);
    }

    @Override
    public ResourceLocation getTextureLocation(FireGolemEntity pEntity) {
        return TEXTURE;
    }
}
