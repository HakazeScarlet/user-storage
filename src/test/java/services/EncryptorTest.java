package services;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EncryptorTest {


    // TODO: rename test by convention
    @Test
    void testEncryptPassword() {
        String password = "password1234";

        String actual1 = Encryptor.encrypt(password);
        String actual2 = Encryptor.encrypt(password);

        assertEquals(actual1, actual2);
    }

    // TODO: add test which for empty password (testException)
    // TODO: add test which for null password (testException)
}