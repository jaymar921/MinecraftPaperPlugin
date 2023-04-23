package plugintutorial.me.jaymar.Me.CustomData;

import org.bukkit.Location;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class CustomItem implements ConfigurationSerializable {

    public int ITEM_ID;
    public String ITEM_NAME;

    // required for saving the data
    @Override
    public @NotNull Map<String, Object> serialize() {
        Map<String, Object> data_toSave = new HashMap<>();
        data_toSave.put("ITEM_ID", ITEM_ID);
        data_toSave.put("ITEM_NAME", ITEM_NAME);
        return data_toSave;
    }
    // required for loading the data
    public static CustomItem deserialize(Map<String, Object> arg){
        CustomItem newItem = new CustomItem();
        newItem.ITEM_ID = (int) arg.get("ITEM_ID");
        newItem.ITEM_NAME = (String) arg.get("ITEM_NAME");
        return newItem;
    }
}
