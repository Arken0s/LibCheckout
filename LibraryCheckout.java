/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment06;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Jacob O'Bryan
 */
public class LibraryCheckout {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        HashMap<String, HashMap<String, libMedia>> libraryHashMaps = new HashMap<>();
        HashMap<String, libMedia> libraryBooks = new HashMap<>();
        HashMap<String, libMedia> libraryDigitalBooks = new HashMap<>();
        HashMap<String, libMedia> libraryDVDMovies = new HashMap<>();
        HashMap<String, libMedia> libraryDVDSeries = new HashMap<>();
        HashMap<String, libMedia> libraryGames = new HashMap<>();

        libraryHashMaps.put("Books", libraryBooks);
        libraryHashMaps.put("Digital Books", libraryDigitalBooks);
        libraryHashMaps.put("DVD Movies", libraryDVDMovies);
        libraryHashMaps.put("DVD Series", libraryDVDSeries);
        libraryHashMaps.put("Games", libraryGames);

        Scanner inputScanner = new Scanner(System.in);
        int userIntInput;
        int userMenuSelect;
        String userStringInput;
        Boolean runAgain = true;

        System.out.println("Hello, and welcome to the Library Management System!");

        //------SAMPLE MEDIA ITEMS FOR DEMONSTRATION, TESTING------
        libBook sampleBook = new libBook("Sample Book", "Fiction", "A book that acts as a sample", "Publishing Inc", "Everyone", 300, 30, 0, "JK Sampling", "Paper");
        libBook sampleDigitalBook = new libBook("Sample eBook", "NonFiction", "A digital sample book", "Publishing Inc", "Adults", 250, 30, 0, "John Doe", "Digital");
        libDVDMovie sampleDVDMovie = new libDVDMovie("Sample Movie", "Family", "A sample movie", "Disnoy", "Everyone", 120, 7, 5.00, "Good Actor");
        libDVDSeries sampleDVDSeries = new libDVDSeries("Sample Series", "Drama", "A sample series", "SBO", "Adults", 30, 14, 0, "Bad Actor", 3, 20);
        libGame sampleGame = new libGame("Sample Game", "Strategy", "A sample video game", "Nontendo", "Everyone", 30, 30, 7.50, "Nontendo", "Nintendo Switch", "Jane Smith", 4);
        libraryBooks.put("Sample Book", sampleBook);
        libraryDigitalBooks.put("Sample eBook", sampleDigitalBook);
        libraryDVDMovies.put("Sample Movie", sampleDVDMovie);
        libraryDVDSeries.put("Sample Series", sampleDVDSeries);
        libraryGames.put("Sample Game", sampleGame);

