package redehexen.plotClear.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class PlotClearCommand implements CommandExecutor {
	
	private static final String GIVE_COMMAND = "give";
	private static final String RELOAD_COMMAND = "reload";

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (args.length == 0) {
			sendGeneralUsageMessage(sender);
			return false;
		}
		
		String subCommand = args[0];
		
		String[] newArgs = new String[args.length - 1];
		for (int i = 1; i < args.length; i++) {
			newArgs[i - 1] = args[i];
		}
		
		switch (subCommand.toLowerCase()) {
		case GIVE_COMMAND:
			new GiveItemSubcommand().execute(sender, subCommand, newArgs);
			return false;
		case RELOAD_COMMAND:
			new ReloadSubcommand().execute(sender, subCommand, newArgs);
			return false;
		default:
			sendGeneralUsageMessage(sender);
			return false;
		}
	}
	
	private void sendGeneralUsageMessage(CommandSender sender) {
		ConfigManager configManager = ConfigManager.getInstance();
		
		sender.sendMessage(configManager.getSetPositionUsageMessage());
		sender.sendMessage(configManager.getReloadUsageMessage());
	}

}
