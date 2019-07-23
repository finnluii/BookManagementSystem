import java.util.InputMismatchException;
//import java.util.Random;
import java.util.Scanner;
import java.util.UUID;

public class Book {

    // Instances
    private String title;
    private String author;
    private String bookISBN;
    private double cost;
//    private static int idNum = 0;

    // Constructor method
    public Book() {
        this.title = setTitle();
        this.author = setAuthor();
        this.cost = setCost();
        this.bookISBN = setISBN();

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

    public String showBookInfo() {
        return "BOOK: " + this.title +
                " AUTHOR: " + this.author +
                " COST: " + this.cost;
    }



}
