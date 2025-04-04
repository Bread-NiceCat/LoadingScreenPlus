package cn.breadnicecat.loading_screen_plus.render.component.logo;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.LoadingOverlay;
import net.minecraft.resources.ResourceLocation;

import static java.lang.Math.min;

/**
 * Created in 2025/4/4 04:35
 * Project: loading-screen-plus
 *
 * @author <a href="https://github.com/Bread-Nicecat">Bread_NiceCat</a>
 * <p>
 *
 * <p>
 **/
public class VanillaLogo extends AbstractLogo {
	public VanillaLogo() {
		super();
	}
	
	@Override
	public void draw(GuiGraphics guiGraphics, int minX, int minY) {
		float centerX = minX + getWidth() / 2f;
		float centerY = minY + getHeight() / 2f;
		
		//动态计算 Logo 的高度，确保不超过屏幕尺寸的 1/4
		int windowWidth = guiGraphics.guiWidth();
		int windowHeight = guiGraphics.guiHeight();
		
		float logoHeight = min(windowWidth * 0.75f, windowHeight) / 4f;
		//Logo 高度的一半，用于垂直居中偏移
		float logoHalfHeight = logoHeight / 2f;
		//Logo 的实际宽度（可能基于高度按比例缩放）
		float logoWidth = logoHeight * 4f;
		//Logo 宽度的一半，用于水平居中偏移
		float logoHalfWidth = logoWidth / 2f;
		
		setHeight((int) logoHeight);
		setWidth((int) logoWidth);
		
		//注：`mojangstudios.png`为了满足512x512的尺寸,将右半(512x256)塞到了左半的下面
		
		ResourceLocation texLocation = LoadingOverlay.MOJANG_STUDIOS_LOGO_LOCATION;
		
		guiGraphics.blit(
				texLocation,
				(int) (centerX - logoHalfWidth),   // 水平居中左半部分
				(int) (centerY - logoHalfHeight),  // 垂直居中
				(int) logoHalfWidth,             // 绘制宽度为半宽
				(int) logoHeight,                // 完整高度
				-0.0625F, 0.0F,           // 纹理偏移（左半部分）
				120, 60, 120, 120
		);
		guiGraphics.blit(
				texLocation,
				(int) centerX,                   // 从中心点开始向右绘制
				(int) (centerY - logoHalfHeight),  // 垂直居中
				(int) logoHalfWidth,             // 绘制宽度为半宽
				(int) logoHeight,                // 完整高度
				0.0625F, 60.0F,           // 纹理偏移（右半部分）
				120, 60, 120, 120
		);
	}
}
