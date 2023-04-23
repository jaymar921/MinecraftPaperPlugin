package plugintutorial.me.jaymar.Me.Listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import plugintutorial.me.jaymar.Me.CustomData.CustomItem;
import plugintutorial.me.jaymar.Me.Data.DataRepository;

import java.util.Random;

public class BlockBreak implements Listener {

    @EventHandler
    private void onBlockBreak(BlockBreakEvent event){

        CustomItem item = new CustomItem();
        item.ITEM_ID = new Random().nextInt(100000,999999);
        item.ITEM_NAME = event.getBlock().getType().name();

        DataRepository.getCustomItems().add(item);
    }
}
