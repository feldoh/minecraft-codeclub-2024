
package net.mcreator.dextermod.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.dextermod.entity.DexChairEntity;
import net.mcreator.dextermod.client.model.Modeldexchair;

public class DexChairRenderer extends MobRenderer<DexChairEntity, Modeldexchair<DexChairEntity>> {
	public DexChairRenderer(EntityRendererProvider.Context context) {
		super(context, new Modeldexchair<DexChairEntity>(context.bakeLayer(Modeldexchair.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(DexChairEntity entity) {
		return ResourceLocation.parse("dextermod:textures/entities/dexchair.png");
	}
}
