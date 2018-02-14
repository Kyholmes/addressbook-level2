package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

public class Block {
    public static final String EXAMPLE = "123";
    public static final String MESSAGE_BLOCK_CONSTRAINTS = "Block should be integer";
    public static final String NAME_VALIDATION_REGEX = "^[1-9]\\d{1,4}";
    public final int block;

    /**
     * Validates given block.
     *
     * @throws IllegalValueException if given name string is invalid.
     */
    public Block(String block) throws IllegalValueException {

        if (!isValidBlock(block)) {
            throw new IllegalValueException(MESSAGE_BLOCK_CONSTRAINTS);
        }
        this.block = Integer.parseInt(block);
    }

    /**
     * Returns true if the given block is a valid integer.
     */
    public static boolean isValidBlock(String test) {
        return test.matches(NAME_VALIDATION_REGEX);
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
