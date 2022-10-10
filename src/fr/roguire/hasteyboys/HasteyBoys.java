package fr.roguire.hasteyboys;

import org.bukkit.plugin.java.JavaPlugin;

import fr.roguire.hasteyboys.commands.HasteyBoysCommand;
import fr.roguire.hasteyboys.listeners.HasteyBoysListeners;

public class HasteyBoys extends JavaPlugin {
	
	private boolean status;
	
	public HasteyBoys() {
		
		setStatus(false);
		
	}
	
	@Override
	public void onEnable() {
		
		getConfig().options().copyDefaults();
		saveDefaultConfig();
		
		getCommand("hasteyboys").setExecutor(new HasteyBoysCommand(this));
		
		getServer().getPluginManager().registerEvents(new HasteyBoysListeners(this),this);
		
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public String getStringFromConfig(String arg) {
		
		return getConfig().getString(arg).replace('&', '§');
		
	}

}
