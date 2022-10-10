package fr.roguire.hasteyboys.listeners;

import java.util.LinkedList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import fr.roguire.hasteyboys.HasteyBoys;

public class HasteyBoysListeners implements Listener {
	
	private HasteyBoys plugin;
	private final List<ItemStack> items;
	
	public HasteyBoysListeners(HasteyBoys plugin) {

		this.plugin = plugin;
		items = fill();
		
	}
	
	private List<ItemStack> fill() {
		
		List<ItemStack> items = new LinkedList<>();
		
		items.add(new ItemStack(Material.WOOD_AXE));
		items.add(new ItemStack(Material.WOOD_PICKAXE));
		items.add(new ItemStack(Material.STONE_AXE));
		items.add(new ItemStack(Material.STONE_PICKAXE));
		items.add(new ItemStack(Material.IRON_AXE));
		items.add(new ItemStack(Material.IRON_PICKAXE));
		items.add(new ItemStack(Material.GOLD_AXE));
		items.add(new ItemStack(Material.GOLD_PICKAXE));
		items.add(new ItemStack(Material.DIAMOND_AXE));
		items.add(new ItemStack(Material.DIAMOND_PICKAXE));
		
		return items;
	}
	
	@EventHandler
	public void onPreCraft(PrepareItemCraftEvent e) {
		
		if(!plugin.getStatus()) return;
		
		if(!items.contains(e.getRecipe().getResult())) return;
		
		e.getInventory().setResult(addEnchant(e.getRecipe().getResult()));
		
	}

	@EventHandler
	public void onCraftEvent(CraftItemEvent e) {
		
		if(!plugin.getStatus()) return;
		
		if(!items.contains(e.getRecipe().getResult())) return;
		
		ItemStack is = addEnchant(e.getRecipe().getResult());
		
		e.getInventory().setResult(is);
		
	}
	
	private ItemStack addEnchant(ItemStack is) {
		
		ItemMeta im = is.getItemMeta();
		im.addEnchant(Enchantment.DIG_SPEED, 3, false);
		im.addEnchant(Enchantment.DURABILITY, 2, false);
		is.setItemMeta(im);
		
		return is;
		
	}

}
