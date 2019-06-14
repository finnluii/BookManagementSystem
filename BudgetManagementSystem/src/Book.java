import java.sql.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Book {

    // Instances
    private String title;
    private String author;
    private double cost;

    // Constructor method
    public Book(String bookTitle) {
        this.title = bookTitle;
        this.author = setAuthor();
        this.cost = setCost();
        System.out.println("The new book you entered is named " + this.title + " and it is written by " + this.author
        + " and it costed " + this.cost);
    }

    public String getTitle(){
        return this.title;
    }

    public void setTitle(String newTitle) {
        this.title = newTitle;
    }

    public String getAuthor() {
        return this.author;
    }

    private String setAuthor() {
        System.out.println("Enter the name of the author.");
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
                System.out.println("The cost of the book cannot be negative. Please try again!");
                in = new Scanner(System.in);
                newCost = in.nextDouble();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Please enter a positive number");
            }
        }
        return newCost;
    }

}
