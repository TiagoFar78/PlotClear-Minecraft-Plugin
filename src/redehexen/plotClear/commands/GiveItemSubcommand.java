package redehexen.plotClear.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import redehexen.plotClear.PlotClear;
import redehexen.plotClear.PlotClearItem;

public class GiveItemSubcommand implements PlotClearSubcommand {

	@Override
	public void execute(CommandSender sender, String cmdlabel, String[] args) {
		if (!sender.hasPermission(PlotClear.GIVE_PERMISSION)) {
			// TODO send message
			return;
		}
		
		if (args.length != 1) {
			// TODO send message
			return;
		}
		
		String playerName = args[0];
		Player player = Bukkit.getPlayer(playerName);
		
		if (!player.isOnline()) {
			// TODO send message
			return;
		}
		
		PlotClearItem.giveToPlayer(player);
		// TODO send message
	}

}
