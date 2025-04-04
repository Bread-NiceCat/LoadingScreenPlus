package cn.breadnicecat.loading_screen_plus.render.component.progressbar;

import cn.breadnicecat.loading_screen_plus.utils.Size;
import net.minecraft.client.gui.GuiGraphics;

import static net.minecraft.util.Mth.clamp;

/**
 * Created in 2025/3/30 11:55
 * Project: loading-screen-plus
 *
 * @author <a href="https://github.com/Bread-Nicecat">Bread_NiceCat</a>
 * <p>
 *
 * <p>
 **/
public class TestProgressBar extends SimpleProgressbar {
	private float delta;
	
	public TestProgressBar(Size size) {
		this(size, 0.01f);
	}
	
	public TestProgressBar(Size size, float delta) {
		super(size);
		this.delta = delta;
	}
	
	@Override
	public void draw(GuiGraphics guiGraphics, int minX, int minY) {
		super.draw(guiGraphics, minX, minY);
		progress += delta;
		if (progress > 1f || progress < 0f) {
			delta = -delta;
			progress = clamp(progress, 0f, 1f);
		}
	}
}
