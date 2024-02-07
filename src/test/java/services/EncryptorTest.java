package services;

import org.junit.jupiter.api.Test;

import java.util.Base64;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EncryptorTest {


    // TODO: rename test by convention
    @Test
    void testEncryptPassword() {
        String password = "password1234";

        byte[] encryptedPassword1 = Encryptor.encryptPassword(password.getBytes());
        byte[] encryptedPassword2 = Encryptor.encryptPassword(password.getBytes());
        String actual1 = Base64.getEncoder().encodeToString(encryptedPassword1);
        String actual2 = Base64.getEncoder().encodeToString(encryptedPassword2);

        assertEquals(actual1, actual2);
    }

    // TODO: add test which for empty password (testException)
    // TODO: add test which for null password (testException)
}