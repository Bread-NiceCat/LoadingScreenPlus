package cn.breadnicecat.loading_screen_plus.fabric;

import cn.breadnicecat.loading_screen_plus.LoadingScreenPlus;
import net.fabricmc.api.ClientModInitializer;


/**
 * Created in 2025/3/23 11:04
 * Project: better-loading-screen-plus
 *
 * @author <a href="https://github.com/Bread-Nicecat">Bread_NiceCat</a>
 * <p>
 *
 * <p>
 **/
public class LoadingScreenPlusFabric implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		LoadingScreenPlus.initialize();
	}
}
