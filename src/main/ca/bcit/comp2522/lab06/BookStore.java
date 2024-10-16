package ca.bcit.comp2522.lab06;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a store that holds a bunch of literature pieces.
 *
 * @param <T> the type of literature this bookstore keeps
 * @author Ole Lammers & Tianyou Xie
 * @version 1.0
 */
public class BookStore<T extends Literature> {

    private final List<T> items = new ArrayList<>();

    /**
     * Entry point for the bookstore class.
     *
     * @param args the command line arguments, unused
     */
    public static void main(final String[] args) {
        BookStore<Literature> store = new BookStore<>();

        store.addItem(new Novel("War and Peace", "Leo Tolstoy", 1867));
        store.addItem(new ComicBook("Spider-Man"));
        store.addItem(new Magazine("National Geographic"));

        store.printItems();
    }

    /**
     * Adds a piece of literature to this bookstore.
     *
     * @param item the piece of literature
     */
    public final void addItem(T item) {
        this.items.add(item);
    }

    /**
     * Prints the titles of all pieces of literature that are kept within this
     * bookstore.
     */
    public final void printItems() {
        for (final T item : this.items) {
            System.out.println(item.getTitle());
        }
    }

    /**
     * Represents information about a bookstore.
     */
    public static final class BookstoreInfo {

        /**
         * Prints out a formatted information message containing the specified
         * bookstore details.
         *
         * @param storeName the name of the bookstore
         * @param itemCount the literature piece count of the bookstore
         */
        public void displayInfo(final String storeName,
                                final int itemCount) {
            System.out.println(
                    "BookStore: " + storeName + ", Items: " + itemCount);

        }

    }

    /**
     * Enables statistical analysis of literature pieces and novels within a
     * bookstore.
     */
    public final class NovelStatistics {

        /**
         * Computes the average title length of all literature pieces within
         * this bookstore.
         *
         * @return the average title character length
         */
        public double averageTitleLength() {
            int totalLength = 0;

            for (final Literature lit : BookStore.this.items) {
                totalLength += lit.getTitle().length();
            }

            return (double) totalLength / BookStore.this.items.size();
        }

    }

}
