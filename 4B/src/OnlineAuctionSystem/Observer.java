package OnlineAuctionSystem;

interface Observer {
    void update(String event);
}

interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(String event);
}
