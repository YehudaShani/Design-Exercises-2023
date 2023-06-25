package WS1.Observers;

public class MSPressObserver implements Observer{
    MonitoringScreen monitoringScreen;

    public MSPressObserver(MonitoringScreen monitoringScreen) {
        this.monitoringScreen=monitoringScreen;
    }

    @Override
    public void update(Integer data) {
        monitoringScreen.disaplayPressure(data);

    }
}
