package seedu.address.model.tag;

import org.junit.jupiter.api.Test;

import static seedu.address.testutil.Assert.assertThrows;

class MemberTest {
    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Member(null));
    }

    @Test
    public void constructor_invalidTagName_throwsIllegalArgumentException() {
        String invalidMemberName = "";
        assertThrows(IllegalArgumentException.class, () -> new Tag(invalidMemberName));
    }

    @Test
    public void isValidName() {
        // null tag name
        assertThrows(NullPointerException.class, () -> Member.isValidName(null));
    }
}