package com.kuuma.vanillagolems.block.custom;


import com.kuuma.vanillagolems.entity.ModEntityTypes;
import com.kuuma.vanillagolems.entity.custom.FireGolemEntity;
import com.kuuma.vanillagolems.entity.custom.ObsidianGolemEntity;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Wearable;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.pattern.BlockInWorld;
import net.minecraft.world.level.block.state.pattern.BlockPattern;
import net.minecraft.world.level.block.state.pattern.BlockPatternBuilder;
import net.minecraft.world.level.block.state.predicate.BlockMaterialPredicate;
import net.minecraft.world.level.block.state.predicate.BlockStatePredicate;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.Material;

import javax.annotation.Nullable;
import java.util.function.Predicate;

public class SpiritPumpkinBlock extends HorizontalDirectionalBlock implements Wearable {
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    @Nullable
    private BlockPattern fireGolemBase;
    @Nullable
    private BlockPattern fireGolemFull;
    @Nullable
    private BlockPattern obsidianGolemBase;
    @Nullable
    private BlockPattern obsidianGolemFull;
    private static final Predicate<BlockState> PUMPKINS_PREDICATE = (p_51396_) -> {
        return p_51396_ != null /*&& (p_51396_.is(Blocks.CARVED_PUMPKIN) || p_51396_.is(Blocks.JACK_O_LANTERN))*/;
    };


    public SpiritPumpkinBlock(Properties properties) {
        super(properties);
         this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
    }

