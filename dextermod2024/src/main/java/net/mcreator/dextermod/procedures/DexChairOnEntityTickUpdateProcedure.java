package net.mcreator.dextermod.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.core.particles.ParticleTypes;

import java.util.ArrayList;

public class DexChairOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity.isVehicle()) {
			world.addParticle(ParticleTypes.FIREWORK, x, (y - 1), z, (-3), 1, 0);
			world.addParticle(ParticleTypes.FIREWORK, x, (y - 1), z, 3, 1, 0);
			world.addParticle(ParticleTypes.FIREWORK, x, (y - 1), z, 0, 1, (-3));
			world.addParticle(ParticleTypes.FIREWORK, x, (y - 1), z, 0, 1, 3);
			if (Mth.nextInt(RandomSource.create(), 1, 100) > 99) {
				for (Entity entityiterator : new ArrayList<>(entity.getPassengers())) {
					entityiterator.stopRiding();
					entityiterator.setDeltaMovement(new Vec3(0, 10, 0));
				}
			}
		}
	}
}
