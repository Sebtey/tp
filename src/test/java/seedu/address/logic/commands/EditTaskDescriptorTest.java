package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.DESC_AMY;
import static seedu.address.logic.commands.CommandTestUtil.DESC_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_HUSBAND;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.EditCommand.EditTaskDescriptor;
import seedu.address.testutil.EditTaskDescriptorBuilder;

public class EditTaskDescriptorTest {

    @Test
    public void equals() {
        // same values -> returns true
        EditTaskDescriptor descriptorWithSameValues = new EditTaskDescriptor(DESC_AMY);
        assertTrue(DESC_AMY.equals(descriptorWithSameValues));

        // same object -> returns true
        assertTrue(DESC_AMY.equals(DESC_AMY));

        // null -> returns false
        assertFalse(DESC_AMY.equals(null));

        // different types -> returns false
        assertFalse(DESC_AMY.equals(5));

        // different values -> returns false
        assertFalse(DESC_AMY.equals(DESC_BOB));

        // different name -> returns false
        EditTaskDescriptor editedAmy = new EditTaskDescriptorBuilder(DESC_AMY).withDescription(VALID_NAME_BOB).build();
        assertFalse(DESC_AMY.equals(editedAmy));

        // different tags -> returns false
        editedAmy = new EditTaskDescriptorBuilder(DESC_AMY).withMembers(VALID_TAG_HUSBAND).build();
        assertFalse(DESC_AMY.equals(editedAmy));
    }

    @Test
    public void toStringMethod() {
        EditTaskDescriptor editTaskDescriptor = new EditTaskDescriptor();
        String expected = EditTaskDescriptor.class.getCanonicalName() + "{description="
                + editTaskDescriptor.getDescription().orElse(null) + ", note="
                + editTaskDescriptor.getNote().orElse(null) + ", tags="
                + editTaskDescriptor.getTags().orElse(null) + ", deadline="
                + editTaskDescriptor.getDeadline().orElse(null) + ", priority="
                + editTaskDescriptor.getPriority().orElse(null) + ", members="
                + editTaskDescriptor.getMembers().orElse(null) + "}";
        assertEquals(expected, editTaskDescriptor.toString());
    }
}
