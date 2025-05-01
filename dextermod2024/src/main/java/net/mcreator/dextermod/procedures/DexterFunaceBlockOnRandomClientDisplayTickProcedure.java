package net.mcreator.dextermod.procedures;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

public class DexterFunaceBlockOnRandomClientDisplayTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double flameSize = 0;
		if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "fuel") > 0) {
			flameSize = (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "fuel") / 1000) * 0.0625;
			if ((getBlockDirection(world, BlockPos.containing(x, y, z))) == Direction.NORTH) {
				world.addParticle(ParticleTypes.FLAME, (x + 0.5), (y + 0.6), (z + 0.1), 0, flameSize, 0);
			} else if ((getBlockDirection(world, BlockPos.containing(x, y, z))) == Direction.SOUTH) {
				world.addParticle(ParticleTypes.FLAME, (x + 0.5), (y + 0.6), (z + 1.1), 0, flameSize, 0);
			} else if ((getBlockDirection(world, BlockPos.containing(x, y, z))) == Direction.EAST) {
				world.addParticle(ParticleTypes.FLAME, (x + 1.1), (y + 0.6), (z + 0.5), 0, flameSize, 0);
			} else if ((getBlockDirection(world, BlockPos.containing(x, y, z))) == Direction.WEST) {
				world.addParticle(ParticleTypes.FLAME, (x + 0.1), (y + 0.6), (z + 0.5), 0, flameSize, 0);
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.campfire.crackle")), SoundSource.AMBIENT, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.campfire.crackle")), SoundSource.AMBIENT, 1, 1, false);
				}
			}
		}
	}

	private static double getBlockNBTNumber(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getDouble(tag);
		return -1;
	}

	private static Direction getBlockDirection(LevelAccessor world, BlockPos pos) {
		BlockState blockState = world.getBlockState(pos);
		Property<?> property = blockState.getBlock().getStateDefinition().getProperty("facing");
		if (property != null && blockState.getValue(property) instanceof Direction direction)
			return direction;
		else if (blockState.hasProperty(BlockStateProperties.AXIS))
			return Direction.fromAxisAndDirection(blockState.getValue(BlockStateProperties.AXIS), Direction.AxisDirection.POSITIVE);
		else if (blockState.hasProperty(BlockStateProperties.HORIZONTAL_AXIS))
			return Direction.fromAxisAndDirection(blockState.getValue(BlockStateProperties.HORIZONTAL_AXIS), Direction.AxisDirection.POSITIVE);
		return Direction.NORTH;
	}
}
