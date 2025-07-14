package dev.tellinq.vignettehud.client.mixin;

import net.minecraft.client.gui.GuiIngame;
import dev.tellinq.vignettehud.client.VignetteHUDConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(GuiIngame.class)
public class Mixin_GuiIngame_VignetteOpacity {
    @ModifyArg(
            //#if MC > 1.12.2
            //$$ method = "updateVignetteDarkness",
            //#else
            method = "renderVignette",
            //#endif
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/util/MathHelper;clamp_float(FFF)F"
            ),
            index = 0
    )
    private float vignetteHud$overrideLightLevel(float original) {
        return original * VignetteHUDConfig.darknessMultiplier;
    }

    @ModifyArg(
            //#if MC > 1.12.2
            //$$ method = "updateVignetteDarkness",
            //#else
            method = "renderVignette",
            //#endif
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/util/MathHelper;clamp_float(FFF)F"
            ),
            index = 1
    )
    private float vignetteHud$modifyClampMin(float min) {
        return (VignetteHUDConfig.vignetteType == 1 ? VignetteHUDConfig.staticOpacity : VignetteHUDConfig.minimumOpacity) / 100f;
    }

    @ModifyArg(
            //#if MC > 1.12.2
            //$$ method = "updateVignetteDarkness",
            //#else
            method = "renderVignette",
            //#endif
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/util/MathHelper;clamp_float(FFF)F"
            ),
            index = 2
    )
    private float vignetteHud$modifyClampMax(float max) {
        return (VignetteHUDConfig.vignetteType == 1 ? VignetteHUDConfig.staticOpacity : VignetteHUDConfig.maximumOpacity) / 100f;
    }
}
