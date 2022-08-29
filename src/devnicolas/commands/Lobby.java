package devnicolas.commands;

import java.net.Socket;
import java.util.HashMap;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class Lobby extends Command {
	
	public static HashMap<String, Long> confirm;
	
	public Lobby() {
		super("hub", "", new String[] { "lobby" });
	}

	@SuppressWarnings("deprecation")
	public void execute(final CommandSender sender, final String[] args) {
		final ProxiedPlayer player = ProxyServer.getInstance().getPlayer(sender.getName());
		final ServerInfo server = ProxyServer.getInstance().getServerInfo("lobby-1");
		if(player.getServer().getInfo() == server) {
			sender.sendMessage("§6§lREDESTRIKER §7Você já está conectado ao §6lobby§7.");
			return;
		}
		
		try {
			final Socket s = new Socket(server.getAddress().getAddress().getHostAddress(), server.getAddress().getPort());
            s.close();
            player.connect(server);
            player.sendMessage("§6§lREDESTRIKER §7Conectando ao §6lobby§7..");
		} catch(Exception err) {
			sender.sendMessage("§6§lREDESTRIKER §7Ocorreu um erro ao tentar conectar ao §6lobby§7.");
		}
	}
}
