package dev.tellinq.vignettehud.client;

import org.polyfrost.oneconfig.api.commands.v1.CommandManager;

public class VignetteHUD {

    public static final VignetteHUD INSTANCE = new VignetteHUD();

    public void initialize() {
        VignetteHUDConfig.INSTANCE.preload();
        CommandManager.register(new VignetteHUDCommand());
    }

}
