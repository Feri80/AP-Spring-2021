package library;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * This class represents a library with number of books
 * and methods to manage such library, like adding books, deleting etc.
 *
 * All the books would be stored, using ArrayList collection.
 *
 * @author Amin Habibollah
 * @see Book
 * @see ArrayList
 * @version 1.1 (3/17/2021)
 */

public class ArrayLibrary {

    private ArrayList<Book> books;

    public ArrayLibrary() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        // Add the book at the end of the list
        books.add(book);

    }

    public void addBook2(Book book) {
        // Add the book where ever I want to, using the index
        // In this case the begging of the list
        books.add(0, book);
    }

    public Book findBook(String bookName) {
        // Find a book by its name using for-each loop
        for (Book book : books) {
            if (book.getName().equals(bookName)) {
                return book;
            }
        }


        // Find a book by its name using for loop
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getName().equals(bookName)) {
                return books.get(i);
            }
        }


        // Find a book by its name using while loop
        int j = 0;
        while (j < books.size()) {
            if (books.get(j).getName().equals(bookName)) {
                return books.get(j);
            }
            j++;
        }
        return null;
    }

    /**
     * Delete a book by its name
     * Using the iterator class
     *
     * @param bookName The name of the book to be deleted
     * @return True if the delete was to be successful
     */
    public boolean deleteBook(String bookName) {
        boolean flag = false;
        Iterator<Book> iterator = books.iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.getName().equals(bookName)) {
                iterator.remove();
                flag = true;
            }
        }
        return flag;
    }

    /**
     * Delete a book by the index of it in the list
     *
     * @param index The index of the book in the ArrayList
     */
    public void deleteBook(int index) {
        books.remove(index);
    }

    /**
     * Delete a book by the book itself as a class
     *
     * @param book The book to be deleted
     */
    public void deleteBook(Book book) {
        books.remove(book);
    }

    public void replaceBook(String bookName, Book alternativeBook) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getName().equals(bookName)) {
                books.set(i, alternativeBook);
            }
        }
    }

    public void printBooks() {
        for (Book book : books) {
            System.out.println(book.echo());
        }
    }

}
