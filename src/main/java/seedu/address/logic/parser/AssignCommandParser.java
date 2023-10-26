package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_MEMBERS;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.AssignCommand;
import seedu.address.logic.parser.exceptions.InvalidFormatException;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.tag.Member;

import java.util.Set;
import java.util.stream.Stream;

/**
 * Parses input arguments and creates a new AssignCommand object
 */
public class AssignCommandParser implements Parser<AssignCommand> {
    public AssignCommand parse(String args) throws ParseException {
        ArgumentMultimap argMultimap = ArgumentTokenizer.tokenize(args, PREFIX_MEMBERS);

        if (!isPrefixPresent(argMultimap, PREFIX_MEMBERS) || !argMultimap.getPreamble().isEmpty()) {
            throw new InvalidFormatException(
                    MESSAGE_INVALID_COMMAND_FORMAT
            );
        }

        Index index = ParserUtil.parseIndex(argMultimap.getPreamble());
        Set<Member> members = ParserUtil.parseMembers(argMultimap.getAllValues(PREFIX_MEMBERS));

        return new AssignCommand(index, members);
    }

    /**
     * Returns true if none of the prefixes contains empty {@code Optional} values in the given
     * {@code ArgumentMultimap}.
     */
    private static boolean isPrefixPresent(ArgumentMultimap argumentMultimap, Prefix... prefixes) {
        return Stream.of(prefixes).allMatch(prefix -> argumentMultimap.getValue(prefix).isPresent());
    }
}
