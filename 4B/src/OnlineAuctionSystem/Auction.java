package OnlineAuctionSystem;

import java.util.ArrayList;
import java.util.List;


class Auction implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private String item;

    public Auction(String item) {
        this.item = item;
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String event) {
        for (Observer observer : observers) {
            observer.update(event);
        }
    }

    public void startBidding() {
        notifyObservers("Bidding started for item: " + item);
    }

    public void endBidding() {
        notifyObservers("Bidding ended for item: " + item);
    }
}

