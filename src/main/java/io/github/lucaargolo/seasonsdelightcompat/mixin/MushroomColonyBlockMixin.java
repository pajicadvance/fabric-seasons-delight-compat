package io.github.lucaargolo.seasonsdelightcompat.mixin;

import io.github.lucaargolo.seasons.utils.FertilizableUtil;
import io.github.lucaargolo.seasons.utils.SeasonalFertilizable;
import net.minecraft.block.BlockState;
import net.minecraft.block.Fertilizable;
import net.minecraft.block.PlantBlock;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import vectorwing.farmersdelight.common.block.MushroomColonyBlock;

@Mixin(MushroomColonyBlock.class)
public abstract class MushroomColonyBlockMixin extends PlantBlock implements Fertilizable, SeasonalFertilizable {

    public MushroomColonyBlockMixin(Settings settings) {
        super(settings);
    }

    @Inject(at = @At("HEAD"), method = "grow", cancellable = true)
    public void growInject(ServerWorld world, Random random, BlockPos pos, BlockState state, CallbackInfo ci) {
        FertilizableUtil.growInject(this, world, random, pos, state, ci);
    }

}