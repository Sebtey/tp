package seedu.address.model.tag;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents an assignee in the list of tasks in taskWise.
 * Guarantees: immutable;
 */
public class Member {
 //TODO create test files

    public final String memberName;

    /**
     * Constructs a {@code Assignee}.
     *
     * @param memberName A valid tag name.
     */
    public Member(String memberName) {
        requireNonNull(memberName);
        this.memberName = memberName;
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
        if (!(other instanceof Member)) {
            return false;
        }

        Member otherTag = (Member) other;
        return memberName.equals(otherTag.memberName);
    }

    @Override
    public int hashCode() {
        return memberName.hashCode();
    }

    /**
     * Format state as text for viewing.
     */
    public String toString() {
        return '[' + memberName + ']';
    }

}
