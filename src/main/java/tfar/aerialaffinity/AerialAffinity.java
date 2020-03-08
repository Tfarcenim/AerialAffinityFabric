package tfar.aerialaffinity;

import net.fabricmc.api.ModInitializer;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class AerialAffinity implements ModInitializer {

	public static final EquipmentSlot[] ALL_ARMOR = new EquipmentSlot[]{EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET};

	public static final Enchantment AERIAL_AFFINITY = new AerialAffinityEnchantment(Enchantment.Weight.RARE,ALL_ARMOR);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		Registry.register(Registry.ENCHANTMENT,new Identifier("aerialaffinity","aerial_affinity"),AERIAL_AFFINITY
						);
	}

	public static class AerialAffinityEnchantment extends Enchantment {

		protected AerialAffinityEnchantment(Weight weight, EquipmentSlot[] slotTypes) {
			super(weight, EnchantmentTarget.ARMOR_LEGS, slotTypes);
		}

		public int getMinimumPower(int level) {
			return Enchantments.AQUA_AFFINITY.getMinimumPower(level);
		}

		public int getMaximumPower(int level) {
			return Enchantments.AQUA_AFFINITY.getMaximumPower(level);
		}

		public int getMaximumLevel() {
			return Enchantments.AQUA_AFFINITY.getMaximumLevel();
		}
	}
}
