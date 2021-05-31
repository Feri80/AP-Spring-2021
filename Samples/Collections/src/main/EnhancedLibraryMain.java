package main;


import library.Book;
import library.EnhancedHashLibrary;

/**
 * This class is a test run for EnhancedHashLibrary class
 *
 * Notice that in this class we have used a class of a different package, hence the imports above.
 *
 * @author Amin Habibollah
 * @see Book
 * @see EnhancedHashLibrary
 * @version 1.0
 */
public class EnhancedLibraryMain {
    public static void main(String[] args) {

        Book book1 = new Book("My Book 1", "John Doe 1", 2016);
        Book book2 = new Book("My Book 2", "John Doe 2", 2017);
        Book book3 = new Book("My Book 3", "John Doe 3", 2018);
        Book book4 = new Book("My Book 4", "John Doe 4", 2019);
        Book book5 = new Book("My Book 5", "John Doe 5", 2020);

        EnhancedHashLibrary enhancedHashLibrary = new EnhancedHashLibrary();

        enhancedHashLibrary.addBook("First Topic", book1);
        enhancedHashLibrary.addBook("First Topic", book2);
        enhancedHashLibrary.addBook("Second Topic", book3);
        enhancedHashLibrary.addBook("Second Topic", book4);
        enhancedHashLibrary.addBook("Third Topic", book5);
        System.out.println("List of books after add:");
        enhancedHashLibrary.printBooks();
        System.out.println("______");


        // Find a book
        System.out.println("Find a specific book:");
        System.out.println(enhancedHashLibrary.findBook("My Book 5").echo());
        System.out.println("______");


        // Replace a book
        Book alternative2 = new Book("Her Book 1", "Jane Doe 1", 2000);
        enhancedHashLibrary.replaceBook("Second Topic", "My Book 4", alternative2);
        System.out.println("List of books after replace:");
        enhancedHashLibrary.printBooks();
        System.out.println("______");


        // Delete a book
        enhancedHashLibrary.deleteBook("My Book 1");
        System.out.println("List of books after delete:");
        enhancedHashLibrary.printBooks();
        System.out.println("______");
    }
}
