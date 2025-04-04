package cn.breadnicecat.loading_screen_plus.render.component.text;

import net.minecraft.client.gui.GuiGraphics;

/**
 * Created in 2025/4/4 20:24
 * Project: loading-screen-plus
 *
 * @author <a href="https://github.com/Bread-Nicecat">Bread_NiceCat</a>
 * <p>
 *
 * <p>
 **/
public class TimerText extends SimpleSingleLineText {
	public long begin = System.currentTimeMillis();
	
	public TimerText() {
		super("Time Used");
	}
	
	@Override
	public void draw(GuiGraphics guiGraphics, int x, int y) {
		long passed = (System.currentTimeMillis() - begin) / 1000;
		setText("Time Used: " + passed / 60 + "m " + passed % 60 + "s");
		super.draw(guiGraphics, x, y);
	}
}
