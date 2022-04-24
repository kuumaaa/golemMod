package com.kuuma.vanillagolems.entity.render;

import com.kuuma.vanillagolems.VanillaGolems;
import com.kuuma.vanillagolems.entity.custom.IceGolemEntity;
import com.kuuma.vanillagolems.entity.model.IceGolemModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.animal.IronGolem;

public class IceGolemRenderer extends MobRenderer<IceGolemEntity, IceGolemModel<IceGolemEntity>> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(VanillaGolems.MOD_ID, "textures/entities/ice_golem.png");

    public IceGolemRenderer(EntityRendererProvider.Context context) {
        super(context, new IceGolemModel<>(context.bakeLayer(IceGolemModel.LAYER_LOCATION)), 1f);
    }

    @Override
    public ResourceLocation getTextureLocation(IceGolemEntity pEntity) {
        return TEXTURE;
    }
}
