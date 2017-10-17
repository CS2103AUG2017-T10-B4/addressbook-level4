package seedu.address.logic.commands;

import seedu.address.logic.CommandHistory;
import seedu.address.logic.UndoRedoStack;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;

import static seedu.address.logic.commands.CommandTestUtil.assertCommandFailure;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

public class DeleteTagCommandTest {

    private Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs());

    public void execute() throws Exception{
        assertCommandFailure(prepareCommand(), model, MESSAGE_NOT_IMPLEMENTED_YET);
    }

    private DeleteTagCommand prepareCommand() {
        DeleteTagCommand deleteTagCommand = new DeleteTagCommand();
        deleteTagCommand.setData(model, new CommandHistory(), new UndoRedoStack());
        return deleteTagCommand;
    }

}
