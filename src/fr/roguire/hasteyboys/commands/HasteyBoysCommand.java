package fr.roguire.hasteyboys.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import fr.roguire.hasteyboys.HasteyBoys;

public class HasteyBoysCommand implements CommandExecutor {
	
	private HasteyBoys plugin;
	
	public HasteyBoysCommand(HasteyBoys plugin) {
		
		this.plugin = plugin;
		
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		boolean success = false;
		
		if(!sender.hasPermission("hb.change")) {
			
			sender.sendMessage(plugin.getStringFromConfig("no-permission"));
			return true;
			
		}
		
		if(plugin.getStatus()) {
			
			plugin.setStatus(false);
			Bukkit.broadcastMessage(plugin.getStringFromConfig("desactivation"));
			success = true;
			
		}else {
			
			plugin.setStatus(true);
			Bukkit.broadcastMessage(plugin.getStringFromConfig("activation"));
			success = true;
			
		}
		
		return success;
		
	}

}
