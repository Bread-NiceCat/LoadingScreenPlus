package cn.breadnicecat.loading_screen_plus.render.component.text;

import cn.breadnicecat.loading_screen_plus.render.component.Component;
import cn.breadnicecat.loading_screen_plus.utils.Size;

/**
 * Created in 2025/4/4 14:54
 * Project: loading-screen-plus
 *
 * @author <a href="https://github.com/Bread-Nicecat">Bread_NiceCat</a>
 * <p>
 *
 * <p>
 **/
public abstract class AbstractText extends Component {
	protected String text;
	
	
	public AbstractText(Size size, String text) {
		super(size);
		this.text = text;
	}
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
		onContentChanged();
	}
	
	protected void onContentChanged() {
	}
}
