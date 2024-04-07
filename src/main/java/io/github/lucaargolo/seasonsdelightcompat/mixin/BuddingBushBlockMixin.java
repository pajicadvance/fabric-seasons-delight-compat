package io.github.lucaargolo.seasonsdelightcompat.mixin;

import io.github.lucaargolo.seasons.utils.FertilizableUtil;
import net.minecraft.block.Block;
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
import vectorwing.farmersdelight.common.block.BuddingBushBlock;

@Mixin(BuddingBushBlock.class)
public abstract class BuddingBushBlockMixin extends PlantBlock {

    public BuddingBushBlockMixin(Settings settings) {
        super(settings);
    }

    @Inject(at = @At("HEAD"), method = "randomTick", cancellable = true)
    public void randomTickInject(BlockState state, ServerWorld world, BlockPos pos, Random random, CallbackInfo ci) {
        BuddingBushBlock buddingBushBlock = (BuddingBushBlock) (Object) this;
        if(buddingBushBlock instanceof Fertilizable) {
            FertilizableUtil.randomTickInject((Block & Fertilizable) buddingBushBlock, state, world, pos, random, ci);
        }
    }

}
