
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.dextermod.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

import net.mcreator.dextermod.item.PlatformWandItem;
import net.mcreator.dextermod.item.DexmensionItem;
import net.mcreator.dextermod.item.DexRotationWandItem;
import net.mcreator.dextermod.DextermodMod;

public class DextermodModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(DextermodMod.MODID);
	public static final DeferredItem<Item> DEXTER_FACE_BLOCK = block(DextermodModBlocks.DEXTER_FACE_BLOCK);
	public static final DeferredItem<Item> PLATFORM_WAND = REGISTRY.register("platform_wand", PlatformWandItem::new);
	public static final DeferredItem<Item> DEXTER_FUNACE_BLOCK = block(DextermodModBlocks.DEXTER_FUNACE_BLOCK);
	public static final DeferredItem<Item> DEXMENSION = REGISTRY.register("dexmension", DexmensionItem::new);
	public static final DeferredItem<Item> DEXTER_HOUSEBLOCK = block(DextermodModBlocks.DEXTER_HOUSEBLOCK);
	public static final DeferredItem<Item> ROBHOUSEBLOCK = block(DextermodModBlocks.ROBHOUSEBLOCK);
	public static final DeferredItem<Item> DEX_CHAIR_SPAWN_EGG = REGISTRY.register("dex_chair_spawn_egg", () -> new DeferredSpawnEggItem(DextermodModEntities.DEX_CHAIR, -1, -1, new Item.Properties()));
	public static final DeferredItem<Item> DEX_ROTATION_WAND = REGISTRY.register("dex_rotation_wand", DexRotationWandItem::new);

	// Start of user code block custom items
	// End of user code block custom items
	private static DeferredItem<Item> block(DeferredHolder<Block, Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}
}
