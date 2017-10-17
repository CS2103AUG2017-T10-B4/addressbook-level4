package seedu.address.model.person;

import static java.util.Objects.requireNonNull;

/**
 *  Represents a Person's remark in the address book.
 *  Guarantees: immutable; is always valid
 */
public class Remark {

    public static final String MESSAGE_REMARK_CONSTRAINTS = "Person remakrs can take any values, can even be blank";

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