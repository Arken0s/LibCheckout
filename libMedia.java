/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment06;

import java.text.NumberFormat;
import java.util.Scanner;

/**
 *
 * @author Jacob O'Bryan
 */
public abstract class libMedia implements libObject {

    private String mediaName, mediaGenre, mediaDesc, mediaPublisher, mediaAudience;
    private int mediaLength, rentDuration, renterID;
    private double rentCost;
    private boolean mediaAvailable;
    
    //For the future, if time permits: Make an arraylist/hashmap that will keep track of how many of this object is in the library's inventory, which ones are checked out, and who they are checked out to.
    
    public String mediaType;

    NumberFormat dollarFormat = NumberFormat.getCurrencyInstance();
    Scanner s = new Scanner(System.in);

    public libMedia(String mediaName, String mediaGenre, String mediaDesc, String mediaPublisher, String mediaAudience, int mediaLength, int rentDuration, double rentCost) {
        this.mediaName = mediaName;
        this.mediaType = "Generic Media";
        this.mediaGenre = mediaGenre;
        this.mediaDesc = mediaDesc;
        this.mediaPublisher = mediaPublisher;
        this.mediaAudience = mediaAudience;
        this.mediaLength = mediaLength;
        this.rentDuration = rentDuration;
        this.rentCost = rentCost;
        this.mediaAvailable = true;
    }
    
    public libMedia(String mediaName, String mediaGenre, String mediaDesc, String mediaPublisher, String mediaAudience, int mediaLength, int rentDuration) {
        this.mediaName = mediaName;
        this.mediaType = "Generic Media";
        this.mediaGenre = mediaGenre;
        this.mediaDesc = mediaDesc;
        this.mediaPublisher = mediaPublisher;
        this.mediaAudience = mediaAudience;
        this.mediaLength = mediaLength;
        this.rentDuration = rentDuration;
        this.mediaAvailable = true;
    }
    
    @Override
    public void checkOut(int renterID) {
        if (this.mediaAvailable == false) {
            System.out.println("This item is not available for checkout.");
        } else {
            boolean costPaid = false;
            if (this.rentCost <= 0) {
                costPaid = true;
            } else {
                System.out.println("The " + this.getMediaType() + "titled " + this.getMediaName() + " comes with a rental cost of " + dollarFormat.format(this.getRentCost()) + ".");
            }
            while (costPaid == false) {
                System.out.println("Has the customer paid this charge?"); 
                System.out.println("Enter '1' if the customer has paid.");
                System.out.println("Enter '2' if the customer still needs to pay.");
                System.out.println("Enter '3' to cancel this operation.");
                switch (s.nextInt()) {
                    case 1: {
                        costPaid = true;
                        break;
                    }
                    case 2: {
                        System.out.println("Please take the payment for the rental at this time.");
                        break;
                    }
                    case 3: {
                        System.out.println("You have cancelled this operation and no items were checked out.");
                        return;
                    }
                    default:
                        System.out.println("Invalid entry. Please try again.");
                        break;
                }
            }
            if (costPaid == true) {
                this.mediaAvailable = false;
                this.renterID = renterID;
                System.out.println(this.getMediaName() + "(" + this.getMediaType() + ") has been rented out to user ID#" + this.getRenterID() + ".");
            }
        }
    }
    
    @Override
    public void checkIn() {
        this.mediaAvailable = true;
        this.renterID = 0;
        System.out.println(this.getMediaName() + "(" + this.getMediaType() + ") has been returned to stock.");
    }
    
    @Override
    public void printInfo() {
        System.out.println("Details for " + this.getMediaName() + "(" + this.getMediaType() + "):");
        System.out.println("Genre: " + this.getMediaGenre() + ".");
        System.out.println("Description: " + this.getMediaDesc() + ".");
        System.out.println("Publisher: " + this.getMediaPublisher() + ".");
        System.out.println("Intended Audience: " + this.getMediaAudience() + ".");
        this.printLength();
        System.out.println("---Rental Details---");
        System.out.println("Cost: " + dollarFormat.format(this.getRentCost())+ ".");
        System.out.println("Maximum Rental Duration: " + this.getRentDuration() + ".");
        System.out.println("Available For Rent: " + this.getMediaAvailable() + ".");
    }
    
    @Override
    public void printLength() {
        System.out.println("Length: " + this.getMediaLength() + ".");
    }

    @Override
    public int getRentDuration() {
        return rentDuration;
    }

    @Override
    public int getMediaLength() {
        return mediaLength;
    }

    @Override
    public int getRenterID() {
        return renterID;
    }

    @Override
    public double getRentCost() {
        return rentCost;
    }

    @Override
    public String getMediaName() {
        return mediaName;
    }

    @Override
    public String getMediaType() {
        return mediaType;
    }

    @Override
    public String getMediaGenre() {
        return mediaGenre;
    }

    @Override
    public String getMediaDesc() {
        return mediaDesc;
    }

    @Override
    public String getMediaAudience() {
        return mediaAudience;
    }

    @Override
    public String getMediaPublisher() {
        return mediaPublisher;
    }
    
    @Override
    public String getMediaAvailable () {
        if (this.mediaAvailable == true)
            return "yes";
        else
            return "no";
    }

    @Override
    public void setRentCost(int rentCost) {
        this.rentCost = rentCost;
    }

    @Override
    public void setRentDuration(int rentDuration) {
        this.rentDuration = rentDuration;
    }

    @Override
    public void setMediaLength(int mediaLength) {
        this.mediaLength = mediaLength;
    }

    @Override
    public void setRenterID(int renterID) {
        this.renterID = renterID;
    }

    @Override
    public void setMediaName(String mediaName) {
        this.mediaName = mediaName;
    }

    @Override
    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    @Override
    public void setMediaGenre(String mediaGenre) {
        this.mediaGenre = mediaGenre;
    }

    @Override
    public void setMediaDesc(String mediaDesc) {
        this.mediaDesc = mediaDesc;
    }

    @Override
    public void setMediaAudience(String mediaAudience) {
        this.mediaAudience = mediaAudience;
    }

    @Override
    public void setMediaPublisher(String mediaPublisher) {
        this.mediaPublisher = mediaPublisher;
    }

    @Override
    public void setMediaAvailable(boolean mediaAvailable) {
        this.mediaAvailable = mediaAvailable;
    }
}
