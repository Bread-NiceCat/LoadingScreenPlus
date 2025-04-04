package cn.breadnicecat.loading_screen_plus.render.component.progressbar;

import cn.breadnicecat.loading_screen_plus.render.IModConfigLoadable;
import cn.breadnicecat.loading_screen_plus.render.component.Component;
import cn.breadnicecat.loading_screen_plus.utils.Size;

/**
 * Created in 2025/3/30 10:57
 * Project: loading-screen-plus
 *
 * @author <a href="https://github.com/Bread-Nicecat">Bread_NiceCat</a>
 * <p>
 *
 * <p>
 **/
public abstract class AbstractProgressBar extends Component implements IModConfigLoadable {
	
	/**
	 * range:[0,1]
	 */
	public float progress = 0f;
	
	public AbstractProgressBar(Size size) {
		super(size);
	}
	
	public void setProgress(float progress) {
		this.progress = progress;
	}
	
	public void growProgress(float delta) {
		this.progress += delta;
	}
	
}