        //--LIBRARY SYSTEM MAIN MENU--
        while (runAgain) {
            System.out.println("------------------------");
            System.out.println("Please type the number corresponding to your desired option below and then press enter: ");
            System.out.println("1 - Check item out.");
            System.out.println("2 - Check item back in.");
            System.out.println("3 - Add new item to inventory.");
            System.out.println("4 - Remove item from inventory");
            System.out.println("5 - View the details of an item.");
            System.out.println("6 - List all items in the library.");
            System.out.println("7 - Exit the Library Management System.");
            userMenuSelect = askUserInt("", inputScanner);
            switch (userMenuSelect) {

                case 1: //Checkout
                    int inputRenterID = askUserInt("Enter the renter's ID number: ", inputScanner);
                    System.out.println("What type of item would you like to check out? Please type the corresponding number, then press enter: ");
                    System.out.println("1 - Book");
                    System.out.println("2 - eBook");
                    System.out.println("3 - DVD Movie");
                    System.out.println("4 - DVD TV Series");
                    System.out.println("5 - Video Game");
                    System.out.println("6 - CANCEL");
                    userIntInput = askUserInt("", inputScanner);
                    System.out.print("Enter the name of the item you'd like to check out: ");
                    String checkoutMediaName = inputScanner.nextLine();
                    libMedia checkoutMedia;
                    switch (userIntInput) {
                        case 1: //Book
                            checkoutMedia = libraryBooks.get(checkoutMediaName);
                            checkoutMedia.checkOut(inputRenterID);
                            break;

                        case 2: //Digital Book
                            checkoutMedia = libraryDigitalBooks.get(checkoutMediaName);
                            checkoutMedia.checkOut(inputRenterID);
                            break;

                        case 3: //DVD Movie
                            checkoutMedia = libraryDVDMovies.get(checkoutMediaName);
                            checkoutMedia.checkOut(inputRenterID);
                            break;

                        case 4: //DVD TV Series
                            checkoutMedia = libraryDVDSeries.get(checkoutMediaName);
                            checkoutMedia.checkOut(inputRenterID);
                            break;

                        case 5: //Video Game
                            checkoutMedia = libraryGames.get(checkoutMediaName);
                            checkoutMedia.checkOut(inputRenterID);
                            break;

                        case 6:
                            break;
                    }
                    break;

                case 2: //Checkin
                    System.out.println("What type of item would you like to check in? Please type the corresponding number, then press enter: ");
                    System.out.println("1 - Book");
                    System.out.println("2 - eBook");
                    System.out.println("3 - DVD Movie");
                    System.out.println("4 - DVD TV Series");
                    System.out.println("5 - Video Game");
                    System.out.println("6 - CANCEL");
                    userIntInput = askUserInt("", inputScanner);
                    System.out.print("Enter the name of the item you'd like to check in: ");
                    String checkinMediaName = inputScanner.nextLine();
                    libMedia checkinMedia;
                    switch (userIntInput) {
                        case 1: //Book
                            checkinMedia = libraryBooks.get(checkinMediaName);
                            checkinMedia.checkIn();
                            break;

                        case 2: //Digital Book
                            checkinMedia = libraryDigitalBooks.get(checkinMediaName);
                            checkinMedia.checkIn();
                            break;

                        case 3: //DVD Movie
                            checkinMedia = libraryDVDMovies.get(checkinMediaName);
                            checkinMedia.checkIn();
                            break;

                        case 4: //DVD TV Series
                            checkinMedia = libraryDVDSeries.get(checkinMediaName);
                            checkinMedia.checkIn();
                            break;

                        case 5: //Video Game
                            checkinMedia = libraryGames.get(checkinMediaName);
                            checkinMedia.checkIn();
                            break;

                        case 6:
                            break;
                    }
                    break;

                case 3: //Add new item
                    libMedia newMediaItem = libraryAddItem();

                    if (newMediaItem == null) {
                        System.out.println("You have cancelled adding an item to the library.");
                        break;
                    } else {
                        //ADD LIBRARY ITEM CODE HERE
                        switch (newMediaItem.getMediaType()) {

                            case "Paper Book":
                                libraryBooks.put(newMediaItem.getMediaName(), newMediaItem);
                                break;

                            case "Digital Book":
                                libraryDigitalBooks.put(newMediaItem.getMediaName(), newMediaItem);
                                break;

                            case "DVD Movie":
                                libraryDVDMovies.put(newMediaItem.getMediaName(), newMediaItem);
                                break;

                            case "DVD Series":
                                libraryDVDSeries.put(newMediaItem.getMediaName(), newMediaItem);
                                break;

                            case "Game":
                                libraryGames.put(newMediaItem.getMediaName(), newMediaItem);
                                break;

                            default:
                                System.err.print("newMediaItem.getMediaType() produced an unknown result! (Check case 3 in main menu)");
                                break;
                        }
                    }
                    break;

                case 4: //Remove item
                    System.out.println("What type of item would you like to remove? Please type the corresponding number, then press enter: ");
                    System.out.println("1 - Book");
                    System.out.println("2 - eBook");
                    System.out.println("3 - DVD Movie");
                    System.out.println("4 - DVD TV Series");
                    System.out.println("5 - Video Game");
                    System.out.println("6 - CANCEL");
                    userIntInput = askUserInt("", inputScanner);
                    System.out.print("Enter the name of the item you'd like to remove: ");
                    String removeMediaName = inputScanner.nextLine();
                    switch (userIntInput) {
                        case 1: //Book
                            libraryBooks.remove(removeMediaName);
                            System.out.println("Removed " + removeMediaName + " (Paper Book) from the library.");
                            break;

                        case 2: //Digital Book
                            libraryDigitalBooks.remove(removeMediaName);
                            System.out.println("Removed " + removeMediaName + " (Digital Book) from the library.");
                            break;

                        case 3: //DVD Movie
                            libraryDVDMovies.remove(removeMediaName);
                            System.out.println("Removed " + removeMediaName + " (DVD Movie) from the library.");
                            break;

                        case 4: //DVD TV Series
                            libraryDVDSeries.remove(removeMediaName);
                            System.out.println("Removed " + removeMediaName + " (DVD Series) from the library.");
                            break;

                        case 5: //Video Game
                            libraryGames.remove(removeMediaName);
                            System.out.println("Removed " + removeMediaName + " (Video Game) from the library.");
                            break;

                        case 6:
                            break;
                    }
                    break;

                case 5: //View details of item
                    System.out.println("What type of item would you like to view? Please type the corresponding number, then press enter: ");
                    System.out.println("1 - Book");
                    System.out.println("2 - eBook");
                    System.out.println("3 - DVD Movie");
                    System.out.println("4 - DVD TV Series");
                    System.out.println("5 - Video Game");
                    System.out.println("6 - CANCEL");
                    userIntInput = askUserInt("", inputScanner);
                    System.out.print("Enter the name of the item you'd like to view: ");
                    String detailMediaName = inputScanner.nextLine();
                    libMedia detailMedia;
                    switch (userIntInput) {
                        case 1: //Book
                            detailMedia = libraryBooks.get(detailMediaName);
                            detailMedia.printInfo();
                            break;

                        case 2: //Digital Book
                            detailMedia = libraryDigitalBooks.get(detailMediaName);
                            detailMedia.printInfo();
                            break;

                        case 3: //DVD Movie
                            detailMedia = libraryDVDMovies.get(detailMediaName);
                            detailMedia.printInfo();
                            break;

                        case 4: //DVD TV Series
                            detailMedia = libraryDVDSeries.get(detailMediaName);
                            detailMedia.printInfo();
                            break;

                        case 5: //Video Game
                            detailMedia = libraryGames.get(detailMediaName);
                            detailMedia.printInfo();
                            break;

                        case 6:
                            break;
                    }
                    break;

                case 6: //List all items
                    System.out.println("--Books--");
                    printLibraryMap(libraryBooks);
                    System.out.println("--Digital Books--");
                    printLibraryMap(libraryDigitalBooks);
                    System.out.println("--DVD Movies--");
                    printLibraryMap(libraryDVDMovies);
                    System.out.println("--DVD Series--");
                    printLibraryMap(libraryDVDSeries);
                    System.out.println("--Video Games--");
                    printLibraryMap(libraryGames);
                    break;

                case 7: //Close application
                    System.out.println("Are you sure you would like to exit the application?");
                    int userIntInputExit = askUserInt("Enter '1' for yes, or any other number for no: ", inputScanner);
                    if (userIntInputExit == 1) {
                        runAgain = false;
                    }
                    break;

                default:
                    System.out.println("Invalid entry.");

            }

        }

