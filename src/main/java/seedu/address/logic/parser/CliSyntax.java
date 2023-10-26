package seedu.address.logic.parser;

/**
 * Contains Command Line Interface (CLI) syntax definitions common to multiple commands
 */
public class CliSyntax {

    /* Prefix definitions */
    public static final Prefix PREFIX_DESCRIPTION = new Prefix("d/");
    public static final Prefix PREFIX_TAG = new Prefix("t/");

    public static final Prefix PREFIX_MEMBERS = new Prefix("m/");

    public static final Prefix PREFIX_SORT_ORDER = new Prefix("o/");
    public static final Prefix PREFIX_SORT_TYPE = new Prefix("ty/");
}
