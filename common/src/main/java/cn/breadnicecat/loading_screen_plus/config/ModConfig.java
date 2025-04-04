package cn.breadnicecat.loading_screen_plus.config;

import cn.breadnicecat.loading_screen_plus.LoadingScreenPlus;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;

/**
 * Created in 2025/4/4 03:59
 * Project: loading-screen-plus
 *
 * @author <a href="https://github.com/Bread-Nicecat">Bread_NiceCat</a>
 * <p>
 *
 * <p>
 **/

@Config(name = LoadingScreenPlus.MOD_ID)
public class ModConfig implements ConfigData {
	
	
	@Comment("""
			Whether the memory usage bar should be drawn.
			Default: true
			""")
	public boolean rendersMemoryBar = true;
	
	@Comment("""
			Whether the current hints on the top left should be drawn.
			Default: true
			""")
	public boolean rendersHint = true;
	
	
	@Comment("""
			Declares the background color of the loading screen.
			Default: 15675965
			""")
	@ConfigEntry.ColorPicker
	public int backgroundColor = 0xEF323D;
	
	
	@Comment("""
			Declares the bar color of the loading screen.
			 Whether colors are supported depends on Style.
			Default: 16777215
			""")
	@ConfigEntry.ColorPicker
	public int barColor = 0xFFFFFF;
	
	@Comment("""
			Declares the bar frame color of the loading screen.
			 Whether colors are supported depends on Style.
			Default: 16777215
			""")
	@ConfigEntry.ColorPicker
	public int barFrameColor = 0xFFFFFF;
	
	@Comment("""
			Declares the text color of the loading screen.
			Default: 16777215
			""")
	@ConfigEntry.ColorPicker
	public int textColor = 0xFFFFFF;
	
	
	@Comment("""
			The logo style on the loading screen.
			Enabled Value:['simple','none','mojangster'],
			Default: 'simple'
			""")
	@ConfigEntry.Gui.EnumHandler
	public LogoStyle mojangLogo = LogoStyle.simple;
	
	@Comment("""
			Declares the logo color of the loading screen.
			 Whether colors are supported depends on Style.
			Default: #16777215
			""")
	@ConfigEntry.ColorPicker
	public int logoColor = 0xFFFFFF;
	
}
