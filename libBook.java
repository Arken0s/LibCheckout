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
public class libBook extends libMedia {
    
    private String mediaAuthor, mediaBookFormat; //bookFormat will be either paper or digital

    public libBook(String mediaName, String mediaGenre, String mediaDesc, String mediaPublisher, String mediaAudience, int mediaLength, int rentDuration, double rentCost, String bookAuthor, String bookFormat) {
        super(mediaName, mediaGenre, mediaDesc, mediaPublisher, mediaAudience, mediaLength, rentDuration, rentCost);
        this.mediaAuthor = bookAuthor;
        this.mediaBookFormat = bookFormat;
        this.mediaType = (this.mediaBookFormat + " Book");
    }

    public libBook(String mediaName, String mediaGenre, String mediaDesc, String mediaPublisher, String mediaAudience, int mediaLength, int rentDuration, String bookAuthor, String bookFormat) {
        super(mediaName, mediaGenre, mediaDesc, mediaPublisher, mediaAudience, mediaLength, rentDuration);
        this.mediaAuthor = bookAuthor;
        this.mediaBookFormat = bookFormat;
        this.mediaType = (this.mediaBookFormat + " Book");
    }

    public String getBookAuthor() {
        return mediaAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.mediaAuthor = bookAuthor;
    }

    public String getBookFormat() {
        return mediaBookFormat;
    }

    public void setBookFormat(String bookFormat) {
        this.mediaBookFormat = bookFormat;
    }
    
    @Override
    public void printInfo() {
        System.out.println("Details for " + this.getMediaName() + "(" + this.getMediaType() + "):");
        System.out.println("Genre: " + this.getMediaGenre() + ".");
        System.out.println("Description: " + this.getMediaDesc() + ".");
        System.out.println("Author: " + this.getBookAuthor() + ".");
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
        System.out.println("Length: " + this.getMediaLength() + " pages.");
    }
    
}
