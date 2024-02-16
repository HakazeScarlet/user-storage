package encryptor;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EncryptorTest {

    @Test
    void whenEncryptionPasswordsSame_returnTrue() {
        String password = "password1234";

        EncryptionService encryptorService = new EncryptionService();

        String actual1 = encryptorService.encrypt(password);
        String actual2 = encryptorService.encrypt(password);

        assertEquals(actual1, actual2);
    }

    // TODO: add test which for empty password (testException)
    // TODO: add test which for null password (testException)
}