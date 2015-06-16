import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Cow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

/**
 * Created by martin on 16.06.15.
 */
public class CowShooterListener implements Listener {

    private JavaPlugin plugin;

    public CowShooterListener(JavaPlugin myPlugin) {
        plugin = myPlugin;
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        // if either air or a block has been clicked with left mouse button
        if(event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK) {
            // get the interacting player (from our event)

            Player player = event.getPlayer();

            // check if the player holds LEATHER in hand
            if(player.getItemInHand().getType() == Material.LEATHER) {

                // Get the players location
                Location loc = player.getLocation();

                // from the location, get the direction vector
                Vector v = loc.getDirection();

                // Multiply the direction with a mysterious factor
                v = v.multiply(3.0);

                // Spawn a Cow
                Cow cow = player.getWorld().spawn(loc, Cow.class);

                // Set the cows velocity to out calculated direction
                cow.setVelocity(v);

                // Let the cow burn for 20 seconds
                cow.setFireTicks(20);

                // Create and start the CowTask
                BukkitRunnable task = new CowTask(player.getWorld(), cow);

                task.runTaskTimer(plugin ,0L, 0L);

            }
        }

    }


}
