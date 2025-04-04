package cn.breadnicecat.loading_screen_plus.render.component.logo;

import java.util.function.Supplier;

/**
 * Created in 2025/3/30 12:08
 * Project: loading-screen-plus
 *
 * @author <a href="https://github.com/Bread-Nicecat">Bread_NiceCat</a>
 * <p>
 *
 * <p>
 **/
public enum LogoStyle {
	simple(VanillaLogo::new), none(BlankLogo::new), mojangster(MojangsterLogo::new);
	
	private final Supplier<AbstractLogo> constructor;
	
	LogoStyle(Supplier<AbstractLogo> constructor) {
		this.constructor = constructor;
	}
	
	public AbstractLogo create() {
		return constructor.get();
	}
}
