package seedu.address.logic.sort.enums;

/**
 * Enum to represent the field to sort by in the sort.
 */
public enum SortTypeEnum {
    TASK_NAME("task name"),
    PRIORITY("priority"),
    DEADLINE("deadline");

    public static final String MESSAGE_CONSTRAINTS = "Oh no! I cannot understand the sort order: ";

    private final String representation;

    SortTypeEnum(String representation) {
        this.representation = representation;
    }

    /**
     * Returns the relevant {@code SortTypeEnum} based on the String input.
     *
     * @param sortOrder String input to parse
     * @return {@code SortTypeEnum} object
     * @throws IllegalArgumentException if the input String is not a valid input String value
     */
    public static SortTypeEnum of(String sortOrder) {
        switch (sortOrder) {
        case "t":
        case "tn":
        case "task":
        case "tsk nm":
        case "task name":
            return SortTypeEnum.TASK_NAME;
        case "p":
        case "pr":
        case "pri":
        case "prior":
        case "priority":
            return SortTypeEnum.PRIORITY;
        case "d":
        case "dl":
        case "deadln":
        case "deadline":
            return SortTypeEnum.DEADLINE;
        default:
            throw new IllegalArgumentException("Invalid Enum value");
        }
    }

    /**
     * Converts the enum object to its String representation.
     *
     * @return String representation of Enum object
     */
    @Override
    public String toString() {
        return this.representation;
    }
}
