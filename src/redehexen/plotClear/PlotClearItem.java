package redehexen.plotClear;

import java.util.HashMap;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class PlotClearItem {
	
	public static void giveToPlayer(Player player) {
		HashMap<Integer, ItemStack> unplacedItens = player.getInventory().addItem(getItem());
		
		boolean wasPlaced = unplacedItens.size() == 0;
		if (!wasPlaced) {
			// TODO send message
		}
	}
	
	private static ItemStack getItem() {
		// TODO cria item
	}
	
	public static boolean isSameItem(ItemStack item2) {
		ItemStack item1 = getItem();
		
		String item1Name = item1.getItemMeta().getDisplayName();
		String item2Name = item2.getItemMeta().getDisplayName();
		
		return item1.getType() == item2.getType() && item1Name != null && item2Name != null &&
				item1Name.equals(item2Name);				
	}

}
