package main;

import library.ArrayLibrary;
import library.Book;
import library.HashLibrary;

/**
 * This class is a test run for ArrayLibrary and HashLibrary classes
 *
 * Uncomment each part to test the related class.
 *
 * Notice that in this class we have used classes of a different package, hence the imports above.
 *
 * @author Amin Habibollah
 * @see Book
 * @see ArrayLibrary
 * @see HashLibrary
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {

        Book book1 = new Book("My Book 1", "John Doe 1", 2016);
        Book book2 = new Book("My Book 2", "John Doe 2", 2017);
        Book book3 = new Book("My Book 3", "John Doe 3", 2018);
        Book book4 = new Book("My Book 4", "John Doe 4", 2019);
        Book book5 = new Book("My Book 5", "John Doe 5", 2020);


        //Uncomment what's below to test the ArrayLibrary class
//        ArrayLibrary arrayLibrary = new ArrayLibrary();
//
//        // Add some books
//        arrayLibrary.addBook(book1);
//        arrayLibrary.addBook(book2);
//        arrayLibrary.addBook(book3);
//        arrayLibrary.addBook(book4);
//        arrayLibrary.addBook(book5);
//        System.out.println("List of books after add:");
//        arrayLibrary.printBooks();
//        System.out.println("______");
//
//
//        // Find a book
//        System.out.println("Find a specific book:");
//        Book foundBook = arrayLibrary.findBook("My Book 5");
//        System.out.println(foundBook.echo());
//        System.out.println("______");
//
//
//        // Replace a book
//        Book alternative = new Book("Her Book 1", "Jane Doe 1", 2000);
//        arrayLibrary.replaceBook("My Book 2", alternative);
//        System.out.println("List of books after replace:");
//        arrayLibrary.printBooks();
//        System.out.println("______");
//
//
//        // Delete a book
//        arrayLibrary.deleteBook("My Book 3");
//        System.out.println("List of books after delete:");
//        arrayLibrary.printBooks();
//        System.out.println("______");







        // Uncomment what's below to test the HashLibrary class
//        HashLibrary hashLibrary = new HashLibrary();
//
//        hashLibrary.addBook("First Topic", book1);
//        hashLibrary.addBook("Second Topic", book3);
//        hashLibrary.addBook("Third Topic", book5);
//        System.out.println("List of books after add:");
//        hashLibrary.printBooks();
//        System.out.println("______");
//
//
//        // Find a book
//        System.out.println("Find a specific book:");
//        System.out.println(hashLibrary.findBook("My Book 5").echo());
//        System.out.println("______");
//
//
//        // Replace a book
//        Book alternative2 = new Book("Her Book 1", "Jane Doe 1", 2000);
//        hashLibrary.replaceBook("Second Topic", alternative2);
//        System.out.println("List of books after replace:");
//        hashLibrary.printBooks();
//        System.out.println("______");
//
//
//        // Delete a book
//        hashLibrary.deleteBook("My Book 1");
//        System.out.println("List of books after delete:");
//        hashLibrary.printBooks();
//        System.out.println("______");
    }
}
