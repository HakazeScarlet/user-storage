package services;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

class EncryptorTest {

    @Test
    void testEncryptPassword() {
        String password = "password1234";
        byte[] encryptedPassword = Encryptor.encryptPassword(password.getBytes());
        assertNotEquals(password.getBytes(), encryptedPassword);
    }
}