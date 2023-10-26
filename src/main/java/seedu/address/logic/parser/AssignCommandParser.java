package seedu.address.logic.parser;

import seedu.address.logic.commands.AssignCommand;

public class AssignCommandParser implements Parser<AssignCommand> {
    public AssignCommand parse(String args) {
        return new AssignCommand();
    }
}
