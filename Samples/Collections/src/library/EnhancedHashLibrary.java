package library;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * This class is an advanced version of HashLibrary class.
 *
 * All the books would still be categorized by their topic, but this time
 * the feature has been implemented using HashMap and ArrayList collection.
 *
 * Such that categories are keys and books are stored in ArrayLists as the values.
 *
 * @author Amin Habibollah
 * @see Book
 * @see HashLibrary
 * @version 1.0 (3/17/2021)
 */

public class EnhancedHashLibrary {

    private HashMap<String, ArrayList<Book>> books;

    public EnhancedHashLibrary() {
        books = new HashMap<>();
    }

    public void addBook(String category, Book book) {
        // Add a book to its categories's list of books

        // If the category doesn't exist, create an ArrayList of books for it first
        if (books.get(category) == null) {
            ArrayList<Book> newBooks = new ArrayList<>();
            newBooks.add(book);
            this.books.put(category, newBooks);
        }
        else
            books.get(category).add(book);
    }

    public Book findBook(String bookName) {
        for (String category : books.keySet()) {
            for (Book book : books.get(category)) {
                if (book.getName().equals(bookName))
                    return book;
            }
        }
        return null;
    }


    public void deleteBook(String bookName) {
        // Delete a single book in a category
        Iterator<Map.Entry<String, ArrayList<Book>>> entryIterator = books.entrySet().iterator();
        while (entryIterator.hasNext()) {
            Map.Entry<String, ArrayList<Book>> entry = entryIterator.next();
            Iterator<Book> arrayListIterator = entry.getValue().iterator();
            while (arrayListIterator.hasNext()) {
                Book book = arrayListIterator.next();
                if (book.getName().equals(bookName)) {
                    arrayListIterator.remove();
                }
            }

        }
    }

    public void deleteCategory(String category) {
        // Delete an entire category
        books.remove(category);
    }

    public void replaceBook(String category, String bookName, Book alternativeBook) {
        for (int i = 0; i < books.get(category).size(); i++) {
            Book book = books.get(category).get(i);
            if (book.getName().equals(bookName)) {
                books.get(category).set(i, alternativeBook);
            }
        }
    }

    public void printBooks() {
        for (String category : books.keySet()) {
            System.out.println(category + " :");
            for (Book book : books.get(category)) {
                System.out.println(book.echo());
            }
        }
    }

    public void printCategory(String category) {
        for (Book book : books.get(category)) {
            System.out.println(book.echo());
        }
    }

}
