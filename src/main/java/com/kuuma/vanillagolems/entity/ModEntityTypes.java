package com.kuuma.vanillagolems.entity;

import com.kuuma.vanillagolems.VanillaGolems;
import com.kuuma.vanillagolems.entity.custom.BuffZombieEntity;
import com.kuuma.vanillagolems.entity.custom.ObsidianGolemEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntityTypes {



    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITIES, VanillaGolems.MOD_ID);

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }

    public static final String OBSIDIAN_GOLEM_ID = "obsidian_golem";



    //// CUSTOM ENTITIES

    public static final RegistryObject<EntityType<BuffZombieEntity>> BUFF_ZOMBIE = ENTITY_TYPES.register("buff_zombie",
            () -> EntityType.Builder.of(BuffZombieEntity::new, MobCategory.MONSTER)
                    .sized(1f,3f)
                    .build(new ResourceLocation(VanillaGolems.MOD_ID,"buff_zombie").toString()));



    public static final RegistryObject<EntityType<ObsidianGolemEntity>> OBSIDIAN_GOLEM = ENTITY_TYPES.register(OBSIDIAN_GOLEM_ID,
            () -> EntityType.Builder.of(ObsidianGolemEntity::new, MobCategory.CREATURE).sized(5f, 10f)
                    .build(new ResourceLocation(VanillaGolems.MOD_ID, OBSIDIAN_GOLEM_ID).toString()));


}
