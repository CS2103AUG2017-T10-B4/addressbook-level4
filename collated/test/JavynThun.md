# JavynThun
###### \java\guitests\guihandles\PersonCardHandle.java
``` java
    public String getOccupation() {
        return occupationLabel.getText();
    }
```
###### \java\guitests\guihandles\PersonCardHandle.java
``` java
    public String getWebsite() {
        return websiteLabel.getText();
    }
```
###### \java\seedu\address\logic\commands\AddCommandTest.java
``` java
        @Override
        public Boolean sortPersonList(ArrayList<ReadOnlyPerson> personlist) {
            fail("This method should not be called.");
            return null;
        }
```
###### \java\seedu\address\logic\commands\AddMultipleByTsvCommandTest.java
``` java
        @Override
        public Boolean sortPersonList(ArrayList<ReadOnlyPerson> personList) {
            fail("This method should not be called.");
            return null;
        }
```
###### \java\seedu\address\logic\parser\ParserUtilTest.java
``` java
    @Test
    public void parseOccupation_null_throwsNullPointerException() throws Exception {
        thrown.expect(NullPointerException.class);
        ParserUtil.parseOccupation(null);
    }

    @Test
    public void parseOccupation_invalidValue_throwsIllegalValueException() throws Exception {
        thrown.expect(IllegalValueException.class);
        ParserUtil.parseOccupation(Optional.of(INVALID_OCCUPATION));
    }

    @Test
    public void parseOccupation_optionalEmpty_returnsOptionalEmpty() throws Exception {
        assertFalse(ParserUtil.parseOccupation(Optional.empty()).isPresent());
    }

    @Test
    public void parseOccupation_validValue_returnsOccupation() throws Exception {
        Occupation expectedOccupation = new Occupation(VALID_OCCUPATION);
        Optional<Occupation> actualOccupation = ParserUtil.parseOccupation(Optional.of(VALID_OCCUPATION));
        assertEquals(expectedOccupation, actualOccupation.get());
    }
```
###### \java\seedu\address\logic\parser\ParserUtilTest.java
``` java
    @Test
    public void parseWebsite_null_throwsNullPointerException() throws Exception {
        thrown.expect(NullPointerException.class);
        ParserUtil.parseWebsite(null);
    }

    @Test
    public void parseWebsite_invalidValue_throwsIllegalValueException() throws Exception {
        thrown.expect(IllegalValueException.class);
        ParserUtil.parseWebsite(Optional.of(INVALID_WEBSITE));
    }

    @Test
    public void parseWebsite_optionalEmpty_returnsOptionalEmpty() throws Exception {
        assertFalse(ParserUtil.parseWebsite(Optional.empty()).isPresent());
    }

    @Test
    public void parseWebsite_validValue_returnsWebsite() throws Exception {
        Website expectedWebsite = new Website(VALID_WEBSITE);
        Optional<Website> actualWebsite = ParserUtil.parseWebsite(Optional.of(VALID_WEBSITE));

        assertEquals(expectedWebsite, actualWebsite.get());
    }
```
###### \java\seedu\address\model\person\OccupationTest.java
``` java
public class OccupationTest {

    @Test
    public void isValidOccupation() {
        // blank email
        assertFalse(Occupation.isValidOccupation("")); // empty string
        assertFalse(Occupation.isValidOccupation(" ")); // spaces only

        // invalid email
        assertFalse(Occupation.isValidOccupation("@pple, CEO")); // special character in the middle of two strings

        // missing parts
        assertFalse(Occupation.isValidOccupation("Google,Software Engineer")); // missing ' ' after ','
        assertFalse(Occupation.isValidOccupation("Microsoft CEO")); // missing ',' in the middle of two strings
        assertFalse(Occupation.isValidOccupation("Apple")); // missing second part (position)
        assertFalse(Occupation.isValidOccupation("Software Engineer")); // missing first part (company name)

        // valid email
        assertTrue(Occupation.isValidOccupation("Tan Tock Seng Hospital, Nurse"));
        assertTrue(Occupation.isValidOccupation("SMRT, Bus Driver"));
        assertTrue(Occupation.isValidOccupation("NUS, Student"));
    }


}
```
###### \java\seedu\address\model\person\WebsiteTest.java
``` java
public class WebsiteTest {

    @Test
    public void isValidWebsite() {
        // blank email
        assertFalse(Website.isValidWebsite("")); // empty string
        assertFalse(Website.isValidWebsite(" ")); // spaces only

        // invalid email
        assertFalse(Website.isValidWebsite("https://example@example.com")); // special character in the middle

        // missing parts
        assertFalse(Website.isValidWebsite("https://example")); // missing top-level domain
        assertFalse(Website.isValidWebsite("http://example.com")); // missing 's' after http
        assertFalse(Website.isValidWebsite("https://.com")); // missing domain name
        assertFalse(Website.isValidWebsite("https//example.com")); // missing ':' after https

        // valid email
        assertTrue(Website.isValidWebsite("https://example.com"));
        assertTrue(Website.isValidWebsite("https://example.com.net"));  // multiple top-level domains
        assertTrue(Website.isValidWebsite("pexample.com"));
        assertTrue(Website.isValidWebsite("https://example.org"));
        assertTrue(Website.isValidWebsite("https://www.example.com"));
        assertTrue(Website.isValidWebsite("https://example.com/abcd"));
    }


}
```
###### \java\seedu\address\testutil\EditPersonDescriptorBuilder.java
``` java
    /**
     * Sets the {@code Website} of the {@code EditPersonDescriptor} that we are building.
     */
    public EditPersonDescriptorBuilder withWebsite(String website) {
        try {
            ParserUtil.parseWebsite(Optional.of(website)).ifPresent(descriptor::setWebsite);
        } catch (IllegalValueException ive) {
            throw new IllegalArgumentException("website is expected to be unique.");
        }
        return this;
    }
```
###### \java\seedu\address\testutil\PersonBuilder.java
``` java
    /**
     * Sets the {@code Occupation} of the {@code Person} that we are building.
     */
    public PersonBuilder withOccupation(String occupation) {
        try {
            this.person.setOccupation(new Occupation(occupation));
        } catch (IllegalValueException ive) {
            throw new IllegalArgumentException("occupation is expected to be unique.");
        }
        return this;
    }
```
###### \java\seedu\address\testutil\PersonBuilder.java
``` java
    /**
     *  Sets the {@code Website} of the {@code Person} that we are building.
     */
    public PersonBuilder withWebsite(String website) {
        try {
            this.person.setWebsite(new Website(website));
        } catch (IllegalValueException ive) {
            throw new IllegalArgumentException("website is expected to be unique");
        }
        return this;
    }
```
