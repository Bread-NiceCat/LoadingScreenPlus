package cn.breadnicecat.loading_screen_plus.mixin.forge;

import cn.breadnicecat.loading_screen_plus.render.PlusLoadingOverlay;
import net.minecraft.client.Minecraft;
import net.minecraft.server.packs.resources.ReloadInstance;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Created in 2025/3/30 08:48
 * Project: loading-screen-plus
 *
 * @author <a href="https://github.com/Bread-Nicecat">Bread_NiceCat</a>
 * <p>
 *
 * <p>
 **/
@Mixin(value = Minecraft.class)
//@Mixin(value = DisplayWindow.class)
public abstract class MixinMinecraft {
	@Redirect(method = "<init>",
			at = @At(value = "INVOKE", target = "Lnet/minecraftforge/fml/loading/ImmediateWindowHandler;loadingOverlay(Ljava/util/function/Supplier;Ljava/util/function/Supplier;Ljava/util/function/Consumer;Z)Ljava/util/function/Supplier;"))
	private Supplier<?> overlay(Supplier<Minecraft> mc, Supplier<ReloadInstance> ri, Consumer<Optional<Throwable>> ex, boolean fade) {
		return () -> new PlusLoadingOverlay(mc.get(), ri.get(), ex, fade);
	}

//	@SuppressWarnings("unchecked")
//	@Redirect(method = "loadingOverlay",
//			remap = false,
//			at = @At(value = "INVOKE",
//					target = "Ljava/lang/reflect/Method;invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;",
//					remap = false))
//	private Object loadingOverlay(Method instance, Object o, Object[] obj) {
//		return (Supplier<?>) () -> new PlusLoadingOverlay(
//				(Minecraft) obj[0],
//				(ReloadInstance) obj[1],
//				(Consumer<Optional<Throwable>>) obj[2],
//				(Boolean) obj[3]);
//	}
}
