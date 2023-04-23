package plugintutorial.me.jaymar.Me.Data;

import org.bukkit.inventory.ItemStack;
import plugintutorial.me.jaymar.Me.CustomData.CustomItem;
import plugintutorial.me.jaymar.Me.jaymar;

import java.util.*;

public class DataRepository {

    // configs
    // load data [inventory]
    private static Map<String,ItemStack[]> playerItems;
    private static List<CustomItem> customItems;
    private static int PLAYER_DEFAULT_DAMAGE = 20;

    public static void LoadRepository(jaymar mainPlugin){
        // when load the playerItems, we need to reload the config
        mainPlugin.reloadConfig();

        // we must check first if the key 'PLAYER_DATA' exists in the config
        boolean hasPlayerData = mainPlugin.getConfig().contains("PLAYER_DATA");
        // if it has playerData then do the ff.
        if(hasPlayerData){
            // retrieve the unknown map list from the config using the key 'PLAYER_DATA'
            List<Map<?,?>> unknownMapList = mainPlugin.getConfig().getMapList("PLAYER_DATA");
            // we know that in index 0, our Player Data is there
            Map<?,?> unknownDataFromMapList = unknownMapList.get(0);
            // cast the data to our playerItems
            playerItems = (Map<String, ItemStack[]>) unknownDataFromMapList;
            // we still have to check, if the player items is null, then just create a new instance of the Hashmap
            if(playerItems == null){
                playerItems = new HashMap<>();
            }
        }
        // short way
        //playerItems = (Map<String, ItemStack[]>) mainPlugin.getConfig().getMapList("PLAYER_DATA").get(0);

        // load the custom items directly
        customItems = (List<CustomItem>) mainPlugin.getConfig().getList("MY_CUSTOM_ITEM");
        customItems.removeAll(Collections.singleton(null)); // remove all nulls if there is any

        PLAYER_DEFAULT_DAMAGE = mainPlugin.getConfig().getInt("PLAYER_DEFAULT_DAMAGE");
    }

    public static void UnloadRepository(jaymar mainPlugin){
        // when saving a map, you must put inside a list
        // create the list
        List<Map<String, ItemStack[]>> playerDataMapList = new LinkedList<>();
        // we save our playerItems inside the mapList
        playerDataMapList.add(playerItems);
        // set the mapList in the config, with 'PLAYER_DATA' as the key of our config
        mainPlugin.getConfig().set("PLAYER_DATA", playerDataMapList);
        mainPlugin.getConfig().set("MY_CUSTOM_ITEM",customItems);
        // save the config
        mainPlugin.saveConfig();
    }

    public static Map<String, ItemStack[]> getPlayerItems(){
        return playerItems;
    }

    public static int getPlayerDefaultDamage(){
        return PLAYER_DEFAULT_DAMAGE;
    }

    public static List<CustomItem> getCustomItems(){
        return customItems;
    }
}
