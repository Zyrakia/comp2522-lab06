package ca.bcit.comp2522.lab06;

/**
 * Represents a magazine literature piece.
 *
 * @author Ole Lammers & Tianyou Xie
 * @version 1.0
 */
public class Magazine extends Literature {

    private final String title;

    /**
     * Creates a new magazine.
     *
     * @param title the title
     */
    public Magazine(final String title) {
        Magazine.validateTitle(title);

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
