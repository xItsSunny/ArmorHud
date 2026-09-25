package xitssunny.armorhud.config;

import org.polyfrost.oneconfig.api.config.v1.Config;
import org.polyfrost.oneconfig.api.config.v1.annotations.Switch;

public class ArmorHUDConfig extends Config {

	@Switch(title = "ArmorHUD", description = "Toggles the armor HUD on or off.")
	public static boolean enabled = true;

	public ArmorHUDConfig() {
		super("armorhud.json", null, "Armor HUD", Category.QOL);
		initialize(true);
	}
}
