package seedu.address.logic.commands;

import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static seedu.address.testutil.TypicalTasks.getTypicalTaskWise;

class AssignCommandTest {
    //TODO

    private Model model = new ModelManager(getTypicalTaskWise(), new UserPrefs());

    @Test
    public void execute_invalidIndexUnfilteredList_throwsCommandException() {
        assertFalse(true);
    }

    @Test
    public void execute_invalidIndexFilteredList_throwsCommandException() {
        assertFalse(true);
    }

    @Test
    public void execute_validIndexUnfilteredList_success() {
        assertFalse(true);
    }

    @Test
    public void execute_singleMember_success() {
        assertFalse(true);
    }

    @Test
    public void execute_multipleMembers_success() {
        assertFalse(true);
    }

    @Test
    public void createAssignedTask() {
        //TODO need finish implementation for this method in AssignCommand
        assertFalse(true);
    }

    @Test
    public void equals() {
        assertFalse(true);
    }

    @Test
    public void toStringMethod() {
        assertFalse(true);
    }
}