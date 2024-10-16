package ca.bcit.comp2522.lab06;

/**
 * Represents a piece of literature with a title.
 *
 * @author Ole Lammers & Tianyou Xie
 * @version 1.0
 */
public abstract class Literature implements Comparable<Literature> {

    /**
     * Returns the title of this piece of literature.
     *
     * @return the title
     */
    public abstract String getTitle();


    /**
     * Compares this literature piece against the other, determining which piece
     * has the title that comes first alphabetically.
     *
     * @param other the literature piece to compare against
     * @return the comparison result of the two titles
     * @see String#compareTo(String)
     */
    @Override
    public final int compareTo(final Literature other) {
        return this.getTitle().compareTo(other.getTitle());
    }

}

