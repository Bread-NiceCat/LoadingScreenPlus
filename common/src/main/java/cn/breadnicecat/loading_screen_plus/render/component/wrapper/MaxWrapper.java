package cn.breadnicecat.loading_screen_plus.render.component.wrapper;

import cn.breadnicecat.loading_screen_plus.render.component.Component;
import net.minecraft.client.gui.GuiGraphics;
import org.intellij.lang.annotations.MagicConstant;

/**
 * Created in 2025/4/4 04:38
 * Project: loading-screen-plus
 *
 * @author <a href="https://github.com/Bread-Nicecat">Bread_NiceCat</a>
 * <p>
 * 保证该组件与父组件的大小(轴可选)相同
 * <p>
 **/
public class MaxWrapper extends AbstractWrapper {
	
	private final int type;
	
	public MaxWrapper(
			@MagicConstant(intValues = {HORIZONTAL, VERTICAL, HORIZONTAL_AND_VERTICAL}) int type,
			Component component) {
		super(component);
		this.type = type;
	}
	
	@Override
	public void draw(GuiGraphics guiGraphics, int x, int y) {
		if ((type & VERTICAL) != 0) {
			component.setHeight(parent.getHeight());
		}
		if ((type & HORIZONTAL) != 0) {
			component.setWidth(parent.getWidth());
		}
		component.draw(guiGraphics, x, y);
	}
}
