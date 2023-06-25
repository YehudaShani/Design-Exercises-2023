package WS1.Observers;

public class MsTempObserver implements Observer{

    MonitoringScreen monitoringScreen;

    public MsTempObserver(MonitoringScreen monitoringScreen) {
        this.monitoringScreen = monitoringScreen;
    }

    @Override
    public void update(Integer data) {
        monitoringScreen.disaplayTemperature(data);
    }
}
