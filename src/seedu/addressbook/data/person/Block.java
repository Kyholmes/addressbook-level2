package seedu.addressbook.data.person;


public class Block {
    public static final String EXAMPLE = "123";
    public final int block;

    /**
     * Construct block object with empty block value
     */
    public Block(){
        this.block = 0;
    }

    /**
     * Construct block object with value given.
     *
     */
    public Block(String block){

        this.block = Integer.parseInt(block);
    }


    @Override
    public String toString() {
        return String.valueOf(this.block);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Block // instanceof handles nulls
                && this.block == ((Block) other).block );// state check
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(this.block);
    }
}
