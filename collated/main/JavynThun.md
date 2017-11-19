# JavynThun
###### \java\seedu\address\logic\commands\SortCommand.java
``` java
/**
 * Sorts all persons in the address book by name to the user.
 */
public class SortCommand extends Command {

    public static final String COMMAND_WORD = "sort";
    public static final String COMMAND_ALIAS = "s";
    public static final String MESSAGE_SUCCESS = "List is sorted!";
    public static final String MESSAGE_EMPTY_LIST = "List is empty!";

    private ArrayList<ReadOnlyPerson> personList;

    public SortCommand() {
        personList = new ArrayList<>();
    }

    @Override
    public CommandResult execute() {
        model.updateFilteredPersonList(PREDICATE_SHOW_ALL_PERSONS);
        Boolean listSize = model.sortPersonList(personList);
        if (listSize == null) {
            return new CommandResult(MESSAGE_EMPTY_LIST);
        }

        return new CommandResult(MESSAGE_SUCCESS);
    }
}
```
###### \java\seedu\address\logic\parser\CliSyntax.java
``` java
    public static final Prefix PREFIX_OCCUPATION = new Prefix("o/");
```
###### \java\seedu\address\logic\parser\CliSyntax.java
``` java
    public static final Prefix PREFIX_WEBSITE = new Prefix("w/");
```
###### \java\seedu\address\logic\parser\ParserUtil.java
``` java
    /**
     * Parses a {@code Optional<String> occupation} into an {@code Optional<Occupation>} if {@code occupation} is
     * present.
     * See header comment of this class regarding the use of {@code Optional} parameters.
     */
    public static Optional<Occupation> parseOccupation(Optional<String> occupation) throws IllegalValueException {
        requireNonNull(occupation);
        return occupation.isPresent() ? Optional.of(new Occupation(occupation.get())) : Optional.empty();
    }
```
###### \java\seedu\address\logic\parser\ParserUtil.java
``` java
    public static Optional<Website> parseWebsite(Optional<String> website) throws IllegalValueException {
        requireNonNull(website);
        return website.isPresent() ? Optional.of(new Website(website.get())) : Optional.empty();
    }
```
###### \java\seedu\address\model\Model.java
``` java
    Boolean sortPersonList(ArrayList<ReadOnlyPerson> personlist);

}
```
###### \java\seedu\address\model\ModelManager.java
``` java
    @Override
    public Boolean sortPersonList(ArrayList<ReadOnlyPerson> personlist) {
        if (filteredPersons.isEmpty()) {
            return false;
        }
        personlist.addAll(filteredPersons);
        Collections.sort(personlist, Comparator.comparing(name -> name.toString().toLowerCase()));

        try {
            addressBook.setPersons(personlist);
        } catch (DuplicatePersonException e) {
            System.out.println("Address book cannot not have duplicate persons");
        }
        return true;
    }
```
###### \java\seedu\address\model\person\Occupation.java
``` java
/**
 * Represents a Person's occupation in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidOccupation(String)}
 */
public class Occupation {

    public static final String MESSAGE_OCCUPATION_CONSTRAINTS =
            "Person occupation should be 2 alphanumeric strings separated by ','"
                    + " in the form of [COMPANY NAME] , [JOB TITLE]";
    public static final String OCCUPATION_VALIDATION_REGEX = "[\\w\\s]+\\,\\s[\\w\\s]+";

    public final String value;

    /**
     * Validates given occupation.
     *
     * @throws IllegalValueException if given occupation string is invalid.
     */
    public Occupation(String occupation) throws IllegalValueException {
        //requireNonNull(occupation);
        if (occupation == null) {
            this.value = "";
        } else {
            String trimmedOccupation = occupation.trim();
            if (trimmedOccupation.length() > 0 && !isValidOccupation(trimmedOccupation)) {
                throw new IllegalValueException(MESSAGE_OCCUPATION_CONSTRAINTS);
            }
            this.value = trimmedOccupation;
        }
    }

    /**
     * Returns if a given string is a valid person occupation.
     */
    public static boolean isValidOccupation(String test) {
        return test.matches(OCCUPATION_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Occupation // instanceof handles nulls
                && this.value.equals(((Occupation) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

}
```
###### \java\seedu\address\model\person\Person.java
``` java
    public void setOccupation(Occupation occupation) {
        this.occupation.set(requireNonNull(occupation));
    }

    @Override
    public ObjectProperty<Occupation> occupationProperty() {
        return occupation;
    }

    @Override
    public Occupation getOccupation() {
        return occupation.get();
    }
```
###### \java\seedu\address\model\person\Person.java
``` java
    public void setWebsite(Website website) {
        this.website.set(requireNonNull(website));
    }

    @Override
    public ObjectProperty<Website> websiteProperty() {
        return website;
    }

    @Override
    public Website getWebsite() {
        return website.get();
    }
```
###### \java\seedu\address\model\person\Remark.java
``` java
/**
 *  Represents a Person's remark in the address book.
 *  Guarantees: immutable; is always valid
 */
public class Remark {

    public static final String MESSAGE_REMARK_CONSTRAINTS = "Person remarks can take any values, can even be blank";

    public final String value;

    public Remark(String remark) {
        requireNonNull(remark);
        this.value = remark;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit
            || (other instanceof Remark //instance of nulls
                && this.value.equals(((Remark) other).value)); //state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
```
###### \java\seedu\address\model\person\Website.java
``` java
/**
 * Represents a Person's website in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidWebsite(String)}
 */
public class Website {

    public static final String MESSAGE_WEBSITE_CONSTRAINTS =
            "Person's website should end one or more top-level domain and include no special characters.";

    public final String value;

    /**
     * Validates given website.
     *
     * @throws IllegalValueException if given website string is invalid.
     */
    public Website(String website) throws IllegalValueException {
        //requireNonNull(website);
        if (website == null) {
            this.value = "";
        } else {
            String trimmedWebsite = website.trim();
            if (trimmedWebsite.length() > 0 && !isValidWebsite(trimmedWebsite)) {
                throw new IllegalValueException(MESSAGE_WEBSITE_CONSTRAINTS);
            }
            this.value = trimmedWebsite;
        }
    }

    /**
     * Returns if a given string is a valid person email.
     */
    public static boolean isValidWebsite(String test) {
        Pattern p = Pattern.compile("(@)?(href=')?(HREF=')?(HREF=\")?(href=\")?(https://)?[a-zA-Z_0-9\\-]+"
                + "(\\.\\w[a-zA-Z_0-9\\-]+)+(/[#&\\n\\-=?\\+\\%/\\.\\w]+)?");

        Matcher m = p.matcher(test);
        return m.matches();
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Website // instanceof handles nulls
                && this.value.equals(((Website) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
```
