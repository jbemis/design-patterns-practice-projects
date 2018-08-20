package model;

import java.util.Observable;
import java.util.Observer;
import java.util.Random;

public class Bidder implements Observer {
    private String name;
    private double personalBid;
    private double currentBid;
    private double maxBid;

    public Bidder(String name, double maxBid) {
        this.name = name;
        personalBid = 0.0;
        currentBid = 0.0;
        this.maxBid = maxBid;
    }

    // getters
    public String getName() { return name; }
    public double getPersonalBid() { return personalBid; }
    public double getCurrentBid() { return currentBid; }
    public double getMaxBid() { return maxBid; }

    public void makeBid(double currentBid) {
        Random random = new Random();
        this.personalBid = (double) random.nextInt(10) + currentBid + 1;
        System.out.println(name + "'s bid is: $" + personalBid);
    }

    @Override
    public void update(Observable auctioneer, Object arg) {
        this.currentBid = (double) arg;
        System.out.println("Update for " + name + ". The current bid is $" + arg + ".");
        if (currentBid < maxBid){
            makeBid(currentBid);
        } else {
            System.out.println(name + " can't bid any higher");
        }
    }
}
