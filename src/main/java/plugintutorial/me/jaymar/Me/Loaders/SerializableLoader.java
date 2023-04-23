package plugintutorial.me.jaymar.Me.Loaders;

import org.bukkit.configuration.serialization.ConfigurationSerialization;
import plugintutorial.me.jaymar.Me.CustomData.CustomItem;

public class SerializableLoader {

    public static void LoadAllClasses(){
        ConfigurationSerialization.registerClass(CustomItem.class);
    }
}
