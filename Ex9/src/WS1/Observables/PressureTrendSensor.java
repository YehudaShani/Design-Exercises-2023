package WS1.Observables;

import WS1.Observers.Observer;

public class PressureTrendSensor extends Observable implements Observer {

    Integer lastRecorde;

    int clacTrend(Integer data){
        return 0;
    }

    public void check(Integer data){
        int trend =clacTrend(data);
        if(trend!=lastRecorde)
            notifyObserver(trend);
        lastRecorde=trend;
    }

    @Override
    public void update(Integer data) {
        check(data);
    }
}
