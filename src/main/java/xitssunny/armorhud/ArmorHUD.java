package xitssunny.armorhud;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.ornithemc.osl.entrypoints.api.ModInitializer;
import xitssunny.armorhud.config.ArmorHUDConfig;

public class ArmorHUD implements ModInitializer {
	public static final Logger LOGGER = LogManager.getLogger("ArmorHUD");
	public static ArmorHUDConfig CONFIG;

	@Override
	public void init() {
		CONFIG = new ArmorHUDConfig();

		LOGGER.info("I like bananas! - xItsSunny");
	}
}
