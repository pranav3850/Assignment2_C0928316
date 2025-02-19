package test;

import Java2.Person;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {

    @Test
    void testValidPersonCreation() {
        Person person = Person.builder()
                .id("1")
                .firstName("John")
                .lastName("Doe")
                .age(30)
                .gender("Male")
                .build();

        assertNotNull(person);
        assertEquals("John", person.getFirstName());
    }

    @Test
    void testPersonWithNullIdThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                Person.builder().id(null).firstName("John").lastName("Doe").age(25).gender("Male").build()
        );
        assertEquals("ID cannot be null", exception.getMessage());
    }

    @Test
    void testPersonWithNegativeAgeThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                Person.builder().id("1").firstName("John").lastName("Doe").age(-5).gender("Male").build()
        );
        assertEquals("Age cannot be negative", exception.getMessage());
    }
}