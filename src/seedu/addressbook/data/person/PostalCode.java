package seedu.addressbook.data.person;

import javafx.beans.property.IntegerProperty;
import javafx.geometry.Pos;

public class PostalCode {
    public static final String EXAMPLE = "634972";
    public final int postalCode;

    /**
     * Construct postal code object with empty block value
     */
    public PostalCode(){
        this.postalCode = 0;
    }

    /**
     * Construct postal code object with value given.
     *
     */
    public PostalCode(int postalCode){

        this.postalCode = postalCode;
    }


    @Override
    public String toString() {
        return String.valueOf(postalCode);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof PostalCode // instanceof handles nulls
                && this.postalCode == (Integer) ((PostalCode) other).postalCode);// state check
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(this.postalCode);
    }
}
