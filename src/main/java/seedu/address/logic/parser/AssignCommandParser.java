package seedu.address.logic.parser;

import seedu.address.logic.commands.AssignCommand;

public class AssignCommandParser extends Parser<AssignCommand> {
    public AssignCommand parse(String args) {
        return new AssignCommand();
    }
}
