package seedu.addressbook.data.tag;

import seedu.addressbook.data.person.Person;

/**
 * Store adding or deleting a tag for a specific person that happened during that session.
 */
public class Tagging {

    private String personName;
    private String tagName;
    private String methodType;

    public Tagging(String personName, String tagName, String methodType) {
        this.personName = personName;
        this.tagName = tagName;
        this.methodType = methodType;
    }

    public String getPersonName() {
        return this.personName;
    }

    public String getTagName() {
        return this.tagName;
    }

    public String getMethodType() {
        return methodType;
    }
}