    @Override
    public void stepOn(Level pLevel, BlockPos pPos, BlockState pState, Entity pEntity) {
        if (!pLevel.isClientSide()) {
            if (pEntity instanceof LivingEntity) {
                LivingEntity livingEntity = (LivingEntity) pEntity;
                livingEntity.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 2));
            }
        }
        super.stepOn(pLevel, pPos, pState, pEntity);
    }


    public void onPlace(BlockState pState, Level pLevel, BlockPos pPos, BlockState pOldState, boolean pIsMoving) {
        if (!pOldState.is(pState.getBlock())) {
            this.trySpawnGolem(pLevel, pPos);
        }
    }

    public boolean canSpawnGolem(LevelReader pLevel, BlockPos pPos) {
        return this.getOrCreateObsidianGolemBase().find(pLevel, pPos) != null;
    }

    private void trySpawnGolem(Level pLevel, BlockPos pPos) {
        BlockPattern.BlockPatternMatch blockpattern$blockpatternmatch = this.getOrCreateObsidianGolemFull().find(pLevel, pPos);

            if (blockpattern$blockpatternmatch != null) {
                for(int j = 0; j < this.getOrCreateObsidianGolemFull().getWidth(); ++j) {
                    for(int k = 0; k < this.getOrCreateObsidianGolemFull().getHeight(); ++k) {
                        BlockInWorld blockinworld2 = blockpattern$blockpatternmatch.getBlock(j, k, 0);
                        pLevel.setBlock(blockinworld2.getPos(), Blocks.AIR.defaultBlockState(), 2);
                        pLevel.levelEvent(2001, blockinworld2.getPos(), Block.getId(blockinworld2.getState()));
                    }
                }

                BlockPos blockpos = blockpattern$blockpatternmatch.getBlock(1, 2, 0).getPos();
                ObsidianGolemEntity obsidiangolem = ModEntityTypes.OBSIDIAN_GOLEM.get().create(pLevel);
                obsidiangolem.setPlayerCreated(true);
                obsidiangolem.moveTo((double)blockpos.getX() + 0.5D, (double)blockpos.getY() + 0.05D, (double)blockpos.getZ() + 0.5D, 0.0F, 0.0F);
                pLevel.addFreshEntity(obsidiangolem);

                for(ServerPlayer serverplayer1 : pLevel.getEntitiesOfClass(ServerPlayer.class, obsidiangolem.getBoundingBox().inflate(5.0D))) {
                    CriteriaTriggers.SUMMONED_ENTITY.trigger(serverplayer1, obsidiangolem);
                }

                for(int i1 = 0; i1 < this.getOrCreateObsidianGolemFull().getWidth(); ++i1) {
                    for(int j1 = 0; j1 < this.getOrCreateObsidianGolemFull().getHeight(); ++j1) {
                        BlockInWorld blockinworld1 = blockpattern$blockpatternmatch.getBlock(i1, j1, 0);
                        pLevel.blockUpdated(blockinworld1.getPos(), Blocks.AIR);
                    }
                }
            } else {
                blockpattern$blockpatternmatch = this.getOrCreateFireGolemFull().find(pLevel, pPos);
                    for(int i = 0; i < this.getOrCreateFireGolemFull().getHeight(); ++i) {
                        BlockInWorld blockinworld = blockpattern$blockpatternmatch.getBlock(0, i, 0);
                        pLevel.setBlock(blockinworld.getPos(), Blocks.AIR.defaultBlockState(), 2);
                        pLevel.levelEvent(2001, blockinworld.getPos(), Block.getId(blockinworld.getState()));
                    }

                    FireGolemEntity fireGolem = ModEntityTypes.FIRE_GOLEM.get().create(pLevel);
                    BlockPos blockpos1 = blockpattern$blockpatternmatch.getBlock(0, 2, 0).getPos();
                    fireGolem.moveTo((double)blockpos1.getX() + 0.5D, (double)blockpos1.getY() + 0.05D, (double)blockpos1.getZ() + 0.5D, 0.0F, 0.0F);
                    pLevel.addFreshEntity(fireGolem);

                    for(ServerPlayer serverplayer : pLevel.getEntitiesOfClass(ServerPlayer.class, fireGolem.getBoundingBox().inflate(5.0D))) {
                        CriteriaTriggers.SUMMONED_ENTITY.trigger(serverplayer, fireGolem);
                    }

                    for(int l = 0; l < this.getOrCreateFireGolemFull().getHeight(); ++l) {
                        BlockInWorld blockinworld3 = blockpattern$blockpatternmatch.getBlock(0, l, 0);
                        pLevel.blockUpdated(blockinworld3.getPos(), Blocks.AIR);
                    }
            }

    }

    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return this.defaultBlockState().setValue(FACING, pContext.getHorizontalDirection().getOpposite());
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING);
    }

    private BlockPattern getOrCreateObsidianGolemBase() {
        if (this.obsidianGolemBase == null) {
            this.obsidianGolemBase = BlockPatternBuilder.start().aisle("~ ~", "###", "~#~").where('#', BlockInWorld.hasState(BlockStatePredicate.forBlock(Blocks.CRYING_OBSIDIAN))).where('~', BlockInWorld.hasState(BlockMaterialPredicate.forMaterial(Material.AIR))).build();
        }

        return this.obsidianGolemBase;
    }

    private BlockPattern getOrCreateObsidianGolemFull() {
        if (this.obsidianGolemFull == null) {
            this.obsidianGolemFull = BlockPatternBuilder.start().aisle("~^~", "###", "~#~").where('^', BlockInWorld.hasState(PUMPKINS_PREDICATE)).where('#', BlockInWorld.hasState(BlockStatePredicate.forBlock(Blocks.CRYING_OBSIDIAN))).where('~', BlockInWorld.hasState(BlockMaterialPredicate.forMaterial(Material.AIR))).build();
        }

        return this.obsidianGolemFull;
    }




    private BlockPattern getOrCreateFireGolemBase() {
        if (this.fireGolemBase == null) {
            this.fireGolemBase = BlockPatternBuilder.start().aisle(" ", "#", "#").where('#', BlockInWorld.hasState(BlockStatePredicate.forBlock(Blocks.GILDED_BLACKSTONE))).build();
        }

        return this.fireGolemBase;
    }

    private BlockPattern getOrCreateFireGolemFull() {
        if (this.fireGolemFull == null) {
            this.fireGolemFull = BlockPatternBuilder.start().aisle("^", "#", "#").where('^', BlockInWorld.hasState(PUMPKINS_PREDICATE)).where('#', BlockInWorld.hasState(BlockStatePredicate.forBlock(Blocks.GILDED_BLACKSTONE))).build();
        }

        return this.fireGolemFull;
    }
}