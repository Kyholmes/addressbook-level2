package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

import java.util.Objects;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "123, Clementi Ave 3, #12-34, 231534";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses should be in BLOCK, STREET, UNIT, POSTAL_CODE";
    public static final String ADDRESS_VALIDATION_REGEX = "^[1-9]\\d{1,4}\\,[A-Za-z0-9.]*\\,\\#\\d{1,2}\\-\\d{1,3}\\,\\d{6}$";

    public Block block;
    public Street street;
    public Unit unit;
    public PostalCode postalCode;

    private boolean isPrivate;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        String trimmedAddress = address.trim();

        trimmedAddress = trimmedAddress.replaceAll("\\s+", "");

        this.isPrivate = isPrivate;
        if (!isValidAddress(trimmedAddress)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }

        getAddressDetail(address);
    }

    /**
     * split address string to get address block, street, unit, postal code
     */
    public void getAddressDetail(String address)
    {
        String[] addressComponent = address.split("\\,");

        this.block = new Block(addressComponent[0]);

        this.street = new Street(addressComponent[1]);

        this.unit = new Unit(addressComponent[2]);

        this.postalCode = new PostalCode(addressComponent[3]);
    }

    /**
     * Returns true if a given string is a valid person address.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return String.format( "%1$s,%2$s,%3$s,%4$s", this.block.toString(), this.street.toString(), this.unit.toString(), this.postalCode.toString() );
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.block.equals(((Address) other).block)
                && this.street.equals(((Address) other).street)
                && this.unit.equals(((Address) other).unit)
                && this.postalCode.equals(((Address) other).postalCode)); // state check
    }

    @Override
    public int hashCode() {
        return Objects.hash(block, street, unit, postalCode);
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}
