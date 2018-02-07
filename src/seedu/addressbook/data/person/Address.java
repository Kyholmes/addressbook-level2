package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

//    public static final String EXAMPLE = "123, Clementi Ave 3, #12-34, 231534";
//    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses can be in any format";
    //public static final String ADDRESS_VALIDATION_REGEX = ".+";

    //modify
    public static final String EXAMPLE = "123, Clementi Ave 3, #12-34, 231534";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses should be in BLOCK, STREET, UNIT, POSTAL_CODE";
    public static final String ADDRESS_VALIDATION_REGEX = "^\\d{1,4}\\,[A-Za-z0-9.]*\\,\\#\\d{1,2}\\-\\d{1,3}\\,\\d{6}$";    //modify

    public final String value;
    private boolean isPrivate;

    //modification: block, street, unit, postal code
    int block;
    String street;
    String unit;
    int postalCode;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        String trimmedAddress = address.trim();

        //modify
        trimmedAddress = trimmedAddress.replaceAll(" ", "");

        this.isPrivate = isPrivate;
        if (!isValidAddress(trimmedAddress)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        this.value = trimmedAddress;

        //modify
        String[] addressDetailString = getDetailFromAddress(this.value);
        setBlock(addressDetailString[0]);
        setStreet(addressDetailString[1]);
        setUnit(addressDetailString[2]);
        setPostalCode(addressDetailString[3]);
    }

    /**
     * Returns true if a given string is a valid person address.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.value.equals(((Address) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    //modify
    public static String[] getDetailFromAddress(String addressString)
    {
        String[] addressDetail = addressString.split(",");
        return addressDetail;
    }

    public void setBlock(String block)
    {
        this.block = Integer.parseInt(block);
    }

    public void setBlock(int block)
    {
        this.block = block;
    }

    public void setStreet(String street)
    {
        this.street = street;
    }

    public void setUnit(String unit)
    {
        this.unit = unit;
    }

    public void setPostalCode(String postalCode)
    {
        this.postalCode = Integer.parseInt(postalCode);
    }

    public void setPostalCode(int postalCode)
    {
        this.postalCode = postalCode;
    }
}
