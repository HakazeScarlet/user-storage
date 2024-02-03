package services;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class Encryptor {

    public byte[] encryptPassword(byte[] password, byte[] keyBytes) {
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            SecretKey secretKey = new SecretKeySpec(keyBytes, "AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
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
