package seedu.addressbook.data.tag;

import seedu.addressbook.data.person.Person;

/**
 * Store adding or deleting a tag for a specific person that happened during that session.
 */
public class Tagging {

    private Person person;
    private Tag tag;
    private String methodType;

    public Tagging(Person person, Tag tag, String methodType) {
        this.person = person;
        this.tag = tag;
        this.methodType = methodType;
    }

    public Person getPerson() {
        return this.person;
    }

    public Tag getTag() {
        return this.tag;
    }

    public String getMethodType() {
        return methodType;
    }
}