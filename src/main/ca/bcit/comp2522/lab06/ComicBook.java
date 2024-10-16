package ca.bcit.comp2522.lab06;

/**
 * Represents a comic book literature piece.
 *
 * @author Ole Lammers & Tianyou Xie
 * @version 1.0
 */
public class ComicBook extends Literature {

    private final String title;

    /**
     * Creates a new comic book with the specified title.
     *
     * @param title the title
     */
    public ComicBook(final String title) {
        ComicBook.validateTitle(title);

        this.title = title;
    }

    /**
     * Validates the given title to ensure it is within limits (exists).
     *
     * @param title the title to validate
     */
    private static void validateTitle(final String title) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException(
                    "A literature piece must have a title.");
        }
    }

    @Override
    public final String getTitle() {
        return this.title;
    }

}
