import org.bukkit.World;
import org.bukkit.entity.Cow;
import org.bukkit.scheduler.BukkitRunnable;

/**
 * Created by martin on 16.06.15.
 */
public class CowTask extends BukkitRunnable {
    private World world;
    private Cow cow;

    public CowTask(World myWorld, Cow myCow) {
        cow = myCow;
        world = myWorld;
    }

    public void run() {
        // Check if the cow is on ground
            // create an explosion at cows location
            // call cancel();
        // else (not grounded)
            // set fire ticks to 20
            // set the cows health to maximum



    }

}
