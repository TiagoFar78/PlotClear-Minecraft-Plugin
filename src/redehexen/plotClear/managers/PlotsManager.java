package redehexen.plotClear.managers;

import com.intellectualcrafters.plot.api.PlotAPI;

public class PlotsManager {
	
	private static PlotsManager _instance = new PlotsManager();
	
	public static PlotsManager getInstance() {
		return _instance;
	}
	
	public static void reload() {
		_instance = new PlotsManager();
	}
	
	private PlotAPI _plotAPI;
	
	private PlotsManager() {
		_plotAPI = new PlotAPI();
	}

	public PlotAPI getPlotsAPI() {
		return _plotAPI;
	}
}
