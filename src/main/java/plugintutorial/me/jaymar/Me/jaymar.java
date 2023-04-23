package plugintutorial.me.jaymar.Me;

import org.bukkit.plugin.java.JavaPlugin;
import plugintutorial.me.jaymar.Me.Data.DataRepository;
import plugintutorial.me.jaymar.Me.Loaders.ListenerLoaderClass;
import plugintutorial.me.jaymar.Me.Loaders.SerializableLoader;

public final class jaymar extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

        // load all the custom classes first before everything
        SerializableLoader.LoadAllClasses();

        // load the data first
        DataRepository.LoadRepository(this);

        // load all events
        ListenerLoaderClass.LoadEverything(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        DataRepository.UnloadRepository(this);
    }
}
