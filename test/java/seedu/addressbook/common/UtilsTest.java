package seedu.addressbook.common;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import javax.rmi.CORBA.Util;

public class UtilsTest {

    @Test
    public void isAnyNull() throws Exception {
        //only one not null object
        assertIsNotNull(1);
        assertIsNotNull("");
        assertIsNotNull("abc");

        //multiple not null objects
        assertIsNotNull(123, "abc", "34gnsd");
        assertIsNotNull("abded", 123456);

        //multiple objects, some contain null
        assertIsNull(null, 123, "adfje");
        assertIsNull("sdga", null, 2134);
        assertIsNull(1234, "mary", null);
        assertIsNull(1235, null);

        //all null objects
        assertIsNull(null, null);
        assertIsNull(null, null, null);
    }

    @Test
    public void elementsAreUnique() throws Exception {
        // empty list
        assertAreUnique();

        // only one object
        assertAreUnique((Object) null);
        assertAreUnique(1);
        assertAreUnique("");
        assertAreUnique("abc");

        // all objects unique
        assertAreUnique("abc", "ab", "a");
        assertAreUnique(1, 2);

        // some identical objects
        assertNotUnique("abc", "abc");
        assertNotUnique("abc", "", "abc", "ABC");
        assertNotUnique("", "abc", "a", "abc");
        assertNotUnique(1, new Integer(1));
        assertNotUnique(null, 1, new Integer(1));
        assertNotUnique(null, null);
        assertNotUnique(null, "a", "b", null);
    }

    private void assertAreUnique(Object... objects) {
        assertTrue(Utils.elementsAreUnique(Arrays.asList(objects)));
    }

    private void assertNotUnique(Object... objects) {
        assertFalse(Utils.elementsAreUnique(Arrays.asList(objects)));
    }

    private void assertIsNull(Object... objects){
        assertTrue(Utils.isAnyNull(objects));
    }

    private void assertIsNotNull(Object... objects){
        assertFalse(Utils.isAnyNull(objects));
    }
}
