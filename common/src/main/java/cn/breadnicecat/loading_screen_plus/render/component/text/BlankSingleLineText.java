package cn.breadnicecat.loading_screen_plus.render.component.text;

import cn.breadnicecat.loading_screen_plus.config.ModConfig;
import net.minecraft.client.gui.GuiGraphics;

/**
 * Created in 2025/4/4 16:12
 * Project: loading-screen-plus
 *
 * @author <a href="https://github.com/Bread-Nicecat">Bread_NiceCat</a>
 * <p>
 *
 * <p>
 **/
public class BlankSingleLineText extends SimpleSingleLineText {
	public BlankSingleLineText() {
		super("");
	}
	
	@Override
	public void loadConfig(ModConfig config) {
	}
	
	@Override
	public void draw(GuiGraphics guiGraphics, int x, int y) {
	}
}
