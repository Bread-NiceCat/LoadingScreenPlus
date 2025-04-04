package cn.breadnicecat.loading_screen_plus.utils;

import cn.breadnicecat.loading_screen_plus.LoadingScreenPlus;
import net.minecraft.resources.ResourceLocation;

/**
 * Created in 2025/3/30 09:46
 * Project: loading-screen-plus
 *
 * @author <a href="https://github.com/Bread-Nicecat">Bread_NiceCat</a>
 * <p>
 *
 * <p>
 **/
public class ModUtils {
	public static ResourceLocation prefix(String path) {
		return new ResourceLocation(LoadingScreenPlus.MOD_ID, path);
	}
	
	public static int replaceAlpha(int color, int alpha) {
		return color & 0xFFFFFF | alpha << 24;
	}
}
