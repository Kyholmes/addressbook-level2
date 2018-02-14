package seedu.addressbook.data.person;

public class Street {

    public static final String EXAMPLE = "Clementi Ave 3";
    public final String street;

    /**
     * Construct Street obj with empty value
     */
    public Street(){
        this.street = "";
    }

    /**
     * Construct Street obj with value given.
     *
     */
    public Street(String street){

        this.street = street;
    }


    @Override
    public String toString() {
        return this.street;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Street // instanceof handles nulls
                && this.street.equals(((Street) other).street)); // state check
    }

    @Override
    public int hashCode() {
        return street.hashCode();
    }
}
