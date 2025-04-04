package cn.breadnicecat.loading_screen_plus.render.component.progressbar;

import cn.breadnicecat.loading_screen_plus.utils.Size;

import java.util.function.Function;

/**
 * Created in 2025/3/30 12:09
 * Project: loading-screen-plus
 *
 * @author <a href="https://github.com/Bread-Nicecat">Bread_NiceCat</a>
 * <p>
 *
 * <p>
 **/
public enum ProgressStyle {
	simple(SimpleProgressbar::new), rainbow_cat(SimpleProgressbar::new);
	
	private final Function<Size, AbstractProgressBar> constructor;
	
	ProgressStyle(Function<Size, AbstractProgressBar> constructor) {
		this.constructor = constructor;
	}
	
	public AbstractProgressBar create(Size size) {
		return constructor.apply(size);
	}
	
	public AbstractProgressBar create(int w, int h) {
		return create(new Size.Immutable(w, h));
	}
}
