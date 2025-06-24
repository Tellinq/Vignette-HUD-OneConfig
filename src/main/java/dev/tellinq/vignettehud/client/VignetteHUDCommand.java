package dev.tellinq.vignettehud.client;

import dev.tellinq.vignettehud.VignetteHUDConstants;
import org.polyfrost.oneconfig.api.commands.v1.factories.annotated.Command;
import org.polyfrost.oneconfig.api.commands.v1.factories.annotated.Handler;
import org.polyfrost.oneconfig.utils.v1.dsl.ScreensKt;

@Command(VignetteHUDConstants.ID)
public class VignetteHUDCommand {

    @Handler
    private void main() {
        ScreensKt.openUI(VignetteHUDConfig.INSTANCE);
    }

}
