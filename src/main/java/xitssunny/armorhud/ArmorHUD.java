package xitssunny.armorhud;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.ornithemc.osl.entrypoints.api.ModInitializer;

public class ArmorHUD implements ModInitializer {
	public static final Logger LOGGER = LogManager.getLogger("ArmorHUD");

	@Override
	public void init() {
		LOGGER.info("I like bananas! - xItsSunny");
	}
}
