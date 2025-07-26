package dev.tellinq.vignettehud.client.mixin;

import net.minecraft.client.gui.GuiIngame;
import dev.tellinq.vignettehud.client.VignetteHUDConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

@Mixin(GuiIngame.class)
public class Mixin_GuiIngame_VignetteOpacity {
    @ModifyArgs(
            //#if MC > 1.12.2
            //$$ method = "updateVignetteDarkness",
            //#else
            method = "renderVignette",
            //#endif
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/util/MathHelper;clamp_float(FFF)F"
            )
    )
    private void vignetteHud$modifyOpacity(Args args) {
        float original = args.get(0);

        original *= VignetteHUDConfig.darknessMultiplier;
        float min = (VignetteHUDConfig.vignetteType == 1 ? VignetteHUDConfig.staticOpacity : VignetteHUDConfig.minimumOpacity) / 100f;
        float max = (VignetteHUDConfig.vignetteType == 1 ? VignetteHUDConfig.staticOpacity : VignetteHUDConfig.maximumOpacity) / 100f;

        args.set(0, original);
        args.set(1, min);
        args.set(2, max);
    }

}
