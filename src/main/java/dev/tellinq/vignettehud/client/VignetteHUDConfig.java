package dev.tellinq.vignettehud.client;

import dev.tellinq.vignettehud.VignetteHUDConstants;
import org.polyfrost.oneconfig.api.config.v1.Config;
import org.polyfrost.oneconfig.api.config.v1.annotations.Number;
import org.polyfrost.oneconfig.api.config.v1.annotations.RadioButton;
import org.polyfrost.oneconfig.api.config.v1.annotations.Slider;

/**
 * The main Config entrypoint that extends the Config type and initializes your config options.
 * See <a href="https://docsv1.polyfrost.org/configuration/available-options">this link</a> for more config Options
 */
public class VignetteHUDConfig extends Config {

    @RadioButton(title = "Vignette Type", options = {"Light Level", "Static Opacity"})
    public static int vignetteType = 0;

    @Slider(
            title = "Static Opacity",
            min = 0f, max = 100f
    )
    public static float staticOpacity = 75f;

    @Number(
            title = "Darkness Multiplier",
            min = 0f, max = 100f
    )
    public static float darknessMultiplier = 1f;

    @Slider(
            title = "Minimum Opacity",
            min = 0f, max = 100f
    )
    public static float minimumOpacity = 0f;

    @Slider(
            title = "Maximum Opacity",
            min = 0f, max = 100f
    )
    public static float maximumOpacity = 100f;

    public static final VignetteHUDConfig INSTANCE = new VignetteHUDConfig(); // The instance of the Config.

    public VignetteHUDConfig() {
        super(VignetteHUDConstants.ID + ".json", VignetteHUDConstants.NAME, Category.OTHER); // TODO: Change your category here.
    }

}

