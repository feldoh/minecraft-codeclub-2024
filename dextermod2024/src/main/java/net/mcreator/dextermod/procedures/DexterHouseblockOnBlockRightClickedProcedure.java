package net.mcreator.dextermod.procedures;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

public class DexterHouseblockOnBlockRightClickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double xOffset = 0;
		double yOffset = 0;
		double zOffset = 0;
		xOffset = -2;
		yOffset = 0;
		zOffset = -2;
		for (int index0 = 0; index0 < 5; index0++) {
			for (int index1 = 0; index1 < 5; index1++) {
				world.setBlock(BlockPos.containing(x + xOffset, y - 1, z + zOffset), Blocks.BAMBOO_PLANKS.defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(x + xOffset, y + 3, z + zOffset), Blocks.BAMBOO_PLANKS.defaultBlockState(), 3);
				zOffset = zOffset + 1;
			}
			zOffset = -2;
			xOffset = xOffset + 1;
		}
		xOffset = -2;
		yOffset = 0;
		for (int index2 = 0; index2 < 3; index2++) {
			for (int index3 = 0; index3 < 5; index3++) {
				world.setBlock(BlockPos.containing(x + xOffset, y + yOffset, z + 2), Blocks.OAK_WOOD.defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(x + xOffset, y + yOffset, z - 2), Blocks.BIRCH_WOOD.defaultBlockState(), 3);
				xOffset = xOffset + 1;
			}
			xOffset = -2;
			yOffset = yOffset + 1;
		}
		yOffset = 0;
		zOffset = -2;
		for (int index4 = 0; index4 < 3; index4++) {
			for (int index5 = 0; index5 < 5; index5++) {
				world.setBlock(BlockPos.containing(x + 2, y + yOffset, z + zOffset), Blocks.DIRT.defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(x - 2, y + yOffset, z - zOffset), Blocks.CHERRY_PLANKS.defaultBlockState(), 3);
				zOffset = zOffset + 1;
			}
			zOffset = -2;
			yOffset = yOffset + 1;
		}
		world.setBlock(BlockPos.containing(x + 2, y + 1, z - 1), Blocks.AIR.defaultBlockState(), 3);
		world.setBlock(BlockPos.containing(x + 2, y + 1, z - 1), Blocks.GLASS.defaultBlockState(), 3);
		world.setBlock(BlockPos.containing(x + 2, y + 1, z), Blocks.GLASS.defaultBlockState(), 3);
		world.setBlock(BlockPos.containing(x + 2, y, z + 1), Blocks.AIR.defaultBlockState(), 3);
		world.setBlock(BlockPos.containing(x + 2, y + 1, z + 1), Blocks.AIR.defaultBlockState(), 3);
		world.setBlock(BlockPos.containing(x + 2, y + 1, z + 1), Blocks.OAK_DOOR.defaultBlockState(), 3);
		{
			String _value = "upper";
			BlockPos _pos = BlockPos.containing(x + 2, y + 1, z + 1);
			BlockState _bs = world.getBlockState(_pos);
			if (_bs.getBlock().getStateDefinition().getProperty("half") instanceof EnumProperty _enumProp && _enumProp.getValue(_value).isPresent())
				world.setBlock(_pos, _bs.setValue(_enumProp, (Enum) _enumProp.getValue(_value).get()), 3);
		}
		world.setBlock(BlockPos.containing(x + 2, y + 0, z + 1), Blocks.OAK_DOOR.defaultBlockState(), 3);
		world.setBlock(BlockPos.containing(x, y + 2, z), Blocks.AIR.defaultBlockState(), 3);
		world.setBlock(BlockPos.containing(x, y + 2, z), Blocks.SOUL_LANTERN.defaultBlockState(), 3);
		{
			BlockPos _pos = BlockPos.containing(x, y + 2, z);
			BlockState _bs = world.getBlockState(_pos);
			if (_bs.getBlock().getStateDefinition().getProperty("hanging") instanceof BooleanProperty _booleanProp)
				world.setBlock(_pos, _bs.setValue(_booleanProp, true), 3);
		}
		world.setBlock(BlockPos.containing(x + 3, y + 1, z + 2), (blockStateWithDirection(Blocks.WALL_TORCH.defaultBlockState(), Direction.EAST)), 3);
		world.setBlock(BlockPos.containing(x + 3, y - 1, z + 1), (blockStateWithDirection(Blocks.PURPUR_STAIRS.defaultBlockState(), Direction.WEST)), 3);
		{
			BlockPos _bp = BlockPos.containing(x + 1, y + 0, z - 1);
			BlockState _bs = Blocks.CRAFTING_TABLE.defaultBlockState();
			BlockState _bso = world.getBlockState(_bp);
			for (Property<?> _propertyOld : _bso.getProperties()) {
				Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
				if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
					try {
						_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
					} catch (Exception e) {
					}
			}
			BlockEntity _be = world.getBlockEntity(_bp);
			CompoundTag _bnbt = null;
			if (_be != null) {
				_bnbt = _be.saveWithFullMetadata(world.registryAccess());
				_be.setRemoved();
			}
			world.setBlock(_bp, _bs, 3);
			if (_bnbt != null) {
				_be = world.getBlockEntity(_bp);
				if (_be != null) {
					try {
						_be.loadWithComponents(_bnbt, world.registryAccess());
					} catch (Exception ignored) {
					}
				}
			}
		}
		{
			BlockPos _bp = BlockPos.containing(x + 1, y + 1, z - 1);
			BlockState _bs = Blocks.CHEST.defaultBlockState();
			BlockState _bso = world.getBlockState(_bp);
			for (Property<?> _propertyOld : _bso.getProperties()) {
				Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
				if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
					try {
						_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
					} catch (Exception e) {
					}
			}
			BlockEntity _be = world.getBlockEntity(_bp);
			CompoundTag _bnbt = null;
			if (_be != null) {
				_bnbt = _be.saveWithFullMetadata(world.registryAccess());
				_be.setRemoved();
			}
			world.setBlock(_bp, _bs, 3);
			if (_bnbt != null) {
				_be = world.getBlockEntity(_bp);
				if (_be != null) {
					try {
						_be.loadWithComponents(_bnbt, world.registryAccess());
					} catch (Exception ignored) {
					}
				}
			}
		}
		{
			BlockPos _bp = BlockPos.containing(x - 1, y + 0, z - 1);
			BlockState _bs = Blocks.BLUE_BED.defaultBlockState();
			BlockState _bso = world.getBlockState(_bp);
			for (Property<?> _propertyOld : _bso.getProperties()) {
				Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
				if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
					try {
						_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
					} catch (Exception e) {
					}
			}
			BlockEntity _be = world.getBlockEntity(_bp);
			CompoundTag _bnbt = null;
			if (_be != null) {
				_bnbt = _be.saveWithFullMetadata(world.registryAccess());
				_be.setRemoved();
			}
			world.setBlock(_bp, _bs, 3);
			if (_bnbt != null) {
				_be = world.getBlockEntity(_bp);
				if (_be != null) {
					try {
						_be.loadWithComponents(_bnbt, world.registryAccess());
					} catch (Exception ignored) {
					}
				}
			}
		}
		{
			String _value = "head";
			BlockPos _pos = BlockPos.containing(x - 1, y + 0, z - 1);
			BlockState _bs = world.getBlockState(_pos);
			if (_bs.getBlock().getStateDefinition().getProperty("part") instanceof EnumProperty _enumProp && _enumProp.getValue(_value).isPresent())
				world.setBlock(_pos, _bs.setValue(_enumProp, (Enum) _enumProp.getValue(_value).get()), 3);
		}
		{
			BlockPos _bp = BlockPos.containing(x - 1, y + 0, z - 0);
			BlockState _bs = Blocks.BLUE_BED.defaultBlockState();
			BlockState _bso = world.getBlockState(_bp);
			for (Property<?> _propertyOld : _bso.getProperties()) {
				Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
				if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
					try {
						_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
					} catch (Exception e) {
					}
			}
			BlockEntity _be = world.getBlockEntity(_bp);
			CompoundTag _bnbt = null;
			if (_be != null) {
				_bnbt = _be.saveWithFullMetadata(world.registryAccess());
				_be.setRemoved();
			}
			world.setBlock(_bp, _bs, 3);
			if (_bnbt != null) {
				_be = world.getBlockEntity(_bp);
				if (_be != null) {
					try {
						_be.loadWithComponents(_bnbt, world.registryAccess());
					} catch (Exception ignored) {
					}
				}
			}
		}
	}

	private static BlockState blockStateWithDirection(BlockState blockState, Direction newValue) {
		Property<?> prop = blockState.getBlock().getStateDefinition().getProperty("facing");
		if (prop instanceof DirectionProperty dp && dp.getPossibleValues().contains(newValue))
			return blockState.setValue(dp, newValue);
		prop = blockState.getBlock().getStateDefinition().getProperty("axis");
		return prop instanceof EnumProperty ep && ep.getPossibleValues().contains(newValue.getAxis()) ? blockState.setValue(ep, newValue.getAxis()) : blockState;
	}
}
