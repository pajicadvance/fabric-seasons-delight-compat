package io.github.lucaargolo.seasonsdelightcompat.mixin;

import io.github.lucaargolo.seasons.utils.FertilizableUtil;
import io.github.lucaargolo.seasons.utils.SeasonalFertilizable;
import net.minecraft.block.*;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import vectorwing.farmersdelight.common.block.TomatoVineBlock;

@Mixin(TomatoVineBlock.class)
public abstract class TomatoVineBlockMixin extends CropBlock implements Fertilizable, SeasonalFertilizable {

    public TomatoVineBlockMixin(Settings settings) {
        super(settings);
    }

    @Inject(at = @At("HEAD"), method = "randomTick", cancellable = true)
    public void randomTickInject(BlockState state, ServerWorld world, BlockPos pos, Random random, CallbackInfo ci) {
        FertilizableUtil.randomTickInject(this, state, world, pos, random, ci);
    }

    @Inject(at = @At("HEAD"), method = "grow", cancellable = true)
    public void growInject(ServerWorld world, Random random, BlockPos pos, BlockState state, CallbackInfo ci) {
        FertilizableUtil.growInject(this, world, random, pos, state, ci);
    }

}
