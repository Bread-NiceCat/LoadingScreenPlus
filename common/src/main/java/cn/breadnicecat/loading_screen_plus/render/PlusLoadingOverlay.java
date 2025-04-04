package cn.breadnicecat.loading_screen_plus.render;

import cn.breadnicecat.loading_screen_plus.LoadingScreenPlus;
import cn.breadnicecat.loading_screen_plus.config.ModConfig;
import cn.breadnicecat.loading_screen_plus.render.component.Component;
import cn.breadnicecat.loading_screen_plus.render.component.layout.VerticalLayout;
import cn.breadnicecat.loading_screen_plus.render.component.logo.AbstractLogo;
import cn.breadnicecat.loading_screen_plus.render.component.logo.MojangsterLogo;
import cn.breadnicecat.loading_screen_plus.render.component.progressbar.SimpleProgressbar;
import cn.breadnicecat.loading_screen_plus.render.component.progressbar.TestProgressBar;
import cn.breadnicecat.loading_screen_plus.render.component.wrapper.MaxWrapper;
import cn.breadnicecat.loading_screen_plus.utils.ModUtils;
import cn.breadnicecat.loading_screen_plus.utils.Size;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.LoadingOverlay;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.SimpleTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ReloadInstance;

import java.util.Optional;
import java.util.function.Consumer;

/**
 * Created in 2025/3/30 08:53
 * Project: loading-screen-plus
 *
 * @author <a href="https://github.com/Bread-Nicecat">Bread_NiceCat</a>
 * <p>
 *
 * <p>
 **/
public class PlusLoadingOverlay extends LoadingOverlay {
	public static final ResourceLocation MOJANGSTER_DYNAMIC_LOCATION = ModUtils.prefix("textures/mojangster/dynamic.png");
	
	private final Minecraft minecraft;
	private final ReloadInstance reload;
	private final Consumer<Optional<Throwable>> onFinish;
	private final boolean fadeIn;
	private final ModConfig config;
	
	
	public PlusLoadingOverlay(Minecraft minecraft, ReloadInstance reload, Consumer<Optional<Throwable>> onFinish, boolean fadeIn) {
		super(minecraft, reload, onFinish, fadeIn);
		LoadingScreenPlus.logger.info("PlusLoadingOverlay Loading...");
		this.minecraft = minecraft;
		this.reload = reload;
		this.onFinish = onFinish;
		this.fadeIn = fadeIn;
		this.config = LoadingScreenPlus.config.get();
		minecraft.getTextureManager().register(MOJANGSTER_DYNAMIC_LOCATION, new SimpleTexture(MOJANGSTER_DYNAMIC_LOCATION));
		LoadingScreenPlus.logger.info("PlusLoadingOverlay Loaded.");
	}
	
	public VerticalLayout baseLayout = new VerticalLayout();
	public SimpleProgressbar stepProgressbar0 = new TestProgressBar(new Size(50, 10), 0.02f);
	public SimpleProgressbar stepProgressbar = new TestProgressBar(new Size(100, 10));
	public SimpleProgressbar stepProgressbar1 = new TestProgressBar(new Size(150, 10));
	
	private final AbstractLogo logo = new MojangsterLogo();
	
	{
		baseLayout.setGap(10);
		baseLayout.add(logo);
		baseLayout.add(new MaxWrapper(Component.HORIZONTAL, stepProgressbar0));
		baseLayout.add(new MaxWrapper(Component.HORIZONTAL, stepProgressbar));
		baseLayout.add(new MaxWrapper(Component.HORIZONTAL, stepProgressbar1));
	}
	
	
	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
		int width = guiGraphics.guiWidth();
		int height = guiGraphics.guiHeight();
		
		//bg-color
		guiGraphics.fill(RenderType.guiOverlay(), 0, 0, width, height, replaceAlpha(config.backgroundColor, 0xff));
		int centerX = width / 2 - logo.getWidth() / 2;
		baseLayout.draw(guiGraphics, centerX, 0);
		
	}
	
	private static int replaceAlpha(int color, int alpha) {
		return color & 0xFFFFFF | alpha << 24;
	}
	
	
}