        System.out.println("Thank you for using the Library Management System!");

//        --TESTING libraryAddItem()--
//        libMedia newMediaItem = libraryAddItem();
//        newMediaItem.printInfo();
    }

    public static libMedia libraryAddItem() {

        Scanner inputScanner = new Scanner(System.in);
        Boolean switchStay = true;

        System.out.println("Please enter the following information for the item you'd like to add: ");
        System.out.print("Title: ");
        String mediaName = inputScanner.nextLine();

        System.out.println("What type of item is " + mediaName + "? Please type the corresponding number, then press enter: ");
        System.out.println("1 - Book");
        System.out.println("2 - eBook");
        System.out.println("3 - DVD Movie");
        System.out.println("4 - DVD TV Series");
        System.out.println("5 - Video Game");
        System.out.println("6 - CANCEL");

        int mediaTypeChoice = 0;
        int mediaSeason = 0;
        int mediaEpisodes = 0;
        int mediaPlayerAmount = 0;
        int mediaLength = 0;
        String mediaAuthor = null;
        String mediaBookFormat = null;
        String mediaActors = null;
        String mediaDeveloper = null;
        String mediaPlatform = null;
        String mediaVActors = null;

        while (switchStay) {
            mediaTypeChoice = askUserInt("", inputScanner);
            switch (mediaTypeChoice) {
                case 1:
                    System.out.println("You have selected 'Book'");
                    System.out.print("Author(s): ");
                    mediaAuthor = inputScanner.nextLine();
                    mediaBookFormat = "Paper";
                    mediaLength = askUserInt("Number of pages: ", inputScanner);
                    switchStay = false;
                    break;

                case 2:
                    System.out.println("You have selected 'eBook'");
                    System.out.print("Author(s): ");
                    mediaAuthor = inputScanner.nextLine();
                    mediaBookFormat = "Digital";
                    mediaLength = askUserInt("Number of pages: ", inputScanner);
                    switchStay = false;
                    break;

                case 3:
                    System.out.println("You have selected 'DVD Movie'");
                    System.out.print("Starring Actors: ");
                    mediaActors = inputScanner.nextLine();
                    mediaLength = askUserInt("Movie length in minutes:  ", inputScanner);
                    switchStay = false;
                    break;

                case 4:
                    System.out.println("You have selected 'DVD TV Series'");
                    System.out.print("Starring Actors: ");
                    mediaActors = inputScanner.nextLine();
                    mediaSeason = askUserInt("Season #: ", inputScanner);
                    mediaEpisodes = askUserInt("Number of episodes: ", inputScanner);
                    mediaLength = askUserInt("Per episode length in minutes ", inputScanner);
                    switchStay = false;
                    break;

                case 5:
                    System.out.println("You have selected 'Video Game'");
                    System.out.print("Game Platform (Console): ");
                    mediaPlatform = inputScanner.nextLine();
                    System.out.print("Game Developer(s): ");
                    mediaDeveloper = inputScanner.nextLine();
                    System.out.print("Voice Actor(s): ");
                    mediaVActors = inputScanner.nextLine();
                    mediaPlayerAmount = askUserInt("Number of possible players: ", inputScanner);
                    mediaLength = askUserInt("Average playtime before completion (in hours): ", inputScanner);
                    switchStay = false;
                    break;

                case 6:
                    return null;

                default:
                    System.out.println("Incorrect entry! Please type a number between 1 and 6, then press enter: ");
            }
        }

        System.out.print("Genre: ");
        String mediaGenre = inputScanner.nextLine();

        System.out.print("Description: ");
        String mediaDesc = inputScanner.nextLine();

        System.out.print("Publisher: ");
        String mediaPublisher = inputScanner.nextLine();

        System.out.print("Intended Audience: ");
        String mediaAudience = inputScanner.nextLine();

        Double rentCost = askUserDouble("Cost to rent (Example: 1.12 = $1.12. Enter '0' if free): ", inputScanner);

        int rentDuration = askUserInt("Allowed duration for rental (in days): ", inputScanner);

        libMedia newMediaItem = null;
        switch (mediaTypeChoice) {
            case 1:
                newMediaItem = new libBook(mediaName, mediaGenre, mediaDesc, mediaPublisher, mediaAudience, mediaLength, rentDuration, rentCost, mediaAuthor, mediaBookFormat);
                break;

            case 2:
                newMediaItem = new libBook(mediaName, mediaGenre, mediaDesc, mediaPublisher, mediaAudience, mediaLength, rentDuration, rentCost, mediaAuthor, mediaBookFormat);
                break;

            case 3:
                newMediaItem = new libDVDMovie(mediaName, mediaGenre, mediaDesc, mediaPublisher, mediaAudience, mediaLength, rentDuration, rentCost, mediaActors);
                break;

            case 4:
                newMediaItem = new libDVDSeries(mediaName, mediaGenre, mediaDesc, mediaPublisher, mediaAudience, mediaLength, rentDuration, rentCost, mediaActors, mediaSeason, mediaEpisodes);
                break;

            case 5:
                newMediaItem = new libGame(mediaName, mediaGenre, mediaDesc, mediaPublisher, mediaAudience, mediaLength, rentDuration, rentCost, mediaDeveloper, mediaPlatform, mediaVActors, mediaPlayerAmount);
                break;
        }

        return newMediaItem;
    }

    public static int askUserInt(String questionText, Scanner inputScanner) {
        int userIntInput;

        do {
            System.out.print(questionText);
            while (!inputScanner.hasNextInt()) {
                System.out.println("That's not a valid number! Please enter a valid number: ");
                inputScanner.next();
            }
            userIntInput = inputScanner.nextInt();
        } while (userIntInput <= 0);
        inputScanner.nextLine();
        return userIntInput;
    }

    public static double askUserDouble(String questionText, Scanner inputScanner) {
        double userDoubleInput;
        do {
            System.out.print(questionText);
            while (!inputScanner.hasNextDouble()) {
                System.out.println("That's not a valid number! Please enter a valid number: ");
                inputScanner.next();
            }
            userDoubleInput = inputScanner.nextDouble();
        } while (userDoubleInput <= -1);
        inputScanner.nextLine();
        return userDoubleInput;
    }

    public static void printLibraryMap(Map<String, libMedia> mp) {
        for (Map.Entry<String, libMedia> entry : mp.entrySet()) {
            String key = entry.getKey();
            System.out.println(key);
        }
    }
}
