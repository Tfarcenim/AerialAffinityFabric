package tfar.aerialaffinity.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import tfar.aerialaffinity.AerialAffinity;

@Mixin(PlayerEntity.class)
abstract class PlayerEntityMixin extends LivingEntity {

	@Inject(method = "getBlockBreakingSpeed",at = @At("RETURN"),cancellable = true)
	private void aerialAffinity(BlockState block, CallbackInfoReturnable<Float> cir){
		if (!this.onGround && EnchantmentHelper.getEquipmentLevel(AerialAffinity.AERIAL_AFFINITY,this) > 0)
		cir.setReturnValue(cir.getReturnValue() * 5);
	}

	public PlayerEntityMixin(EntityType<? extends LivingEntity> type, World world) {
		super(type, world);
	}

}
