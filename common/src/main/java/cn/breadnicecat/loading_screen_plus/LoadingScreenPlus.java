package cn.breadnicecat.loading_screen_plus;

import cn.breadnicecat.loading_screen_plus.config.ModConfig;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigHolder;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created in 2025/3/23 10:39
 * Project: better-loading-screen
 *
 * @author <a href="https://github.com/Bread-Nicecat">Bread_NiceCat</a>
 * <p>
 *
 * <p>
 **/
@Environment(EnvType.CLIENT)
public class LoadingScreenPlus {
	public static final String MOD_ID = "loading_screen_plus";
	public static final Logger logger = LoggerFactory.getLogger(LoadingScreenPlus.class);
	
	public static ConfigHolder<ModConfig> config;
	
	public LoadingScreenPlus() {
	}
	
	public static void initialize() {
		Class<ModConfig> configClass = ModConfig.class;
		AutoConfig.register(configClass, JanksonConfigSerializer::new);
		config = AutoConfig.getConfigHolder(configClass);
		
	}
	
}
