package seedu.address.model.tag;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

class MemberTest {
    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Member(null));
    }

    @Test
    public void constructor_invalidMemberName_throwsIllegalArgumentException() {
        String invalidMemberName = "";
        assertThrows(IllegalArgumentException.class, () -> new Tag(invalidMemberName));
    }

    @Test
    public void equals_sameName() {
        Member member = new Member("John");
        Member John = new Member("John");

        assertTrue(member.equals(John));
    }

    @Test
    public void isValidName() {
        // null tag name
        assertThrows(NullPointerException.class, () -> Member.isValidName(null));
    }
}
