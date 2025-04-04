package cn.breadnicecat.loading_screen_plus.render.component.compound;

import cn.breadnicecat.loading_screen_plus.config.ModConfig;
import cn.breadnicecat.loading_screen_plus.render.IModConfigLoadable;
import cn.breadnicecat.loading_screen_plus.render.component.Component;
import cn.breadnicecat.loading_screen_plus.render.component.layout.VerticalLayout;
import cn.breadnicecat.loading_screen_plus.render.component.progressbar.SimpleProgressbar;
import cn.breadnicecat.loading_screen_plus.render.component.text.SimpleSingleLineText;
import cn.breadnicecat.loading_screen_plus.utils.Size;
import net.minecraft.client.gui.GuiGraphics;

import static cn.breadnicecat.loading_screen_plus.utils.ModUtils.replaceAlpha;

/**
 * Created in 2025/4/4 16:56
 * Project: loading-screen-plus
 *
 * @author <a href="https://github.com/Bread-Nicecat">Bread_NiceCat</a>
 * <p>
 *
 * <p>
 **/
public class MemoryBar extends Component implements IModConfigLoadable {
	private VerticalLayout baseLayout = new VerticalLayout(2);
	private MemoryProgressBar bar;
	private SimpleSingleLineText text;
	private String memoryText = "Memory Used / Total: %dMB / %dMB";
	private int warnColor = 0xFFFFFFFF, goodColor = 0xFFFFFFFF, lowColor = 0XFFFFFFFF;
	
	public MemoryBar(Size size) {
		super(size);
		baseLayout.addAll(
				this.text = new SimpleSingleLineText(""),
				this.bar = new MemoryProgressBar(size)
		);
	}
	
	@Override
	public void draw(GuiGraphics guiGraphics, int x, int y) {
		Runtime runtime = Runtime.getRuntime();
		int maxMemory = toMB(runtime.maxMemory());
		int totalMemory = toMB(runtime.totalMemory());
		int freeMemory = toMB(runtime.freeMemory());
		int usedMemory = totalMemory - freeMemory;
		
		float usedMemoryPercent = (float) usedMemory / maxMemory;
		float allocatedProgress = (float) totalMemory / maxMemory;
		
		bar.setProgress(usedMemoryPercent);
		bar.barColor = getColor(usedMemoryPercent);
		bar.setAllocatedProgress(allocatedProgress, getColor(allocatedProgress));
		
		text.setText(memoryText.formatted(usedMemory, maxMemory));
		
		baseLayout.draw(guiGraphics, x, y);
	}
	
	@Override
	public void loadConfig(ModConfig config) {
		text.loadConfig(config);
		warnColor = replaceAlpha(config.memoryWarnColor, 0xFF);
		goodColor = replaceAlpha(config.memoryGoodColor, 0xFF);
		lowColor = replaceAlpha(config.memoryLowColor, 0xFF);
	}
	
	private static int toMB(long bytes) {
		return (int) (bytes / 1024L / 1024L);
	}
	
	private int getColor(float percent) {
		if (percent <= 0.75f) {
			return goodColor;
		} else if (percent <= 0.85f) {
			return warnColor;
		} else {
			return lowColor;
		}
	}
	
	static class MemoryProgressBar extends SimpleProgressbar {
		
		private float alf;
		private int alfColor;
		
		MemoryProgressBar(Size size) {
			super(size);
		}
		
		void setAllocatedProgress(float alf, int color) {
			this.alf = alf;
			this.alfColor = color;
		}
		
		@Override
		public void draw(GuiGraphics guiGraphics, int minX, int minY) {
			super.draw(guiGraphics, minX, minY);
			super.draw(guiGraphics, minX, minY);
			//draw allocate line
			int maxX = minX + getWidth();
			int maxY = minY + getHeight();
			int mmin = minX + 1;
			int mmax = maxX - 1;
			int deltam = mmax - mmin;
			int x = (int) (mmin + deltam * alf);
			guiGraphics.fill(x, minY + 1, x + 3, maxY - 1, alfColor);
		}
	}
}
