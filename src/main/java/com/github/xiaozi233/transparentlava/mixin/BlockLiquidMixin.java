package com.github.xiaozi233.transparentlava.mixin;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.util.EnumWorldBlockLayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BlockLiquid.class)
public abstract class BlockLiquidMixin extends Block {

    public BlockLiquidMixin(Material materialIn) {
        super(materialIn);
    }

    @Inject(method = "getBlockLayer", at = @At("HEAD"), cancellable = true)
    private void injected(CallbackInfoReturnable<EnumWorldBlockLayer> cir){
        cir.setReturnValue(EnumWorldBlockLayer.TRANSLUCENT);
    }
}
