package WS1.Observables;

import WS1.Observers.Observer;

import java.util.LinkedList;
import java.util.List;

public class Observable {

    List<Observer> itsObservers=new LinkedList<>();

    public void addObserver(Observer observer){
        itsObservers.add(observer);
    }

    public void notifyObserver(Integer data){
        for(Observer observer:itsObservers){
            observer.update(data);
        }
    }
}
