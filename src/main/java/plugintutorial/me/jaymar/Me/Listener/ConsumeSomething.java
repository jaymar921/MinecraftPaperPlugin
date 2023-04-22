package plugintutorial.me.jaymar.Me.Listener;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ConsumeSomething implements Listener {

    @EventHandler
    private void Consume(PlayerItemConsumeEvent event){
        ItemStack itemStack = event.getItem();
        ItemMeta meta = itemStack.getItemMeta();
        meta.setDisplayName("Half of the food");
        itemStack.setItemMeta(meta);
        event.setReplacement(itemStack);
    }
}
