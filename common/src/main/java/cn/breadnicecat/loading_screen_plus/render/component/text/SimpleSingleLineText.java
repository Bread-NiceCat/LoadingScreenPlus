package cn.breadnicecat.loading_screen_plus.render.component.text;

import cn.breadnicecat.loading_screen_plus.config.ModConfig;
import cn.breadnicecat.loading_screen_plus.render.IModConfigLoadable;
import cn.breadnicecat.loading_screen_plus.render.ModFontHelper;
import cn.breadnicecat.loading_screen_plus.utils.ModUtils;
import cn.breadnicecat.loading_screen_plus.utils.Size;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;

/**
 * Created in 2025/4/4 14:53
 * Project: loading-screen-plus
 *
 * @author <a href="https://github.com/Bread-Nicecat">Bread_NiceCat</a>
 * <p>
 *
 * <p>
 **/
public class SimpleSingleLineText extends AbstractText implements IModConfigLoadable {
	public int color = 0xffffffff;
	public Font font = ModFontHelper.getFont();
	
	public SimpleSingleLineText(String text) {
		super(Size.ZERO, text);
		onContentChanged();
	}
	
	@Override
	protected void onContentChanged() {
		setSize(font.width(text), font.lineHeight);
	}
	
	@Override
	public void loadConfig(ModConfig config) {
		color = ModUtils.replaceAlpha(config.textColor, 0xff);
	}
	
	@Override
	public void draw(GuiGraphics guiGraphics, int x, int y) {
		guiGraphics.drawString(font, text, x, y, color);
	}
}
