package services;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

public class Encryptor {

    // TODO: add coding (UTF_8)
    // TODO: change byte[] parameter to String parameter
    public static byte[] encryptPassword(byte[] password) {
        try {
            // TODO: check hashing, add hashing if it is won't
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
//            keyGenerator.init(256, SecureRandom.getInstance("SHA")); // SHA, MD5 hashing algorithms
            keyGenerator.init(256); // TODO: extract number to constant
            Key key = keyGenerator.generateKey();

            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            return cipher.doFinal(password);
        } catch (NoSuchAlgorithmException e) {
            throw new AvailableAlgorithmException("Cryptographic algorithm is not available in the environment");
        } catch (NoSuchPaddingException e) {
            throw new AvailablePaddingException("Padding algorithm is not available in the environment");
        } catch (IllegalBlockSizeException e) {
            throw new CipherBlockSizeException("The length of the data provided for the block cipher is incorrect");
        } catch (BadPaddingException e) {
            throw new CipherPaddingException("Failed to encrypt data");
        } catch (InvalidKeyException e) {
            throw new CipherInitializeException("The provided key is not suitable for initializing the cipher");
        }
    }

    private static final class AvailableAlgorithmException extends RuntimeException {

        public AvailableAlgorithmException(String message) {
            super(message);
        }
    }

    private static final class AvailablePaddingException extends RuntimeException {

        public AvailablePaddingException(String message) {
            super(message);
        }
    }

    private static final class CipherPaddingException extends RuntimeException {

        public CipherPaddingException(String message) {
            super(message);
        }
    }

    private static final class CipherBlockSizeException extends RuntimeException {

        public CipherBlockSizeException(String message) {
            super(message);
        }
    }

    private static final class CipherInitializeException extends RuntimeException {

        public CipherInitializeException(String message) {
            super(message);
        }
    }
}
