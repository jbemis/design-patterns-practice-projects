package model;

import java.util.LinkedList;
import java.util.Observable;
import java.util.Observer;

public class Subject extends Observable {
    protected LinkedList<Observer> observers = new LinkedList<Observer>();

    public void addObserver(Observer b){
        if(!observers.contains(b)) {
            observers.add(b);
        }
    }

    public void removeObserver(Observer b){
        if(observers.contains(b)) {
            observers.remove(b);
        }
    }

    public void notifyObservers(Subject observable, double bid) {
        for (Observer bidder : observers) {
            bidder.update(observable, bid);
        }
    };
}
