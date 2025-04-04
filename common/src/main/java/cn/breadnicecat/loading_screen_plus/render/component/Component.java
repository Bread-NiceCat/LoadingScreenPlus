package cn.breadnicecat.loading_screen_plus.render.component;

import cn.breadnicecat.loading_screen_plus.render.IDrawable;
import cn.breadnicecat.loading_screen_plus.utils.Size;

/**
 * Created in 2025/4/3 23:21
 * Project: loading-screen-plus
 *
 * @author <a href="https://github.com/Bread-Nicecat">Bread_NiceCat</a>
 * <p>
 *
 * <p>
 **/
public abstract class Component implements IDrawable {
	public static final int
			HORIZONTAL = 0b01,
			VERTICAL = 0b10,
			HORIZONTAL_AND_VERTICAL = 0b11;
	
	protected Size size;
	
	public Component(Size size) {
		this.size = size;
	}
	
	public int getWidth() {
		return size.getWidth();
	}
	
	public int getHeight() {
		return size.getHeight();
	}
	
	public void setSize(int width, int height) {
		size = size.set(width, height);
	}
	
	public void setWidth(int width) {
		size = size.setWidth(width);
	}
	
	public void setHeight(int height) {
		size = size.setHeight(height);
	}
	
	public void onAttachedToParent(Component parent) {
	}
	
}
