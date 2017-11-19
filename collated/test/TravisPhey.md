# TravisPhey
###### \java\seedu\address\logic\commands\DeleteMultipleCommandTest.java
``` java
        DeleteMultipleCommand deleteMultipleCommand = prepareCommand(INDEX_FIRST_PERSON);

        String expectedMessage = String.format(DeleteMultipleCommand.MESSAGE_DELETE_PERSON_SUCCESS, personToDelete);
```
###### \java\seedu\address\logic\commands\DeleteMultipleCommandTest.java
``` java

        ModelManager expectedModel = new ModelManager(model.getAddressBook(), new UserPrefs());
        expectedModel.deletePerson(personToDelete);

```
###### \java\seedu\address\logic\commands\DeleteMultipleCommandTest.java
``` java
        assertCommandSuccess(deleteMultipleCommand, model, expectedMessage, expectedModel);
```
###### \java\seedu\address\logic\commands\DeleteMultipleCommandTest.java
``` java
    }

    @Test
    public void execute_invalidIndexUnfilteredList_throwsCommandException() throws Exception {
        Index outOfBoundIndex = Index.fromOneBased(model.getFilteredPersonList().size() + 1);
```
###### \java\seedu\address\logic\commands\DeleteMultipleCommandTest.java
``` java
        DeleteMultipleCommand deleteMultipleCommand = prepareCommand(outOfBoundIndex);

        assertCommandFailure(deleteMultipleCommand, model, Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
```
###### \java\seedu\address\logic\commands\DeleteMultipleCommandTest.java
``` java
    }

    @Test
    public void execute_validIndexFilteredList_success() throws Exception {
        showFirstPersonOnly(model);

        ReadOnlyPerson personToDelete = model.getFilteredPersonList().get(INDEX_FIRST_PERSON.getZeroBased());
```
###### \java\seedu\address\logic\commands\DeleteMultipleCommandTest.java
``` java
        DeleteMultipleCommand deleteMultipleCommand = prepareCommand(INDEX_FIRST_PERSON);

        String expectedMessage = String.format(DeleteMultipleCommand.MESSAGE_DELETE_PERSON_SUCCESS, personToDelete);
```
###### \java\seedu\address\logic\commands\DeleteMultipleCommandTest.java
``` java

        Model expectedModel = new ModelManager(model.getAddressBook(), new UserPrefs());
        expectedModel.deletePerson(personToDelete);
        showNoPerson(expectedModel);

```
###### \java\seedu\address\logic\commands\DeleteMultipleCommandTest.java
``` java
        assertCommandSuccess(deleteMultipleCommand, model, expectedMessage, expectedModel);
```
###### \java\seedu\address\logic\commands\DeleteMultipleCommandTest.java
``` java
    }

    @Test
    public void execute_invalidIndexFilteredList_throwsCommandException() {
        showFirstPersonOnly(model);

        Index outOfBoundIndex = INDEX_SECOND_PERSON;
        // ensures that outOfBoundIndex is still in bounds of address book list
        assertTrue(outOfBoundIndex.getZeroBased() < model.getAddressBook().getPersonList().size());

```
###### \java\seedu\address\logic\commands\DeleteMultipleCommandTest.java
``` java
        DeleteMultipleCommand deleteMultipleCommand = prepareCommand(outOfBoundIndex);

        assertCommandFailure(deleteMultipleCommand, model, Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
```
###### \java\seedu\address\logic\commands\DeleteMultipleCommandTest.java
``` java
    }

```
###### \java\seedu\address\logic\commands\DeleteMultipleCommandTest.java
``` java
    @Test
    public void equals() {
        ArrayList<Index> IndexFirstList = new ArrayList<>();
        IndexFirstList.add(INDEX_FIRST_PERSON);
        DeleteMultipleCommand deleteFirstCommand = new DeleteMultipleCommand(IndexFirstList);
        ArrayList<Index> IndexSecondList = new ArrayList<>();
        IndexSecondList.add(INDEX_SECOND_PERSON);
        DeleteMultipleCommand deleteSecondCommand = new DeleteMultipleCommand(IndexSecondList);

        // same object -> returns true
        assertTrue(deleteFirstCommand.equals(deleteFirstCommand));

        // same values -> returns true
        //DeleteMultipleCommand deleteFirstCommandCopy = new DeleteMultipleCommand(INDEX_FIRST_PERSON);
        DeleteMultipleCommand deleteFirstCommandCopy = new DeleteMultipleCommand(IndexFirstList);
        assertTrue(deleteFirstCommand.equals(deleteFirstCommandCopy));

        // different types -> returns false
        assertFalse(deleteFirstCommand.equals(1));

        // null -> returns false
        assertFalse(deleteFirstCommand.equals(null));

        // different person -> returns false
        assertFalse(deleteFirstCommand.equals(deleteSecondCommand));
    }
```
###### \java\seedu\address\logic\commands\DeleteMultipleCommandTest.java
``` java

    /**
     * Returns a {@code DeleteCommand} with the parameter {@code index}.
     */
```
###### \java\seedu\address\logic\commands\DeleteMultipleCommandTest.java
``` java
    private DeleteMultipleCommand prepareCommand(Index index) {
        ArrayList<Index> IndexList = new ArrayList<>();
        IndexList.add(index);
        DeleteMultipleCommand deleteMultipleCommand = new DeleteMultipleCommand(IndexList);
        deleteMultipleCommand.setData(model, new CommandHistory(),
            new UndoRedoStack(), new RecentlyDeletedQueue(), new String());
        return deleteMultipleCommand;
    }
```
###### \java\seedu\address\logic\commands\DeleteMultipleCommandTest.java
``` java

    /**
     * Updates {@code model}'s filtered list to show no one.
     */
    private void showNoPerson(Model model) {
        model.updateFilteredPersonList(p -> false);

        assert model.getFilteredPersonList().isEmpty();
    }
}
```
