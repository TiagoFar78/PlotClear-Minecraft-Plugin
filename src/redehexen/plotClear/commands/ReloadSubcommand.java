package redehexen.plotClear.commands;

import org.bukkit.command.CommandSender;

import redehexen.plotClear.PlotClear;
import redehexen.plotClear.managers.ConfigManager;
import redehexen.plotClear.managers.PlotsManager;

public class ReloadSubcommand implements PlotClearSubcommand {

	@Override
	public void execute(CommandSender sender, String cmdlabel, String[] args) {
		ConfigManager configManager = ConfigManager.getInstance();
		
		if (!sender.hasPermission(PlotClear.RELOAD_PERMISSION)) {
			sender.sendMessage(configManager.getNotAllowedMessage());
			return;
		}
		
		ConfigManager.reload();
		PlotsManager.reload();
		
		sender.sendMessage(configManager.getReloadedMessage());
	}

}
