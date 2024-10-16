package ca.bcit.comp2522.lab06;

/**
 * Represents a novel literature piece.
 *
 * @author Ole Lammers & Tianyou Xie
 * @version 1.0
 */
public class Novel extends Literature {

    /**
     * Represents the string that is used to separate the datapoint's of a Novel
     * when encoded in a string.
     */
    public static final String DATA_SEPARATOR = "&&";

    /**
     * Represents the minimum year that a novel can be published in.
     */
    public static final int MIN_PUBLISHING_YEAR = 1;

    /**
     * Represents the maximum year that a novel can be published in.
     */
    public static final int MAX_PUBLISHING_YEAR = 2024;

    private final String title;
    private final String authorName;
    private final int yearPublished;

    /**
     * Creates a new novel.
     *
     * @param title         the title
     * @param authorName    the name of the author
     * @param yearPublished the year the novel was published
     */
    public Novel(final String title, final String authorName,
                 final int yearPublished) {
        Novel.validateTitle(title);
        Novel.validateAuthorName(authorName);
        Novel.validateYearPublished(yearPublished);

        this.title = title;
        this.authorName = authorName;
        this.yearPublished = yearPublished;
    }

    /**
     * Validates the given title to ensure it is within limits (exists).
     *
     * @param title the title to validate
     */
    private static void validateTitle(final String title) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("A novel must have a title.");
        }

        if (title.contains(Novel.DATA_SEPARATOR)) {
            throw new IllegalArgumentException(
                    "The title of a novel cannot contain the data " +
                            "separator for novel encoding. ('" +
                            Novel.DATA_SEPARATOR + "')");
        }
    }

    /**
     * Validates the given author name to ensure it is within limits (exists).
     *
     * @param authorName the author name to validate
     */
    private static void validateAuthorName(final String authorName) {
        if (authorName == null || authorName.isBlank()) {
            throw new IllegalArgumentException("A novel must have an author.");
        }

        if (authorName.contains(Novel.DATA_SEPARATOR)) {
            throw new IllegalArgumentException(
                    "The author name of a novel cannot contain the data " +
                            "separator for novel encoding. ('" +
                            Novel.DATA_SEPARATOR + "')");
        }
    }

    /**
     * Validates the given publishing year to ensure it is within limits.
     * ({@value Novel#MIN_PUBLISHING_YEAR} >= x <=
     * {@value Novel#MAX_PUBLISHING_YEAR}).
     *
     * @param yearPublished the publishing year to validate
     */
    private static void validateYearPublished(final int yearPublished) {
        if (yearPublished < Novel.MIN_PUBLISHING_YEAR ||
                yearPublished > Novel.MAX_PUBLISHING_YEAR) {
            throw new IllegalArgumentException(String.format(
                    "A novel must have been published between the years %d " +
                            "and %d.", Novel.MIN_PUBLISHING_YEAR,
                    Novel.MAX_PUBLISHING_YEAR));
        }
    }

    /**
     * Decodes a novel from the given encoded novel string. The string must be
     * in the following format: `{title}{@value Novel#DATA_SEPARATOR}{author
     * name}{@value Novel#DATA_SEPARATOR}{year}`.
     *
     * @param encodedNovel the encoded novel string
     * @return the decoded novel instance
     */
    public static Novel fromEncodedString(final String encodedNovel) {
        final int titlePartIndex;
        final int authorNamePartIndex;
        final int yearPublishedPartIndex;
        final String[] encodedParts;

        titlePartIndex = 0;
        authorNamePartIndex = 1;
        yearPublishedPartIndex = 2;
        encodedParts = encodedNovel.split(Novel.DATA_SEPARATOR);

        if (encodedParts.length != yearPublishedPartIndex + 1) {
            throw new IllegalArgumentException(
                    "The encoded novel does not contain all necessary parts.");
        }

        final String title;
        final String authorName;
        final int yearPublished;

        title = encodedParts[titlePartIndex];
        authorName = encodedParts[authorNamePartIndex];

        try {
            yearPublished = Integer.parseInt(
                    encodedParts[yearPublishedPartIndex]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(
                    "The encoded novel does not contain a valid publishing " +
                            "year.");
        }

        return new Novel(title, authorName, yearPublished);
    }

    /**
     * Returns this novel encoded as a string that can be decoded by
     * {@link Novel#fromEncodedString(String)}.
     *
     * @return the encoded novel string
     */
    public final String toEncodedString() {
        final StringBuilder sb;
        sb = new StringBuilder();

        sb.append(this.getTitle());
        sb.append(Novel.DATA_SEPARATOR);
        sb.append(this.getAuthorName());
        sb.append(Novel.DATA_SEPARATOR);
        sb.append(this.getYearPublished());

        return sb.toString();
    }

    @Override
    public final String toString() {
        return String.format("\"%s\" written in %d by %s.", this.getTitle(),
                             this.getYearPublished(), this.getAuthorName());
    }
    
    @Override
    public final String getTitle() {
        return this.title;
    }

    /**
     * Returns the name of the author of this novel.
     *
     * @return the author name
     */
    public final String getAuthorName() {
        return this.authorName;
    }

    /**
     * Returns the year that this novel was published in.
     *
     * @return the publishing year
     */
    public final int getYearPublished() {
        return this.yearPublished;
    }

}
