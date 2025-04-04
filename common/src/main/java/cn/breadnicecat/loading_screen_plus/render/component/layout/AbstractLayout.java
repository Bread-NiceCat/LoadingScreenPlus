package cn.breadnicecat.loading_screen_plus.render.component.layout;

import cn.breadnicecat.loading_screen_plus.render.component.Component;
import cn.breadnicecat.loading_screen_plus.utils.Size;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created in 2025/4/3 23:21
 * Project: loading-screen-plus
 *
 * @author <a href="https://github.com/Bread-Nicecat">Bread_NiceCat</a>
 * <p>
 *
 * <p>
 **/
public abstract class AbstractLayout extends Component {
	protected List<Component> components = new LinkedList<>();
	
	public AbstractLayout() {
		super(new Size(0, 0));
	}
	
	public Stream<Component> getComponents() {
		return components.stream();
	}
	
	public void add(Component child) {
		components.add(child);
		child.onAttachedToParent(this);
		this.onChildAttached(child);
	}
	
	public void onChildAttached(Component child) {
	}
	
}
