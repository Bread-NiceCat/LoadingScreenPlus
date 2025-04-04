package cn.breadnicecat.loading_screen_plus.config;

import cn.breadnicecat.loading_screen_plus.LoadingScreenPlus;
import cn.breadnicecat.loading_screen_plus.render.component.logo.LogoStyle;
import cn.breadnicecat.loading_screen_plus.render.component.progressbar.ProgressStyle;
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
	
	//===========================================
	//=                Hints                    =
	//===========================================
	
	@Comment("""
			Whether the current hints on the top left should be drawn.
			Default: true
			""")
	public boolean enableHint = true;
	
	@Comment("""
			Whether a simple timer on the top left should be drawn.
			Default: true
			""")
	public boolean enableTimer = true;
	
	@Comment("""
			Whether a fps hint on the top left should be drawn.
			Default: true
			""")
	public boolean enableFps = true;
	
	
	//===========================================
	//=             Memory Bar                  =
	//===========================================
	@Comment("""
			Whether the memory usage bar should be drawn.
			Default: true
			""")
	public boolean enableMemoryBar = true;
	
	@Comment("""
			The color used in memory usage bar when the remaining memory is more than 25%.
			Default: 2263842
			""")
	@ConfigEntry.ColorPicker
	public int memoryGoodColor = 0x228B22;
	
	@Comment("""
			The color used in memory usage bar when the remaining memory is between 25% and 15%.
			Default: 16766720
			""")
	@ConfigEntry.ColorPicker
	public int memoryWarnColor = 0xFFD700;
	
	@Comment("""
			The color used in memory usage bar when the remaining memory is less than 15%.
			Default: 14381203
			""")
	@ConfigEntry.ColorPicker
	public int memoryLowColor = 0xDB7093;
	
	//===========================================
	//=             Progress Bar                =
	//===========================================
	
	@Comment("""
			The progress style on the loading screen.
			Enabled Value:['simple','rainbow_cat'],
			Default: 'simple'
			""")
	public ProgressStyle progressStyle = ProgressStyle.simple;
	
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
	
	
	//===========================================
	//=                 Text                    =
	//===========================================
	
	@Comment("""
			Declares the text color of the loading screen.
			Default: 16777215
			""")
	@ConfigEntry.ColorPicker
	public int textColor = 0xFFFFFF;
	
	//===========================================
	//=                 Logo                    =
	//===========================================
	
	@Comment("""
			The logo style on the loading screen.
			Enabled Value:['simple','none','mojangster'],
			Default: 'mojangster'
			""")
	@ConfigEntry.Gui.EnumHandler
	public LogoStyle mojangLogo = LogoStyle.mojangster;
	
	@Comment("""
			Declares the background color of the loading screen.
			Default: 15675965
			""")
	@ConfigEntry.ColorPicker
	public int backgroundColor = 0xEF323D;
}
