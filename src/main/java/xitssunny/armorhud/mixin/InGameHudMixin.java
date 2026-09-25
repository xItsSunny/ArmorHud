package xitssunny.armorhud.mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GuiIngame.class)
public abstract class InGameHudMixin {

	@Inject(method = "renderGameOverlay", at = @At("RETURN"))
	private void renderArmorHud(float tickDelta, CallbackInfo ci) {
		Minecraft mc = Minecraft.getMinecraft();
		if (mc.thePlayer == null || mc.theWorld == null) return;

		ScaledResolution scaledRes = new ScaledResolution(mc);
		int screenWidth = scaledRes.getScaledWidth();
		int screenHeight = scaledRes.getScaledHeight();
		int startX = (screenWidth / 2) + 91 + 8;
		int startY = screenHeight - 19;

		GlStateManager.pushMatrix();
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		GlStateManager.enableRescaleNormal();
		GlStateManager.enableBlend();
		GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);

		RenderHelper.enableGUIStandardItemLighting();

		int renderIndex = 0;
		for (int i = 3; i >= 0; i--) {
			ItemStack armorStack = mc.thePlayer.getCurrentArmor(i);

			if (armorStack != null) {
				int x = startX + (renderIndex * 20);
				int y = startY;

				mc.getRenderItem().renderItemAndEffectIntoGUI(armorStack, x, y);
				mc.getRenderItem().renderItemOverlayIntoGUI(mc.fontRendererObj, armorStack, x, y, null);

				renderIndex++;
			}
		}

		RenderHelper.disableStandardItemLighting();
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		GlStateManager.disableRescaleNormal();
		GlStateManager.disableBlend();
		GlStateManager.enableDepth();
		GlStateManager.disableLighting();
		GlStateManager.popMatrix();
	}
}
