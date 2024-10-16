package ca.bcit.comp2522.lab06;

import java.util.List;

/**
 * Represents a store that holds a bunch of literature pieces.
 *
 * @param <T> the type of literature this bookstore keeps
 * @author Ole Lammers & Tianyou Xie
 * @version 1.0
 */
public class BookStore<T extends Literature> {

    private final String name;
    private final List<T> items;

    /**
     * Creates a new bookstore.
     *
     * @param name  the name of the bookstore
     * @param items the initial pieces of literature
     */
    public BookStore(final String name, final List<T> items) {
        BookStore.validateName(name);

        this.name = name;
        this.items = items;
    }

    /**
     * Entry point for the bookstore class.
     *
     * @param args the command line arguments, unused
     */
    public static void main(final String[] args) {
        
    }

    /**
     * Validates the given name to ensure it is within limits.
     *
     * @param name the name to validate
     */
    private static void validateName(final String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("A bookstore must have a name.");
        }
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
     * Returns the name of this bookstore.
     *
     * @return the name
     */
    public final String getName() {
        return this.name;
    }

}
