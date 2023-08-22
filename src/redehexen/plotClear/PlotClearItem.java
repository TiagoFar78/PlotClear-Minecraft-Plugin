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
	
	public static ItemStack getItem() {
		// TODO cria item
	}

}
