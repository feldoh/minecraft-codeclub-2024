
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.dextermod.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.mcreator.dextermod.DextermodMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class DextermodModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, DextermodMod.MODID);
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> DEXTERTAB = REGISTRY.register("dextertab",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.dextermod.dextertab")).icon(() -> new ItemStack(DextermodModBlocks.DEXTER_FACE_BLOCK.get())).displayItems((parameters, tabData) -> {
				tabData.accept(DextermodModBlocks.DEXTER_FUNACE_BLOCK.get().asItem());
				tabData.accept(DextermodModBlocks.DEXTER_HOUSEBLOCK.get().asItem());
				tabData.accept(DextermodModBlocks.ROBHOUSEBLOCK.get().asItem());
			}).withSearchBar().build());

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
		if (tabData.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
			tabData.accept(DextermodModBlocks.DEXTER_FACE_BLOCK.get().asItem());
			tabData.accept(DextermodModBlocks.DEXTER_HOUSEBLOCK.get().asItem());
		} else if (tabData.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
			tabData.accept(DextermodModItems.PLATFORM_WAND.get());
			tabData.accept(DextermodModItems.DEXMENSION.get());
			tabData.accept(DextermodModItems.DEX_ROTATION_WAND.get());
		} else if (tabData.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {
			tabData.accept(DextermodModItems.DEX_CHAIR_SPAWN_EGG.get());
		}
	}
}
