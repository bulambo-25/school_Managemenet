/*
 * @Author Reanetsi Sholoko
 * @Student number: 218160402*/
package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Name;

import static org.junit.jupiter.api.Assertions.*;

class NameFactoryTest {

    @Test
    void createNameSuccess() throws IllegalArgumentException {
        Name name = NameFactory.createName("Yellow", " ", "Bone");
        assertNotNull(name);
        assertEquals("Yellow", name.getFirstName());
        System.out.println(name);
    }

    @Test
    void createNameFail() {
        assertThrows(IllegalArgumentException.class, ()->{
            NameFactory.createName(" ", "Sweet", "Bone");
        });
        System.out.println("Thrown an error as expected");
    }
}
