package cn.breadnicecat.loading_screen_plus.render.component.layout;

import net.minecraft.client.gui.GuiGraphics;

/**
 * Created in 2025/4/4 16:42
 * Project: loading-screen-plus
 *
 * @author <a href="https://github.com/Bread-Nicecat">Bread_NiceCat</a>
 * <p>
 * Simplest Layout: do nothing
 * 叠在一起渲染
 * <p>
 **/
public class LayeredLayout extends AbstractLayout {
	@Override
	public void draw(GuiGraphics guiGraphics, int x, int y) {
		components.forEach(c -> c.draw(guiGraphics, x, y));
	}
}
