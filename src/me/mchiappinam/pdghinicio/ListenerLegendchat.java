/**
 * Copyright PDGH Minecraft Servers & HostLoad © 2013-XXXX
 * Todos os direitos reservados
 * Uso apenas para a PDGH.com.br e https://HostLoad.com.br
 * Caso você tenha acesso a esse sistema, você é privilegiado!
*/

package me.mchiappinam.pdghinicio;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

import br.com.devpaulo.legendchat.api.events.ChatMessageEvent;

public class ListenerLegendchat implements Listener {
	private Main plugin;
	public ListenerLegendchat(Main main) {
		plugin=main;
	}

	@EventHandler(priority=EventPriority.HIGHEST)
	private void onChat(ChatMessageEvent e) {
		if(plugin.jogadores.contains(e.getSender().getName().toLowerCase())) {
			e.setTagValue("textura", " §2✔");
		}
	}
}
