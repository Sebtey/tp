package seedu.address.model.tag;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents an assignee in the list of tasks in taskWise.
 * Guarantees: immutable;
 */
public class Assignee {
 //TODO create test files

    public final String assigneeName;

    /**
     * Constructs a {@code Assignee}.
     *
     * @param assigneeName A valid tag name.
     */
    public Assignee(String assigneeName) {
        requireNonNull(assigneeName);
        this.assigneeName = assigneeName;
    }

//    /**
//     * Returns true if a given string is a valid tag name.
//     */
//    public static boolean isValidTagName(String test) {
//        return test.matches(VALIDATION_REGEX);
//    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Assignee)) {
            return false;
        }

        Assignee otherTag = (Assignee) other;
        return assigneeName.equals(otherTag.assigneeName);
    }

    @Override
    public int hashCode() {
        return assigneeName.hashCode();
    }

    /**
     * Format state as text for viewing.
     */
    public String toString() {
        return '[' + assigneeName + ']';
    }

}
