import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
//import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//import java.util.UUID;

public class Book {

    // Instances
    private String title;
    private String author;
    private String bookISBN;
    private double cost;
    private Date startDate;
    private Date endDate;
//    private static int idNum = 0;

    private static final String DATE_PATTERN = "^\\d{4}/(0[1-9]|1[0-2])/(0[1-9]|[1-2][0-9]|3[0-1])$";
    private static final String M_PATTERN = "^(0[1-9]|1[0-2])$";
    private static final String D_PATTERN = "^(0[1-9]|[1-2][0-9]|3[0-1])$";

    // Constructor method
    public Book() {
        this.title = setTitle();
        this.author = setAuthor();
        this.cost = setCost();
        this.bookISBN = setISBN();
        this.startDate = setStartDate();
//        this.endDate = setEndDate();

        System.out.println("Your book is named " + this.title + ", written by " + this.author
        + " and it costed $" + this.cost + ". \n The book's ID is: " + this.bookISBN);
    }

    public String getTitle(){
        return this.title;
    }

    public String setTitle() {
        System.out.println("Enter the name of the book:");
        Scanner scanner = new Scanner(System.in);
        String title = scanner.nextLine().trim();
        while (title.isEmpty()) {
            System.out.println("You must enter a title!");
            title = scanner.nextLine().trim();
        }
        return title;
    }


    public String getAuthor() {
        return this.author;
    }

    private String setAuthor() {
        System.out.println("Enter the name of the author:");
        Scanner in = new Scanner(System.in);
        String newAuthor = in.nextLine().trim();
        while (newAuthor.isEmpty()) {
            System.out.println("You must not leave this field empty!");
            newAuthor = in.nextLine().trim();
        }
        return newAuthor;
    }

    public double getCost() {
        return this.cost;
    }

    public double setCost() {
        Scanner in = new Scanner(System.in);
        double newCost = 0;
        while (true) {
            try {
                System.out.println("How much did it cost?");
                in = new Scanner(System.in);
                newCost = in.nextDouble();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Please enter a number!");
            }
        }
        while (newCost < 0) {
            try {
                System.out.println("The cost of the book was invalid. Please try again!");
                in = new Scanner(System.in);
                newCost = in.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Please enter a positive number");
            }
        }
        return newCost;
    }

    public String getISBN() {
        return this.bookISBN;
    }

    public String setISBN() {
        System.out.println("Enter the ISBN of the book:");
        Scanner scanner = new Scanner(System.in);
        String isbn = scanner.nextLine().trim();
        while (isbn.isEmpty()) {
            System.out.println("You must enter an ISBN!");
            isbn = scanner.nextLine().trim();
        }
        return isbn;

//        UUID randomID = UUID.randomUUID();
//        return randomID;
////        idNum++;
////        return idNum;

    }

    public Date getStartDate() {
        return this.startDate;
    }

    public Date setStartDate() {

        SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd");
        Date start = null;

        Scanner in = new Scanner(System.in);
        System.out.print("Enter the date you started reading the book (Format: YYYY/MM/DD):");

        String date = in.nextLine().trim();

        Pattern yyyy = Pattern.compile(DATE_PATTERN);
        Matcher matcher = yyyy.matcher(date);

        while (!matcher.find()) {
            System.out.print("There was an error. Please try entering the year again (Format: YYYY):");
            date = in.nextLine().trim();
            matcher = yyyy.matcher(date);
        }

        try {
            start = simpleDate.parse("2019-17-28");
            System.out.println(startDate);
        } catch (ParseException e) {
            System.out.println("error parsing date object for start date");
        }
        return start;
    }

//    public Date getEndDate() {
//        return this.endDate;
//    }
//
//    public Date setEndDate() {
//
//    }

    public String showBookInfo() {
        return "BOOK: " + this.title +
                " AUTHOR: " + this.author +
                " COST: " + this.cost;
    }



}
