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
public class libGame extends libMedia {
    
    private String mediaDeveloper, mediaPlatform, mediaVActors;
    private int mediaPlayerAmount;

    public libGame(String mediaName, String mediaGenre, String mediaDesc, String mediaPublisher, String mediaAudience, int mediaLength, int rentDuration, double rentCost, String mediaDeveloper, String mediaPlatform, String mediaVActors, int mediaPlayerAmount) {
        super(mediaName, mediaGenre, mediaDesc, mediaPublisher, mediaAudience, mediaLength, rentDuration, rentCost);
        this.mediaDeveloper = mediaDeveloper;
        this.mediaPlatform = mediaPlatform;
        this.mediaVActors = mediaVActors;
        this.mediaPlayerAmount = mediaPlayerAmount;
        this.mediaType = ("Game");
    }

    public libGame(String mediaName, String mediaGenre, String mediaDesc, String mediaPublisher, String mediaAudience, int mediaLength, int rentDuration, String mediaDeveloper, String mediaPlatform, String mediaVActors, int mediaPlayerAmount) {
        super(mediaName, mediaGenre, mediaDesc, mediaPublisher, mediaAudience, mediaLength, rentDuration);
        this.mediaDeveloper = mediaDeveloper;
        this.mediaPlatform = mediaPlatform;
        this.mediaVActors = mediaVActors;
        this.mediaPlayerAmount = mediaPlayerAmount;
        this.mediaType = ("Game");
    }

    public String getMediaDeveloper() {
        return mediaDeveloper;
    }

    public void setMediaDeveloper(String mediaDeveloper) {
        this.mediaDeveloper = mediaDeveloper;
    }

    public String getMediaPlatform() {
        return mediaPlatform;
    }

    public void setMediaPlatform(String mediaPlatform) {
        this.mediaPlatform = mediaPlatform;
    }

    public String getMediaVActors() {
        return mediaVActors;
    }

    public void setMediaVActors(String mediaVActors) {
        this.mediaVActors = mediaVActors;
    }

    public int getMediaPlayerAmount() {
        return mediaPlayerAmount;
    }

    public void setMediaPlayerAmount(int mediaPlayerAmount) {
        this.mediaPlayerAmount = mediaPlayerAmount;
    }
    
    @Override
    public void printInfo() {
        System.out.println("Details for " + this.getMediaName() + "(" + this.getMediaType() + "):");
        System.out.println("Platform: " + this.getMediaPlatform() + ".");
        System.out.println("Number of Players " + this.getMediaPlayerAmount() + ".");
        System.out.println("Genre: " + this.getMediaGenre() + ".");
        System.out.println("Description: " + this.getMediaDesc() + ".");
        System.out.println("Voice Actors: " + this.getMediaVActors() + ".");
        System.out.println("Publisher: " + this.getMediaPublisher() + ".");
        System.out.println("Developer: " + this.getMediaDeveloper() + ".");
        System.out.println("Intended Audience: " + this.getMediaAudience() + ".");
        this.printLength();
        System.out.println("---Rental Details---");
        System.out.println("Cost: " + dollarFormat.format(this.getRentCost())+ ".");
        System.out.println("Maximum Rental Duration: " + this.getRentDuration() + ".");
        System.out.println("Available For Rent: " + this.getMediaAvailable() + ".");
    }
    
    @Override
    public void printLength() {
        System.out.println("Length: " + this.getMediaLength() + " hours average to completion.");
    }
    
    
}
