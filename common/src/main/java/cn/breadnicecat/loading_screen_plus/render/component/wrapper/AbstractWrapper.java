package cn.breadnicecat.loading_screen_plus.render.component.wrapper;

import cn.breadnicecat.loading_screen_plus.render.component.Component;
import cn.breadnicecat.loading_screen_plus.utils.Size;

/**
 * Created in 2025/4/4 04:39
 * Project: loading-screen-plus
 *
 * @author <a href="https://github.com/Bread-Nicecat">Bread_NiceCat</a>
 * <p>
 * Parent-awared Component
 * <p>
 **/
public abstract class AbstractWrapper extends Component {
	protected final Component component;
	protected Component parent;
	
	public AbstractWrapper(Component component) {
		super(new Size(0, 0));
		this.component = component;
	}
	
	@Override
	public void onAttachedToParent(Component parent) {
		component.onAttachedToParent(parent);
		this.parent = parent;
	}
	
	@Override
	public int getWidth() {
		return component.getWidth();
	}
	
	@Override
	public int getHeight() {
		return component.getHeight();
	}
	
	@Override
	public void setHeight(int height) {
		component.setHeight(height);
	}
	
	@Override
	public void setWidth(int width) {
		component.setWidth(width);
	}
	
	
}
