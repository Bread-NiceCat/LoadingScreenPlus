package cn.breadnicecat.loading_screen_plus.render.component.progressbar;

import cn.breadnicecat.loading_screen_plus.config.ModConfig;
import cn.breadnicecat.loading_screen_plus.utils.Size;
import net.minecraft.client.gui.GuiGraphics;
import org.joml.Math;

/**
 * Created in 2025/3/30 11:19
 * Project: loading-screen-plus
 *
 * @author <a href="https://github.com/Bread-Nicecat">Bread_NiceCat</a>
 * <p>
 *
 * <p>
 **/
public class SimpleProgressbar extends AbstractProgressBar {
	
	/**
	 * The gap between the progress boxes and the bars
	 * 进度条框与进度条之间的间隙
	 */
	public int gap = 1;
	public int frameColor = 0xFFFFFFFF;
	public int barColor = 0XFFFFFFFF;
	
	public SimpleProgressbar(Size size) {
		super(size);
	}
	
	
	@Override
	void loadConfig(ModConfig config) {
		this.barColor = config.barColor;
		this.frameColor = config.barFrameColor;
	}
	
	@Override
	public void draw(GuiGraphics guiGraphics, int minX, int minY) {
		int maxX = minX + getWidth();
		int maxY = minY + getHeight();
		
		int progressWidth = (int) Math.ceil((maxX - minX - gap * 2) * progress);
		
		//progress
		guiGraphics.fill(minX + 1 + gap, minY + 1 + gap, minX + progressWidth, maxY - 1 - gap, barColor);
		//box
		//下边框
		guiGraphics.fill(minX + 1, minY, maxX - 1, minY + 1, frameColor);
		guiGraphics.fill(minX + 1, maxY, maxX - 1, maxY - 1, frameColor);
		guiGraphics.fill(minX, minY, minX + 1, maxY, frameColor);
		guiGraphics.fill(maxX, minY, maxX - 1, maxY, frameColor);
	}
}
