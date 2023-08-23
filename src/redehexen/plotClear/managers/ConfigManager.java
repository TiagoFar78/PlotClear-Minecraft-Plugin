package redehexen.plotClear.managers;

import org.bukkit.configuration.file.YamlConfiguration;

import redehexen.plotClear.PlotClear;

public class ConfigManager {
	
	private static ConfigManager instance = new ConfigManager();
	
	public static ConfigManager getInstance() {
		return instance;
	}
	
	public static void reload() {
		instance = new ConfigManager();
	}
	
	private int _lowerY;
	private int _higherY;
	private String _itemName;
	
	private String _itemGivenMessage;
	private String _reloadedMessage;
	
	private String _fullInventoryMessage;
	private String _notAllowedMessage;
	private String _wrongPlotMessage;
	private String _playerOfflineMessage;
	
	private String _giveItemUsageMessage;
	private String _reloadUsageMessage;
	
	private ConfigManager() {
		YamlConfiguration config = PlotClear.getYamlConfiguration();
		
		_lowerY = config.getInt("LowerY");
		_higherY = config.getInt("HigherY");
		_itemName = config.getString("Itens.ClearPlot.Name").replace("&", "§");
		
		_itemGivenMessage = config.getString("Messages.Warnings.ItemGiven").replace("&", "§");
		_reloadedMessage = config.getString("Messages.Warnings.Reloaded").replace("&", "§");
		
		_fullInventoryMessage = config.getString("Messages.Errors.FullInventory").replace("&", "§");
		_notAllowedMessage = config.getString("Messages.Errors.NotAllowed").replace("&", "§");
		_wrongPlotMessage = config.getString("Messages.Errors.WrongPlot").replace("&", "§");
		_playerOfflineMessage = config.getString("Messages.Errors.PlayerOffline").replace("&", "§");

		_giveItemUsageMessage = config.getString("Messages.Usages.GiveItem").replace("&", "§");
		_reloadUsageMessage = config.getString("Messages.Usages.Reload").replace("&", "§");
	}
	
	public int getLowerY() {
        return _lowerY;
    }

    public int getHigherY() {
        return _higherY;
    }

    public String getItemName() {
        return _itemName;
    }

    public String getItemGivenMessage() {
        return _itemGivenMessage;
    }

    public String getReloadedMessage() {
        return _reloadedMessage;
    }

    public String getFullInventoryMessage() {
        return _fullInventoryMessage;
    }

    public String getNotAllowedMessage() {
        return _notAllowedMessage;
    }

    public String getWrongPlotMessage() {
        return _wrongPlotMessage;
    }

    public String getPlayerOfflineMessage() {
        return _playerOfflineMessage;
    }

    public String getGiveItemUsageMessage() {
        return _giveItemUsageMessage;
    }

    public String getReloadUsageMessage() {
        return _reloadUsageMessage;
    }

}
