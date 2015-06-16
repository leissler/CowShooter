import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

/**
 * Created by martin on 16.06.15.
 */
public class CowShooterPlugin extends JavaPlugin {
    public static Logger log = Logger.getLogger("Minecraft");

    public void onEnable() {
        log.info("[CowShooter] enabling ...");
        getServer().getPluginManager().registerEvents(new CowShooterListener(this),this);
    }

}
