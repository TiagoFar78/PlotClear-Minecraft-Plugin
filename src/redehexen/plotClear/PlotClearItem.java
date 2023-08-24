package redehexen.plotClear;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.intellectualcrafters.plot.api.PlotAPI;
import com.intellectualcrafters.plot.object.Plot;

import redehexen.plotClear.managers.ConfigManager;
import redehexen.plotClear.managers.PlotsManager;

public class PlotClearItem implements Listener {
	
	public static void giveToPlayer(Player player) {
		ConfigManager configManager = ConfigManager.getInstance();
		
		HashMap<Integer, ItemStack> unplacedItens = player.getInventory().addItem(create());
		
		boolean wasPlaced = unplacedItens.size() == 0;
		if (!wasPlaced) {
			player.sendMessage(configManager.getFullInventoryMessage());
			return;
		}
	}
	
	private static ItemStack create() {
		ConfigManager configManager = ConfigManager.getInstance();
		String itemName = configManager.getItemName();
		
		ItemStack item = new ItemStack(Material.GOLD_SPADE);
		ItemMeta itemMeta = item.getItemMeta();
		itemMeta.setDisplayName(itemName);
		item.setItemMeta(itemMeta);
		
		return item;
	}
	
	private boolean isSameItem(ItemStack item2) {
		if (item2 == null) {
			return false;
		}
		
		ItemStack item1 = create();
		
		String item1Name = item1.getItemMeta().getDisplayName();
		String item2Name = item2.getItemMeta().getDisplayName();
		
		return item1.getType() == item2.getType() && item1Name != null && item2Name != null &&
				item1Name.equals(item2Name);
	}
	
	@EventHandler
	public void playerClick(PlayerInteractEvent e) {	
		ConfigManager configManager = ConfigManager.getInstance();
		
		Block block = e.getClickedBlock();
		if (block == null) {
			return;
		}
		
		ItemStack item = e.getPlayer().getItemInHand();
		if (!isSameItem(item)) {
			return;
		}
		
		Player player = e.getPlayer();
		if (!player.hasPermission(PlotClear.USE_PERMISSION)) {
			player.sendMessage(configManager.getNotAllowedMessage());
			return;
		}
		
		Location loc = e.getClickedBlock().getLocation();
		
		PlotAPI plotAPI = PlotsManager.getInstance().getPlotsAPI();
		Plot plot = plotAPI.getPlot(loc);
		
		if (plot == null || !plot.isOwner(player.getUniqueId())) {
			player.sendMessage(configManager.getWrongPlotMessage());
			return;
		}
		
		clearPlot(plot);
		removeItem(player);
	}
	
	@SuppressWarnings("deprecation")
	private void clearPlot(Plot plot) {
		ConfigManager configManager = ConfigManager.getInstance();		
		int lowerY = configManager.getLowerY();
		int higherY = configManager.getHigherY();

		World world = Bukkit.getWorld(plot.getBottom().getWorld());
		
		for (int x = plot.getBottom().getX(); x <= plot.getTop().getX(); x++) {
            for (int y = lowerY; y <= higherY; y++) {
                for (int z = plot.getBottom().getZ(); z <= plot.getTop().getZ(); z++) {
                    world.getBlockAt(x, y, z).setType(Material.AIR);
                }
            }
        }
	}
	
	private void removeItem(Player player) {
		Inventory inv = player.getInventory();
		
		for (ItemStack item : inv.getContents()) {
			if (isSameItem(item)) {
				inv.remove(item);
			}
		}
	}

}
