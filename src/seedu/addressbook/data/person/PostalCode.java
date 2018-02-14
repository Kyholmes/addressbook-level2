package seedu.addressbook.data.person;

import javafx.geometry.Pos;

public class PostalCode {
    public static final String EXAMPLE = "634972";
    public final String postalCode;

    /**
     * Construct postal code object with empty block value
     */
    public PostalCode(){
        this.postalCode = "";
    }

    /**
     * Construct postal code object with value given.
     *
     */
    public PostalCode(String postalCode){

        this.postalCode = postalCode;
    }


    @Override
    public String toString() {
        return this.postalCode;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof PostalCode // instanceof handles nulls
                && this.postalCode.equals(((PostalCode) other).postalCode));// state check
    }

    @Override
    public int hashCode() {
        return this.postalCode.hashCode();
    }
}
