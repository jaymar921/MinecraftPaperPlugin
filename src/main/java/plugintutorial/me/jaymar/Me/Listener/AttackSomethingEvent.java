package plugintutorial.me.jaymar.Me.Listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import plugintutorial.me.jaymar.Me.Data.DataRepository;

public class AttackSomethingEvent implements Listener {

    @EventHandler
    private void AttackThings(EntityDamageEvent event){
        // set the damage amount to the default dmg
        int damage = DataRepository.getPlayerDefaultDamage();

        event.setDamage(damage);
        System.out.println(event.getCause() +"   damage -> "+damage);
    }
}
