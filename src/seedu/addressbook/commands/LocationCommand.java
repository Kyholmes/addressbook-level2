package seedu.addressbook.commands;


import javafx.beans.property.StringProperty;
import seedu.addressbook.data.person.PostalCode;
import seedu.addressbook.data.person.ReadOnlyPerson;

import java.util.ArrayList;
import java.util.List;

/**
 * Finds and lists all persons in address book who live in the same location.
 * Keyword matching is postal code.
 */
public class LocationCommand extends Command{
    public static final String COMMAND_WORD = "location";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Finds all persons who live in "
            + "the specified postal code and displays them as a list with index numbers.\n"
            + "Parameters: POSTAL_CODE\n"
            + "Example: " + COMMAND_WORD + " 847596";

    private final String postalCode;

    public LocationCommand(String postalCode) {
        this.postalCode = postalCode;
    }

    @Override
    public CommandResult execute() {
        final List<ReadOnlyPerson> personFound = getPersonWhoLiveAt(postalCode);
        return new CommandResult(getMessageForPersonListShownSummary(personFound), personFound);
    }

    /**
     * Retrieves all persons in the address book who live in the area specified by postal code.
     *
     * @param postalCode for searching
     * @return list of persons found
     */
    private List<ReadOnlyPerson> getPersonWhoLiveAt(String postalCode) {
        final List<ReadOnlyPerson> matchedPersons = new ArrayList<>();
        PostalCode specifiedPostalCode = new PostalCode(Integer.parseInt(postalCode.trim()));
        for (ReadOnlyPerson person : addressBook.getAllPersons()) {
            if(specifiedPostalCode.equals(person.getAddress().postalCode)) {
                matchedPersons.add(person);
            }
        }
        return matchedPersons;
    }
}
