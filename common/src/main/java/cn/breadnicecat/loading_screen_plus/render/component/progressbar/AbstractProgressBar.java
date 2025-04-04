package cn.breadnicecat.loading_screen_plus.render.component.progressbar;

import cn.breadnicecat.loading_screen_plus.config.ModConfig;
import cn.breadnicecat.loading_screen_plus.render.component.Component;
import cn.breadnicecat.loading_screen_plus.utils.Size;

import static org.joml.Math.clamp;

/**
 * Created in 2025/3/30 10:57
 * Project: loading-screen-plus
 *
 * @author <a href="https://github.com/Bread-Nicecat">Bread_NiceCat</a>
 * <p>
 *
 * <p>
 **/
public abstract class AbstractProgressBar extends Component {
	
	/**
	 * range:[0,1]
	 */
	public float progress = 0f;
	
	public AbstractProgressBar(Size size) {
		super(size);
	}
	
	
	abstract void loadConfig(ModConfig config);
	
	void setProgress(float progress) {
		this.progress = progress;
	}
	
	void growProgress(float delta) {
		this.progress += delta;
	}
	
	void onProgressUpdate() {
		progress = clamp(0f, 1f, progress);
	}
}
