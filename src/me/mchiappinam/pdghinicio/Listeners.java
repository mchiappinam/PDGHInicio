package me.mchiappinam.pdghinicio;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerResourcePackStatusEvent;

public class Listeners implements Listener {

	private Main plugin;
	public Listeners(Main main) {
		plugin=main;
	}
	
	@EventHandler//(priority=EventPriority.MONITOR)
	public void onJoin(PlayerJoinEvent e) {
		plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
			public void run() {
				if(e.getPlayer()==null)
					return;
				e.getPlayer().playSound(e.getPlayer().getLocation(), "pdgh.bemvindo", 20.0F, 1.0F);
			}
		}, 20L);
		plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
			public void run() {
				if(e.getPlayer()==null)
					return;
				e.getPlayer().setResourcePack("http://pdgh.net/textura/downloads/[PDGH.com.br]%20-%20DayZ%202.0.zip");
			}
		}, 100L);
	}
	
	@EventHandler
	public void onResourcepackStatusEvent(PlayerResourcePackStatusEvent e) {
		if(e.getStatus() == PlayerResourcePackStatusEvent.Status.DECLINED) {
			if(!plugin.jogadores.contains(e.getPlayer().getName().toLowerCase()))
				plugin.jogadores.remove(e.getPlayer().getName().toLowerCase());
			e.getPlayer().sendMessage(" ");
			e.getPlayer().sendMessage("§cPoxa, que pena, você negou nossa textura!");
			e.getPlayer().sendMessage("§cAGORA AS ARMAS TEM UM SOM DIFERENTE, QUE REPRODUZ APENAS NA TEXTURA!");
			e.getPlayer().sendMessage("§cVocê pode baixá-la manualmente e colocar na pasta \"resourcepacks\" de seu Minecraft.");
			e.getPlayer().sendMessage("§cLink de download: http://pdgh.net/textura");
			e.getPlayer().sendMessage(" ");
			e.getPlayer().sendMessage(">> §aDica: Caso tenha negado sozinho, desconecte-se do servidor, vá na lista dos servidores (Multiplayer), clique no botão editar em nosso servidor e habilite o pacote de recursos.");
			  //e.getPlayer().kickPlayer("§cVocê só pode jogar se aceitar nossa textura!");
		}
		if(e.getStatus() == PlayerResourcePackStatusEvent.Status.FAILED_DOWNLOAD) {
			if(!plugin.jogadores.contains(e.getPlayer().getName().toLowerCase()))
				plugin.jogadores.add(e.getPlayer().getName().toLowerCase());
			  e.getPlayer().sendMessage(" ");
			  e.getPlayer().sendMessage(" ");
			  e.getPlayer().sendMessage("§c§lAVISO:");
			  e.getPlayer().sendMessage("§cA textura falhou! Você deve baixá-la manualmente e colocar na pasta \"resourcepacks\" de seu Minecraft.");
			  e.getPlayer().sendMessage("§cLink de download: http://pdgh.net/textura");
			  e.getPlayer().sendMessage(" ");
			  e.getPlayer().sendMessage(" ");
		}
		if(e.getStatus() == PlayerResourcePackStatusEvent.Status.SUCCESSFULLY_LOADED) {
			if(!plugin.jogadores.contains(e.getPlayer().getName().toLowerCase()))
				plugin.jogadores.add(e.getPlayer().getName().toLowerCase());
			plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
				public void run() {
					if(e.getPlayer()==null)
						return;
					e.getPlayer().playSound(e.getPlayer().getLocation(), "pdgh.obgacctxt", 20.0F, 1.0F);
					e.getPlayer().sendMessage(" ");
					e.getPlayer().sendMessage("§aObrigada por aceitar nossa textura!");
					e.getPlayer().sendMessage("§aVocê ganhou a TAG §2✔ §acomo recompensa e ouvirá os novos sons das armas.");
					e.getPlayer().sendMessage(" ");
				}
			}, 40L);
		}
	}
}
