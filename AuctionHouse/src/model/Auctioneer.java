package model;

import java.util.Observer;

public class Auctioneer extends Subject {

    private String name;
    private double currentBid;

    public Auctioneer(String name) {
        this.name = name;
        currentBid = 0.0;
    }

    public String getName(){ return name; }
    public double getCurrentBid() { return currentBid; }

    public void acceptBid(double bid) {
        if (bid > currentBid){
            currentBid = bid;
            System.out.println("The highest bid is currently: $" + bid);
            notifyObservers(currentBid);
        } else {
            System.out.println("That bid isn't larger than the current bid!");
        }
    }

    public void notifyObservers(double newBidAmt) {
        for (Observer bidder : observers) {
            bidder.update(this, newBidAmt);
        }
    }
}
