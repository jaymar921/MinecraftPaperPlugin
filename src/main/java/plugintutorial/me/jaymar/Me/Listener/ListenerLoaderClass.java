package plugintutorial.me.jaymar.Me.Listener;

import plugintutorial.me.jaymar.Me.jaymar;

public class ListenerLoaderClass {

    public static void LoadEverything(jaymar mainPlugin){
        mainPlugin.getServer().getPluginManager().registerEvents(new InventoryChecker(), mainPlugin);
        mainPlugin.getServer().getPluginManager().registerEvents(new JoinLeaveEvent(), mainPlugin);
        mainPlugin.getServer().getPluginManager().registerEvents(new AttackSomethingEvent(), mainPlugin);
        mainPlugin.getServer().getPluginManager().registerEvents(new ConsumeSomething(), mainPlugin);
    }
}
