package seedu.address.logic.commands;


import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.person.exceptions.DuplicatePersonException;
import seedu.address.model.person.exceptions.PersonNotFoundException;
import seedu.address.model.tag.Tag;


import static java.util.Objects.requireNonNull;

public class DeleteTagCommand extends UndoableCommand {

    public static final String COMMAND_WORD = "deletetag";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Deletes tag\n"
            + "Parameters: valid tag name used\n"
            + "Example: " + COMMAND_WORD + " family";

    public static final String MESSAGE_DELETE_TAG_SUCCESS = "Deleted Tag: %1$s";
    private final Tag toDelete;

    public DeleteTagCommand(Tag tag) { toDelete = tag; }

    @Override
    public CommandResult executeUndoableCommand() throws CommandException, DuplicatePersonException, PersonNotFoundException {
        requireNonNull(toDelete);
        model.deleteTag(toDelete);

        return new CommandResult(String.format(MESSAGE_DELETE_TAG_SUCCESS, toDelete));
    }
}
