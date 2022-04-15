package com.kuuma.vanillagolems.entity.render;

import com.kuuma.vanillagolems.VanillaGolems;
import com.kuuma.vanillagolems.entity.custom.BuffZombieEntity;
import com.kuuma.vanillagolems.entity.model.BuffZombieModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class BuffZombieRenderer extends MobRenderer<BuffZombieEntity, BuffZombieModel<BuffZombieEntity>> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(VanillaGolems.MOD_ID, "textures/entities/buff_zombie.png");


    public BuffZombieRenderer(EntityRendererProvider.Context context) {
        super(context, new BuffZombieModel<>(context.bakeLayer(BuffZombieModel.LAYER_LOCATION)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(BuffZombieEntity pEntity) {
        return TEXTURE;
    }
}
