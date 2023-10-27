package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_MEMBERS;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_TASKS;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import seedu.address.commons.core.index.Index;
import seedu.address.commons.util.ToStringBuilder;
import seedu.address.logic.Messages;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.logic.commands.exceptions.IllegalTaskIndexException;
import seedu.address.model.Model;
import seedu.address.model.tag.Member;
import seedu.address.model.task.Description;
import seedu.address.model.task.Status;
import seedu.address.model.task.Task;

/**
 * Assigns a task identified using its displayed index from taskWise to the specified member(s)
 */
public class AssignCommand extends Command {
    public static final String COMMAND_WORD = "assign";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Assigns mentioned individuals to task identified"
            + " by the index number used in the displayed task list. "
            + "Task's members will add in the mentioned individuals.\n"
            + "Parameters: INDEX (must be a positive integer) "
            + PREFIX_MEMBERS + "[member name]\n"
            + "Example: " + COMMAND_WORD + " 1 a/John";

    public static final String MESSAGE_ASSIGN_TASK_SUCCESS = "Assigned Task: %1$s with members ";

    private final Index index;
    private final MemberList members;

    /**
     * @param index of the task in the filtered task list.
     * @param members to be assigned to the task.
     */
    public AssignCommand(Index index, Set<Member> members) {
        requireNonNull(index);

        this.index = index;
        this.members = new MemberList();
        this.members.setMembers(members);
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        List<Task> lastShownList = model.getFilteredTaskList();

        if (index.getZeroBased() >= lastShownList.size()) {
            throw new IllegalTaskIndexException(Messages.MESSAGE_INVALID_TASK_DISPLAYED_INDEX);
        }

        Task taskToAssign = lastShownList.get(index.getZeroBased());
        Task assignedTask = createAssignedTask(taskToAssign, members);

        model.setTask(taskToAssign, assignedTask);
        model.updateFilteredTaskList(PREDICATE_SHOW_ALL_TASKS);

        return new CommandResult(String.format(MESSAGE_ASSIGN_TASK_SUCCESS, Messages.format(assignedTask))
         + members);
    }

    /**
     * Creates and returns a {@code Task} with the details of {@code taskToEdit}
     * edited with {@code editTaskDescriptor}.
     */
    private static Task createAssignedTask(Task taskToAssign, MemberList members) {
        assert taskToAssign != null;

        //TODO integrate with other features - deadline, priority
        Description description = taskToAssign.getDescription();
        Status status = taskToAssign.getStatus(); //Not edited using editCommand

        //TODO assign members before returning
        Task updatedTask = new Task(description, status);

        return updatedTask;
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
                && members.equals(otherAssignCommand.members);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("index", index)
                .add("members", members.toString())
                .toString();
    }

    /**
     * Stores the members to assign to the task.
     */
    public static class MemberList {
        public static final String MESSAGE_CONSTRAINT =
                "Member list should has at least 1 member name";
        private Set<Member> members;

        public MemberList() {}

        /**
         * Copy constructor.
         * A defensive copy of {@code members} is used internally.
         */
        public MemberList(MemberList toCopy) {
            setMembers(toCopy.members);
        }

        /**
         * Sets {@code members} to this object's {@code members}.
         * A defensive copy of {@code members} is used internally.
         */
        public void setMembers(Set<Member> members) {
            this.members = (members != null) ? new HashSet<>(members) : null;
        }

        /**
         * Returns an unmodifiable tag set, which throws {@code UnsupportedOperationException}
         * if modification is attempted.
         * Returns {@code Optional#empty()} if {@code members} is null.
         */
        public Optional<Set<Member>> getTags() {
            return Optional.ofNullable(members).map(x -> Collections.unmodifiableSet(members));
        }

        @Override
        public boolean equals(Object other) {
            if (other == this) {
                return true;
            }

            // instanceof handles nulls
            if (!(other instanceof MemberList)) {
                return false;
            }

            MemberList otherMemberList = (MemberList) other;
            return Objects.equals(members, otherMemberList.members);
        }

        @Override
        public String toString() {
            return members.toString();
        }
    }
}
