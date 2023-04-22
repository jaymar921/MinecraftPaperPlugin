package plugintutorial.me.jaymar.Me.Listener;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import plugintutorial.me.jaymar.Me.Data.DataRepository;
import plugintutorial.me.jaymar.Me.jaymar;

public class JoinLeaveEvent implements Listener {

    @EventHandler
    private void onLeaveEvent(PlayerQuitEvent event){
        // get the player name who left
        String playerName = event.getPlayer().getName();
        // get the contents of the player inventory
        ItemStack[] contents = event.getPlayer().getInventory().getContents();
        // save the player items in the data repository, with the PlayerName as key, ItemStack contents as value
        DataRepository.getPlayerItems().put(playerName, contents);

        // remove all the items from the player
        event.getPlayer().getInventory().clear();
    }

    @EventHandler
    private void onJoinEvent(PlayerJoinEvent event){
        // get the player name
        String playerName = event.getPlayer().getName();
        // check if the data repository holds the player items
        boolean hasPlayerItems = DataRepository.getPlayerItems().containsKey(playerName);
        // if the data repository has the player items then do the ff.
        if(hasPlayerItems){
            // get the contents from the data repository
            ItemStack[] contents = DataRepository.getPlayerItems().get(playerName);

            // load the items back to the player, only after 5s delay using BukkitRunnable

            BukkitRunnable runLater = new BukkitRunnable() {
                @Override
                public void run() {
                    // load the player items
                    event.getPlayer().getInventory().setContents(contents);
                }
            };

            // load the runLater runnable after 5s
            runLater.runTaskLater(jaymar.getPlugin(jaymar.class), 20*5);
        }
    }
}
