package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

public class Contact {

    public static String EXAMPLE = "";
    public static String MESSAGE_VALUE_CONSTRAINTS = "";
    public static String VALUE_VALIDATION_REGEX = "";

    public final String value;
    private boolean isPrivate;

    /**
     * Validates given contact value.
     *
     * @throws IllegalValueException if given contact string is invalid.
     */
    public Contact(String value, boolean isPrivate, String example, String messageValueConstraints, String valueValidationRegex) throws IllegalValueException {
        this.isPrivate = isPrivate;
        this.EXAMPLE = example;
        this.MESSAGE_VALUE_CONSTRAINTS = messageValueConstraints;
        this.VALUE_VALIDATION_REGEX = valueValidationRegex;
        String trimmedValue = value.trim();
        if (!isValidEmail(trimmedValue)) {
            throw new IllegalValueException(MESSAGE_VALUE_CONSTRAINTS);
        }
        this.value = trimmedValue;
    }

    /**
     * Returns true if the given string is a valid contact value.
     */
    public static boolean isValidEmail(String test) {
        return test.matches(VALUE_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Contact // instanceof handles nulls
                && this.value.equals(((Contact) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }


    public boolean isPrivate() {
        return isPrivate;
    }
}
