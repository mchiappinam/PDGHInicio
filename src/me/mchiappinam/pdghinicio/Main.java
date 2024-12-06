package me.mchiappinam.pdghinicio;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	protected List<String> jogadores = new ArrayList<String>();
	public void onEnable() {
		getServer().getConsoleSender().sendMessage("§3[PDGHInicio] §2iniciando...");
		getServer().getConsoleSender().sendMessage("§3[PDGHInicio] §2registrando eventos...");
		getServer().getPluginManager().registerEvents(new Listeners(this), this);
		getServer().getConsoleSender().sendMessage("§3[PDGHInicio] §2eventos registrados");
		getServer().getConsoleSender().sendMessage("§3[PDGHInicio] §2definindo comandos...");
	    getServer().getPluginCommand("textura").setExecutor(new Comando(this));
		getServer().getConsoleSender().sendMessage("§3[PDGHInicio] §2comandos definidos");

		
		if (getServer().getPluginManager().getPlugin("Legendchat") == null) {
			getLogger().warning("Legendchat API nao encontrada!");
		}else{
			getServer().getConsoleSender().sendMessage("§3[PDGHInicio] §2Sucesso: Legendchat encontrado.");
			getServer().getPluginManager().registerEvents(new ListenerLegendchat(this), this);
		}
		getServer().getConsoleSender().sendMessage("§3[PDGHInicio] §2ativado - Developed by mchiappinam");
		getServer().getConsoleSender().sendMessage("§3[PDGHInicio] §2Acesse: http://pdgh.com.br/");
		getServer().getConsoleSender().sendMessage("§3[PDGHInicio] §2Acesse: https://hostload.com.br/");
	}
	    
	public void onDisable() {
		getServer().getConsoleSender().sendMessage("§3[PDGHInicio] §2desativado - Developed by mchiappinam");
		getServer().getConsoleSender().sendMessage("§3[PDGHInicio] §2Acesse: http://pdgh.com.br/");
		getServer().getConsoleSender().sendMessage("§3[PDGHInicio] §2Acesse: https://hostload.com.br/");
	}
}
