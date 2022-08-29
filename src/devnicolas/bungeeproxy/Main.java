package devnicolas.bungeeproxy;

import devnicolas.commands.Lobby;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.api.plugin.Plugin;

public class Main extends Plugin {

	private static Main instance;
	final Main m = new Main();
	private Lobby lobby;
	public static Main getInstance() {
		return Main.instance;
	}
	
	public void onEnable() {
		System.out.println("Initialized");
		Main.getInstance().getProxy().getPluginManager().registerCommand((Plugin)m, (Command)this.lobby);
	}
}
