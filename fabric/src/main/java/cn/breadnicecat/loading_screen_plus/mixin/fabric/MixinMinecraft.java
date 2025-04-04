package cn.breadnicecat.loading_screen_plus.mixin.fabric;

import cn.breadnicecat.loading_screen_plus.render.PlusLoadingOverlay;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.LoadingOverlay;
import net.minecraft.server.packs.resources.ReloadInstance;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Optional;
import java.util.function.Consumer;

/**
 * Created in 2025/3/30 08:48
 * Project: loading-screen-plus
 *
 * @author <a href="https://github.com/Bread-Nicecat">Bread_NiceCat</a>
 * <p>
 *
 * <p>
 **/
@Mixin(Minecraft.class)
public abstract class MixinMinecraft {
	@Redirect(method = "<init>",
			at = @At(value = "NEW", target = "(Lnet/minecraft/client/Minecraft;Lnet/minecraft/server/packs/resources/ReloadInstance;Ljava/util/function/Consumer;Z)Lnet/minecraft/client/gui/screens/LoadingOverlay;"))
	LoadingOverlay overlay(Minecraft minecraft, ReloadInstance reload, Consumer<Optional<Throwable>> onFinish, boolean fadeIn) {
		return new PlusLoadingOverlay(minecraft, reload, onFinish, fadeIn);
	}
}
