package library;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * This class represents a library with number of books
 * and methods to manage such library, like adding books, deleting etc.
 *
 * All the books would be categorized by their topic
 * this feature has been implemented using HashMap collection.
 *
 * Such that categories are keys and books as the values.
 *
 * @author Amin Habibollah
 * @see Book
 * @see HashMap
 * @version 1.1 (3/17/2021)
 */
public class HashLibrary {

    private HashMap<String, Book> books;

    public HashLibrary() {
        books = new HashMap<>();
    }

    public void addBook(String category, Book book) {
        books.put(category, book);
    }

    public Book findBook(String bookName) {
        // Find a book by its name using for-each and entries
        for (Map.Entry<String, Book> entry : books.entrySet()) {
            if (entry.getValue().getName().equals(bookName)) {
                return entry.getValue();
            }
        }



        // Find a book by its name using for-each and keySet
        for (String category : books.keySet()) {
            if (books.get(category).getName().equals(bookName)) {
                return books.get(category);
            }
        }


        return null;
    }

    /**
     * Delete a book using the iterator class
     * Notice that we iterate on entries not keys or values
     *
     * @param bookName The name of the book
     */
    public void deleteBook(String bookName) {
        Iterator<Map.Entry<String, Book>> iterator = books.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Book> entry = iterator.next();
            if(bookName.equals(entry.getValue().getName())){
                iterator.remove();
            }
        }

    }

    /**
     * Delete a book by its name
     * Using an enhanced method of deleting an element from HashMap, with removeIf() and filtering
     *
     * @param bookName
     */
    public void deleteBook2(String bookName) {
        books.entrySet().removeIf(entry -> bookName.equals(entry.getValue()));
    }


    public void replaceBook(String category, Book alternativeBook) {
        books.replace(category, alternativeBook);
    }

    public void printBooks() {
        for (String category : books.keySet()) {
            System.out.println(category + " | " + books.get(category).echo());
        }
    }

}
