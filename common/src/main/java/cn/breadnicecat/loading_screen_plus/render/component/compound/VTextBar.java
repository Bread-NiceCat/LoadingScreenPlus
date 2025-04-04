package cn.breadnicecat.loading_screen_plus.render.component.compound;

import cn.breadnicecat.loading_screen_plus.config.ModConfig;
import cn.breadnicecat.loading_screen_plus.render.IModConfigLoadable;
import cn.breadnicecat.loading_screen_plus.render.component.Component;
import cn.breadnicecat.loading_screen_plus.render.component.layout.VerticalLayout;
import cn.breadnicecat.loading_screen_plus.render.component.progressbar.SimpleProgressbar;
import cn.breadnicecat.loading_screen_plus.render.component.text.SimpleSingleLineText;
import cn.breadnicecat.loading_screen_plus.utils.Size;
import net.minecraft.client.gui.GuiGraphics;

/**
 * Created in 2025/4/4 20:06
 * Project: loading-screen-plus
 *
 * @author <a href="https://github.com/Bread-Nicecat">Bread_NiceCat</a>
 * <p>
 *
 * <p>
 **/
public class VTextBar extends Component implements IModConfigLoadable {
	private VerticalLayout baseLayout = new VerticalLayout(2);
	public SimpleProgressbar bar;
	public SimpleSingleLineText text;
	
	public VTextBar(String textString, Size size) {
		super(size);
		baseLayout.addAll(
				bar = new SimpleProgressbar(size),
				text = new SimpleSingleLineText(textString));
	}
	
	public void update(float progress, String textString) {
		bar.setProgress(progress);
		text.setText(textString);
	}
	
	@Override
	public void draw(GuiGraphics guiGraphics, int x, int y) {
		baseLayout.draw(guiGraphics, x, y);
	}
	
	@Override
	public void loadConfig(ModConfig config) {
		bar.loadConfig(config);
		text.loadConfig(config);
	}
}
