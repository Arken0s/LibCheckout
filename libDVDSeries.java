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
public class libDVDSeries extends libDVDMovie {
    
    private int mediaSeason, mediaEpisodes;

    public libDVDSeries(String mediaName, String mediaGenre, String mediaDesc, String mediaPublisher, String mediaAudience, int mediaLength, int rentDuration, double rentCost, String dvdActors, int mediaSeason, int mediaEpisodes) {
        super(mediaName, mediaGenre, mediaDesc, mediaPublisher, mediaAudience, mediaLength, rentDuration, rentCost, dvdActors);
        this.mediaSeason = mediaSeason;
        this.mediaEpisodes = mediaEpisodes;
        this.mediaType = ("DVD Series");
    }

    public libDVDSeries(String mediaName, String mediaGenre, String mediaDesc, String mediaPublisher, String mediaAudience, int mediaLength, int rentDuration, String dvdActors, int mediaSeason, int mediaEpisodes) {
        super(mediaName, mediaGenre, mediaDesc, mediaPublisher, mediaAudience, mediaLength, rentDuration, dvdActors);
        this.mediaSeason = mediaSeason;
        this.mediaEpisodes = mediaEpisodes;
        this.mediaType = ("DVD Series");
    }

    public int getMediaSeason() {
        return mediaSeason;
    }

    public void setMediaSeason(int mediaSeason) {
        this.mediaSeason = mediaSeason;
    }

    public int getMediaEpisodes() {
        return mediaEpisodes;
    }

    public void setMediaEpisodes(int mediaEpisodes) {
        this.mediaEpisodes = mediaEpisodes;
    }
    
    @Override
    public void printInfo() {
        System.out.println("Details for " + this.getMediaName() + "(" + this.getMediaType() + "):");
        System.out.println("Season: " + this.getMediaSeason() + ".");
        System.out.println("Number of Episodes: " + this.getMediaEpisodes() + ".");
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
        System.out.println("Length: " + this.getMediaLength() + " minutes average per episode.");
    }

    
    
    
    
}
