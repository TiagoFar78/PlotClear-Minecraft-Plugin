package redehexen.plotClear.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import redehexen.plotClear.PlotClear;
import redehexen.plotClear.PlotClearItem;
import redehexen.plotClear.managers.ConfigManager;

public class GiveItemSubcommand implements PlotClearSubcommand {

	@Override
	public void execute(CommandSender sender, String cmdlabel, String[] args) {
		ConfigManager configManager = ConfigManager.getInstance();
		
		if (!sender.hasPermission(PlotClear.GIVE_PERMISSION)) {
			sender.sendMessage(configManager.getNotAllowedMessage());
			return;
		}
		
		if (args.length != 1) {
			sender.sendMessage(configManager.getGiveItemUsageMessage());
			return;
		}
		
		String playerName = args[0];
		Player player = Bukkit.getPlayer(playerName);
		
		if (!player.isOnline()) {
			sender.sendMessage(configManager.getPlayerOfflineMessage());
			return;
		}
		
		PlotClearItem.giveToPlayer(player);
		sender.sendMessage(configManager.getItemGivenMessage());
	}

}
