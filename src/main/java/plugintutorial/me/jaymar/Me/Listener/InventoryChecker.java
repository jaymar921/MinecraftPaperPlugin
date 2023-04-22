package plugintutorial.me.jaymar.Me.Listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;
import plugintutorial.me.jaymar.Me.Data.DataRepository;

public class InventoryChecker implements Listener {

    // this only works on opening a chest, barrel, furnace, anvil, hopper, villages except player inventory
    @EventHandler
    private void OpenInventory(InventoryOpenEvent event){
        event.getPlayer().sendMessage("I opened my inventory");
    }

    @EventHandler
    private void CheckPlayerInventory(InventoryClickEvent event){
        //event.getWhoClicked().sendMessage("I clicked something in the inventory");
        //String typeofinventory = event.getInventory().getType().toString();

        //event.getWhoClicked().sendMessage("The type of inventory I clicked is: "+typeofinventory);

        if(event.getClickedInventory() == null)
            return;

        if(event.getClickedInventory().getType() == InventoryType.PLAYER){
            String playerName = event.getWhoClicked().getName();

            ItemStack[] contents = event.getClickedInventory().getContents();

            DataRepository.getPlayerItems().put(playerName, contents);

            System.out.println(playerName +" filled contents");
        }
    }
}
