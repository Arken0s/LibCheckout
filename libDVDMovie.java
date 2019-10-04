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
public class libDVDMovie extends libMedia{
    
    private String mediaActors;

    public libDVDMovie(String mediaName, String mediaGenre, String mediaDesc, String mediaPublisher, String mediaAudience, int mediaLength, int rentDuration, double rentCost, String mediaActors) {
        super(mediaName, mediaGenre, mediaDesc, mediaPublisher, mediaAudience, mediaLength, rentDuration, rentCost);
        this.mediaActors = mediaActors;
        this.mediaType = ("DVD Movie");
    }

    public libDVDMovie(String mediaName, String mediaGenre, String mediaDesc, String mediaPublisher, String mediaAudience, int mediaLength, int rentDuration, String mediaActors) {
        super(mediaName, mediaGenre, mediaDesc, mediaPublisher, mediaAudience, mediaLength, rentDuration);
        this.mediaActors = mediaActors;
        this.mediaType = ("DVD Movie");
    }

    public String getMediaActors() {
        return mediaActors;
    }

    public void setMediaActors(String mediaActors) {
        this.mediaActors = mediaActors;
    }
    
    @Override
    public void printInfo() {
        System.out.println("Details for " + this.getMediaName() + "(" + this.getMediaType() + "):");
        System.out.println("Genre: " + this.getMediaGenre() + ".");
        System.out.println("Description: " + this.getMediaDesc() + ".");
        System.out.println("Actors: " + this.getMediaActors() + ".");
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
        System.out.println("Length: " + this.getMediaLength() + " minutes.");
    }
    
}
