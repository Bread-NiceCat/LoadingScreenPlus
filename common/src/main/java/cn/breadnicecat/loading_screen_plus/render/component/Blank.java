package cn.breadnicecat.loading_screen_plus.render.component;

import cn.breadnicecat.loading_screen_plus.utils.Size;
import net.minecraft.client.gui.GuiGraphics;

/**
 * Created in 2025/4/4 00:47
 * Project: loading-screen-plus
 *
 * @author <a href="https://github.com/Bread-Nicecat">Bread_NiceCat</a>
 * <p>
 *
 * <p>
 **/
public class Blank extends Component {
	public Blank(Size size) {
		super(size);
	}
	
	public Blank(Component component) {
		this(component.size.delegate());
	}
	
	
	@Override
	public void draw(GuiGraphics guiGraphics, int x, int y) {
	}
}
