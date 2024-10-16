package ca.bcit.comp2522.lab06;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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

        store.items.sort(new Comparator<>() {
            @Override
            public int compare(final Literature a, final Literature b) {
                return a.getTitle().compareTo(b.getTitle());
            }
        });
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
     * Adds all of the {@link Novel} literature pieces in this bookstore to the
     * specified list.
     *
     * @param collection the list in which to insert all the novels
     */
    public final void addNovelsToCollection(List<? super Novel> collection) {
        for (final Literature lit : this.items) {
            final Novel novel;

            if (!(lit instanceof Novel)) {
                continue;
            }

            novel = (Novel) lit;

            collection.add(novel);
        }
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
     * Prints out the titles of all literature pieces in this book store in
     * upper case format.
     */
    public final void printAllTitles() {
        for (final T lit : this.items) {
            System.out.println(lit.getTitle().toUpperCase());
        }
    }

    /**
     * Prints all the titles that contain the specified title part.
     *
     * @param filterTitle the title to filter by
     */
    public final void printBookTitle(final String filterTitle) {
        this.items.forEach(lit -> {
            final String title;

            title = lit.getTitle();

            if (title.contains(filterTitle)) {
                System.out.println();
            }
        });

        for (final T lit : this.items) {
            final String title;
            title = lit.getTitle();

            if (!title.contains(filterTitle)) {
                continue;
            }

            System.out.println(title);
        }
    }

    /**
     * Prints the titles of all books in this book store in alphabetical order.
     */
    public final void printTitlesInAlphaOrder() {
        Collections.sort(
                this.items); // TODO you cannot use a method reference here
        //this.items.sort(String::compareToIgnoreCase())
        this.items.forEach(lit -> System.out.println(lit.getTitle()));
    }

    /**
     * Returns the longest title in of all the literature pieces in this book
     * store.
     *
     * @return the longest title, or null if there are no books
     */
    public final String getLongest() {
        T longestLit = null;
        int longestLength = Integer.MIN_VALUE;

        for (final T lit : this.items) {
            final int len = lit.getTitle().length();

            if (longestLit == null) {
                longestLit = lit;
                longestLength = len;
                continue;
            }

            if (len > longestLength) {
                longestLit = lit;
                longestLength = len;
            }
        }

        if (longestLit == null) {
            return null;
        }

        return longestLit.getTitle();
    }

    /**
     * Returns the amount of literature pieces that have the specified word in
     * the title.
     *
     * @param word the word to check for
     * @return the amount of books containing that word (case-sensitive)
     */
    public final int howManyBooksContain(final String word) {
        final String lowerWord = word.toLowerCase();

        int count = 0;
        for (final T lit : this.items) {
            final String lowerTitle;

            lowerTitle = lit.getTitle().toLowerCase();

            if (lowerTitle.contains(lowerWord)) {
                count++;
            }
        }

        return count;
    }

    /**
     * Returns a list of all the literature pieces that are of the specified
     * title length.
     *
     * @param titleLength the title length to filter by
     * @return the literature pieces matching that title length
     */
    public final List<T> getBooksThisLength(final int titleLength) {
        final List<T> matchingLengthNovels;

        matchingLengthNovels = new ArrayList<>();

        for (final T lit : this.items) {
            final int len = lit.getTitle().length();
            if (len == titleLength) matchingLengthNovels.add(lit);
        }

        return matchingLengthNovels;
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
