package seedu.address.logic.commands;

import seedu.address.commons.core.index.Index;
import seedu.address.commons.util.ToStringBuilder;
import seedu.address.logic.Messages;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.logic.commands.exceptions.IllegalTaskIndexException;
import seedu.address.model.Model;
import seedu.address.model.tag.Member;
import seedu.address.model.tag.Member;
import seedu.address.model.task.Description;
import seedu.address.model.task.Status;
import seedu.address.model.task.Task;

import java.util.Arrays;
import java.util.List;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ASSIGNEES;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_TASKS;

public class AssignCommand extends Command{
    public static final String COMMAND_WORD = "assign";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Assigns mentioned individuals to task identified"
            + "by the index number used in the displayed task list. "
            + "Task's assignees will add in the mentioned individuals.\n"
            + "Parameters: INDEX (must be a positive integer) "
            + PREFIX_ASSIGNEES + "[assignee name]\n"
            + "Example: " + COMMAND_WORD + " 1 a/John";

    public static final String MESSAGE_EDIT_TASK_SUCCESS = "Edited Task: %1$s";

    private final Index index;
    private final Member[] assignees; //TODO change implementation to a new form

//    private final EditCommand.EditTaskDescriptor editTaskDescriptor;

    /**
     * @param index of the task in the filtered task list.
     * @param assignees to be assigned to the task.
     */
    public AssignCommand(Index index, String[] assignees) {
        requireNonNull(index);

        //todo check that assignees contain at least one String
        //duplicates will be handled by the Task

        this.index = index;
        this.assignees = Arrays.stream(assignees).map(name -> new Member(name)).toArray(Member[]::new);
//        this.editTaskDescriptor = new EditCommand.EditTaskDescriptor(editTaskDescriptor);
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        List<Task> lastShownList = model.getFilteredTaskList();

        if (index.getZeroBased() >= lastShownList.size()) {
            throw new IllegalTaskIndexException(Messages.MESSAGE_INVALID_TASK_DISPLAYED_INDEX);
        }

        Task taskToAssign = lastShownList.get(index.getZeroBased());
        Task assignedTask = createAssignedTask(taskToAssign, assignees);

        model.setTask(taskToAssign, assignedTask);
        model.updateFilteredTaskList(PREDICATE_SHOW_ALL_TASKS);

        //TODO update Message.format to show assignees too
        return new CommandResult(String.format(MESSAGE_EDIT_TASK_SUCCESS, Messages.format(assignedTask)));
    }

    /**
     * Creates and returns a {@code Task} with the details of {@code taskToEdit}
     * edited with {@code editTaskDescriptor}.
     */
    private static Task createAssignedTask(Task taskToAssign, Member[] assignees) {
        assert taskToAssign != null;

//        Description updatedName = editTaskDescriptor.getDescription().orElse(taskToEdit.getDescription());
        Description description = taskToAssign.getDescription();
        Status status = taskToAssign.getStatus(); //Not edited using editCommand

        //TODO assign assignees before returning
        return new Task(description, status);
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof AssignCommand)) {
            return false;
        }

        AssignCommand otherAssignCommand = (AssignCommand) other;
        return index.equals(otherAssignCommand.index)
                && assignees.equals(otherAssignCommand.assignees);
        //todo come up with new encapsulation for the assignees, mainly for the equals method
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("index", index)
                .add("assignees", assignees.toString())
                .toString();
    }


    //TODO edit to store the assignees
//    /**
//     * Stores the assignees to assign to the task.
//     */
//    public static class AssigneeList {
//        private Set<Assignee> assignees;
//
//        public AssigneeList() {}
//
//        /**
//         * Copy constructor.
//         * A defensive copy of {@code tags} is used internally.
//         */
//        public EditTaskDescriptor(EditCommand.EditTaskDescriptor toCopy) {
//            setDescription(toCopy.description);
//            setTags(toCopy.tags);
//        }
//
//        /**
//         * Returns true if at least one field is edited.
//         */
//        public boolean isAnyFieldEdited() {
//            return CollectionUtil.isAnyNonNull(description, tags);
//        }
//
//        public void setDescription(Description description) {
//            this.description = description;
//        }
//
//        public Optional<Description> getDescription() {
//            return Optional.ofNullable(description);
//        }
//
//        /**
//         * Sets {@code tags} to this object's {@code tags}.
//         * A defensive copy of {@code tags} is used internally.
//         */
//        public void setTags(Set<Tag> tags) {
//            this.tags = (tags != null) ? new HashSet<>(tags) : null;
//        }
//
//        /**
//         * Returns an unmodifiable tag set, which throws {@code UnsupportedOperationException}
//         * if modification is attempted.
//         * Returns {@code Optional#empty()} if {@code tags} is null.
//         */
//        public Optional<Set<Tag>> getTags() {
//            return Optional.ofNullable(tags).map(x -> Collections.unmodifiableSet(tags));
//        }
//
//        @Override
//        public boolean equals(Object other) {
//            if (other == this) {
//                return true;
//            }
//
//            // instanceof handles nulls
//            if (!(other instanceof EditCommand.EditTaskDescriptor)) {
//                return false;
//            }
//
//            EditCommand.EditTaskDescriptor otherEditTaskDescriptor = (EditCommand.EditTaskDescriptor) other;
//            return Objects.equals(description, otherEditTaskDescriptor.description)
//                    && Objects.equals(tags, otherEditTaskDescriptor.tags);
//        }
//
//        @Override
//        public String toString() {
//            return new ToStringBuilder(this)
//                    .add("description", description)
//                    .add("tags", tags)
//                    .toString();
//        }
//    }
}
