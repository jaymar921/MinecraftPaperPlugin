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

        boolean exist = false;
        for(CustomItem c_item : DataRepository.getCustomItems()){
            if(c_item == null)
                continue;
            if(c_item.ITEM_NAME.equalsIgnoreCase(item.ITEM_NAME)){
                exist = true;
            }
        }
        if(!exist){
            DataRepository.getCustomItems().add(item);
            event.getPlayer().sendMessage("The block was added in the list");
        }else{
            event.getPlayer().sendMessage("The block already exist");
        }
    }
}
