package seedu.addressbook.data.person;

public class Unit {
    public static final String EXAMPLE = "123";
    public final int unit;

    /**
     * Construct unit object with empty block value
     */
    public Unit(){
        this.unit = 0;
    }

    /**
     * Construct unit object with value given.
     *
     */
    public Unit(String unit){

        this.unit = Integer.parseInt(unit);
    }


    @Override
    public String toString() {
        return String.valueOf(this.unit);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Unit // instanceof handles nulls
                && this.unit == ((Unit) other).unit );// state check
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(this.unit);
    }
}
