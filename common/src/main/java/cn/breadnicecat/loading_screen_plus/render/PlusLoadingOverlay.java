package cn.breadnicecat.loading_screen_plus.render;

import cn.breadnicecat.loading_screen_plus.LoadingScreenPlus;
import cn.breadnicecat.loading_screen_plus.config.ModConfig;
import cn.breadnicecat.loading_screen_plus.render.component.Blank;
import cn.breadnicecat.loading_screen_plus.render.component.compound.BlankMemoryBar;
import cn.breadnicecat.loading_screen_plus.render.component.compound.MemoryBar;
import cn.breadnicecat.loading_screen_plus.render.component.layout.VerticalLayout;
import cn.breadnicecat.loading_screen_plus.render.component.logo.AbstractLogo;
import cn.breadnicecat.loading_screen_plus.render.component.progressbar.AbstractProgressBar;
import cn.breadnicecat.loading_screen_plus.render.component.text.BlankSingleLineText;
import cn.breadnicecat.loading_screen_plus.render.component.text.SimpleSingleLineText;
import cn.breadnicecat.loading_screen_plus.render.component.text.TimerText;
import cn.breadnicecat.loading_screen_plus.utils.ModUtils;
import cn.breadnicecat.loading_screen_plus.utils.Size;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.LoadingOverlay;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.SimpleTexture;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ReloadInstance;
import net.minecraft.server.packs.resources.ResourceManager;

import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;

import static cn.breadnicecat.loading_screen_plus.utils.ModUtils.prefix;

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
	public static final ResourceLocation MOJANGSTER_DYNAMIC_LOCATION = prefix("textures/mojangster/dynamic.png");
	
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
		ResourceManager resourceManager = minecraft.getResourceManager();
		TextureManager textureManager = minecraft.getTextureManager();
		textureManager.register(MOJANGSTER_DYNAMIC_LOCATION, new SimpleTexture(MOJANGSTER_DYNAMIC_LOCATION));
		ModFontHelper.init(resourceManager, textureManager);
		init();
		LoadingScreenPlus.logger.info("PlusLoadingOverlay Loaded.");
	}
	
	public Set<IModConfigLoadable> configLoadables;
	
	public VerticalLayout baseLayout = new VerticalLayout(10);
	public VerticalLayout hintLayout = new VerticalLayout(1);
	
	public MemoryBar memoryBar;
	public AbstractLogo logo;
	public AbstractProgressBar stepProgressbar;
	
	public SimpleSingleLineText topHint;
	public SimpleSingleLineText timerHint;
	public SimpleSingleLineText fpsHint;
	
	protected void init() {
		logo = config.mojangLogo.create();
		
		Size.Delegate simpleBarSize = new Size.Delegate(() -> logo.getWidth(), () -> 10);
		
		topHint = config.enableHint ? new SimpleSingleLineText("Test T!!est 测试 😀") : new BlankSingleLineText();
		timerHint = config.enableTimer ? new TimerText() : new BlankSingleLineText();
		fpsHint = config.enableFps ? new SimpleSingleLineText(() -> "FPS:" + minecraft.getFps()) : new BlankSingleLineText();
		
		hintLayout.addAll(topHint, fpsHint, timerHint);
		
		memoryBar = config.enableMemoryBar ? new MemoryBar(simpleBarSize) : new BlankMemoryBar(simpleBarSize);
		
		stepProgressbar = config.progressStyle.create(simpleBarSize);
		
		baseLayout.add(new Blank(topHint));
		baseLayout.add(memoryBar);
		baseLayout.add(new Blank(new Size.Immutable(0, 15)));
		baseLayout.add(logo);
		baseLayout.add(new Blank(new Size.Immutable(0, 10)));
		baseLayout.add(stepProgressbar);
		
		configLoadables = Set.of(topHint, fpsHint, timerHint, stepProgressbar, memoryBar);
		configLoadables.forEach(e -> e.loadConfig(config));
	}
	
	
	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
		int width = guiGraphics.guiWidth();
		int height = guiGraphics.guiHeight();
		
		//bg-color
		guiGraphics.fill(RenderType.guiOverlay(), 0, 0, width, height, ModUtils.replaceAlpha(config.backgroundColor, 0xff));
		
		int leftX = (width - logo.getWidth()) / 2;
		baseLayout.draw(guiGraphics, leftX, 0);
		hintLayout.draw(guiGraphics, 2, 2);
	}
	
	
}
