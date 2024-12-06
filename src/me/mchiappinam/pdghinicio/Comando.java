package me.mchiappinam.pdghinicio;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Comando implements CommandExecutor {

	private Main plugin;
	public Comando(Main main) {
		plugin=main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("textura")) {
			/*if(args.length<1) {
				sender.sendMessage("§cUse /textura <som>");
				return true;
			}*/
			Player p = (Player)sender;
			//p.playSound(p.getLocation(), args[0], 100, 1.0F);
			if(plugin.jogadores.contains(p.getName().toLowerCase())) {
				p.sendMessage("§aVocê está com nossa textura e ganhou a TAG §2✔ §acomo recompensa.");
				p.sendMessage("§aAGORA AS ARMAS TEM UM SOM DIFERENTE, QUE REPRODUZ APENAS NA TEXTURA!");
			}else {
				p.sendMessage("§cPoxa, que pena, você está sem a nossa textura!");
				p.sendMessage("§cAGORA AS ARMAS TEM UM SOM DIFERENTE, QUE REPRODUZ APENAS NA TEXTURA!");
				p.sendMessage("§cVocê pode baixá-la manualmente e colocar na pasta \"resourcepacks\" de seu Minecraft.");
				p.sendMessage("§cLink de download: http://pdgh.com.br/textura");
			}
				
			return true;
		}
		return false;
	}
}
