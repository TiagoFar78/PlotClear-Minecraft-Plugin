package redehexen.plotClear;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import redehexen.plotClear.commands.PlotClearCommand;

public class PlotClear extends JavaPlugin {
	
	public static final String USE_PERMISSION = "TF_PlotClear.Use";
	public static final String GIVE_PERMISSION = "TF_PlotClear.GiveItem";
	public static final String RELOAD_PERMISSION = "TF_PlotClear.Reload";
	
	@Override
	public void onEnable() {		
		if (!new File(getDataFolder(), "config.yml").exists()) {
			saveDefaultConfig();
		}
		
		getServer().getPluginManager().registerEvents(new PlotClearItem(), this);
		
		getCommand("PlotClear").setExecutor(new PlotClearCommand());
	}
	
	public static YamlConfiguration getYamlConfiguration() {
		return YamlConfiguration.loadConfiguration(configFile());
	}
	
	private static File configFile() {
		return new File(getPlotClear().getDataFolder(), "config.yml");
	}
	
	public static PlotClear getPlotClear() {
		return (PlotClear)Bukkit.getServer().getPluginManager().getPlugin("TF_PlotClear");
	}
	
	public static void saveConfiguration(YamlConfiguration config) {
		File configFile = configFile();
		
		try {
			config.save(configFile);
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}

}
