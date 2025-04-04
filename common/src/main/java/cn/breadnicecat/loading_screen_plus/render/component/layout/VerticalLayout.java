package cn.breadnicecat.loading_screen_plus.render.component.layout;

import cn.breadnicecat.loading_screen_plus.render.component.Component;
import net.minecraft.client.gui.GuiGraphics;

import static java.lang.Math.max;


/**
 * Created in 2025/3/30 11:58
 * Project: loading-screen-plus
 *
 * @author <a href="https://github.com/Bread-Nicecat">Bread_NiceCat</a>
 * <p>
 * one line only one element
 * 一行(长由元素决定)仅一个元素
 * <p>
 **/
public class VerticalLayout extends AbstractLayout {
	public int gap;
	
	public VerticalLayout(int gap) {
		this.gap = gap;
	}
	
	public VerticalLayout() {
		this(0);
	}
	
	public void setGap(int gap) {
		this.gap = gap;
	}
	
	@Override
	public void draw(GuiGraphics guiGraphics, int x, int y) {
		int elementY = y;
		for (Component component : components) {
			component.draw(guiGraphics, x, elementY);
			elementY += (gap + component.getHeight());
		}
	}
	
	@Override
	public int getHeight() {
		if (components.isEmpty()) return 0;
		int sum = 0;
		for (Component component : components) {
			sum += component.getHeight();
		}
		sum += gap * (components.size() - 1);
		return sum;
	}
	
	@Override
	public int getWidth() {
		int m = 0;
		for (Component drawable : components) {
			m = max(m, drawable.getWidth());
		}
		return m;
	}
}
