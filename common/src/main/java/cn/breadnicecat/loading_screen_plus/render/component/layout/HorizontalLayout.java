package cn.breadnicecat.loading_screen_plus.render.component.layout;

import cn.breadnicecat.loading_screen_plus.render.component.Component;
import net.minecraft.client.gui.GuiGraphics;

import static java.lang.Math.max;

/**
 * Created in 2025/4/4 00:48
 * Project: loading-screen-plus
 *
 * @author <a href="https://github.com/Bread-Nicecat">Bread_NiceCat</a>
 * <p>
 *
 * <p>
 **/
public class HorizontalLayout extends AbstractLayout {
	public int gap;
	
	public HorizontalLayout(int gap) {
		this.gap = gap;
	}
	
	public HorizontalLayout() {
		this(0);
	}
	
	public void setGap(int gap) {
		this.gap = gap;
	}
	
	@Override
	public void draw(GuiGraphics guiGraphics, int x, int y) {
		int elementX = x;
		for (Component component : components) {
			component.draw(guiGraphics, elementX, y);
			elementX += (component.getWidth() + gap);
		}
	}
	
	
	@Override
	public int getHeight() {
		//效率优先?
		//return drawables.stream().mapToInt(Component::getHeight).max().orElse(0);
		int m = 0;
		for (Component drawable : components) {
			m = max(m, drawable.getHeight());
		}
		return m;
	}
	
	@Override
	public int getWidth() {
		if (components.isEmpty()) return 0;
		int sum = 0;
		for (Component component : components) {
			sum += component.getWidth();
		}
		sum += gap * (components.size() - 1);
		return sum;
		
	}
	
	@Override
	public void add(Component component) {
		super.add(component);
	}
}
