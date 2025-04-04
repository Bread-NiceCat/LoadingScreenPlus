package cn.breadnicecat.loading_screen_plus.forge;

import cn.breadnicecat.loading_screen_plus.LoadingScreenPlus;
import net.minecraftforge.fml.common.Mod;

/**
 * Created in 2025/3/23 11:05
 * Project: better-loading-screen-plus
 *
 * @author <a href="https://github.com/Bread-Nicecat">Bread_NiceCat</a>
 * <p>
 *
 * <p>
 **/
@Mod(LoadingScreenPlus.MOD_ID)
public class BetterLoadingScreenPlusForge {
	public BetterLoadingScreenPlusForge() {
		LoadingScreenPlus.initialize();
	}
}
