package cn.breadnicecat.loading_screen_plus.render.component.logo;

import cn.breadnicecat.loading_screen_plus.render.PlusLoadingOverlay;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;

import static java.lang.Math.min;

/**
 * Created in 2025/4/4 08:32
 * Project: loading-screen-plus
 *
 * @author <a href="https://github.com/Bread-Nicecat">Bread_NiceCat</a>
 * <p>
 *
 * <p>
 **/
public class MojangsterLogo extends AbstractLogo {
	public MojangsterLogo() {
		super();
	}
	
	int animSpeed = 11;
	private long animBegin = 0L;
	
	@Override
	public void draw(GuiGraphics guiGraphics, int minX, int minY) {
		long current = System.currentTimeMillis();
		if (animBegin == 0L) animBegin = current;
		
		long currentFrame = Math.min(63, (current - animBegin) / animSpeed);
		
		int windowWidth = guiGraphics.guiWidth();
		int windowHeight = guiGraphics.guiHeight();
		
		float logoHeight = min(windowWidth * 0.75f, windowHeight) / 4f;
		float logoWidth = logoHeight * 4f;
		
		setHeight((int) logoHeight);
		setWidth((int) logoWidth);
		
		ResourceLocation texLocation = PlusLoadingOverlay.MOJANGSTER_DYNAMIC_LOCATION;
		
		guiGraphics.blit(
				texLocation,
				minX, minY,
				(int) logoWidth, (int) logoHeight,
				(int) (currentFrame / 16) * 1024, (currentFrame % 16) * 256,
				1024, 256,
				4096, 4096
		);
	}
}
