/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment06;

/**
 *
 * @author Jacob O'Bryan
 */
public interface libObject {
    
    public void checkOut(int renterID);
    public void checkIn();
    public void printInfo ();
    public void printLength();
    public int getRentDuration();
    public int getMediaLength();
    public int getRenterID();
    public double getRentCost();
    public String getMediaName();
    public String getMediaType();
    public String getMediaGenre();
    public String getMediaDesc();
    public String getMediaAudience();
    public String getMediaPublisher();
    public String getMediaAvailable();
    public void setRentCost(int rentCost);
    public void setRentDuration(int rentDuration);
    public void setMediaLength(int mediaLength);
    public void setRenterID(int renterID);
    public void setMediaName(String mediaName);
    public void setMediaType(String mediaType);
    public void setMediaGenre(String mediaGenre);
    public void setMediaDesc(String mediaDesc);
    public void setMediaAudience(String mediaAudience);
    public void setMediaPublisher(String mediaPublisher);
    public void setMediaAvailable(boolean mediaAvailable);
}
