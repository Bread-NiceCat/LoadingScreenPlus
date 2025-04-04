package cn.breadnicecat.loading_screen_plus.render.component.compound;

import cn.breadnicecat.loading_screen_plus.config.ModConfig;
import cn.breadnicecat.loading_screen_plus.utils.Size;
import net.minecraft.client.gui.GuiGraphics;

/**
 * Created in 2025/4/4 20:16
 * Project: loading-screen-plus
 *
 * @author <a href="https://github.com/Bread-Nicecat">Bread_NiceCat</a>
 * <p>
 *
 * <p>
 **/
public class BlankMemoryBar extends MemoryBar {
	public BlankMemoryBar(Size size) {
		super(size);
	}
	
	@Override
	public void draw(GuiGraphics guiGraphics, int x, int y) {
	}
	
	@Override
	public void loadConfig(ModConfig config) {
	}
}
