package services;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

public class Encryptor {

    private static final Charset CHARSET_UTF_8 = StandardCharsets.UTF_8;
    private static final String TRANSFORMATION = "AES/CBC/PKCS5Padding";
    private static final String HASHING_ALGORITHM = "PBKDF2WithHmacSHA256";
    private static final String CIPHER_ALGORITHM = "AES";
    private static final int KEY_LENGTH = 32;

    public static String encrypt(String password) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(HASHING_ALGORITHM);
            byte[] hash = messageDigest.digest(password.getBytes(CHARSET_UTF_8));
            byte[] key = Arrays.copyOf(hash, KEY_LENGTH);
            SecretKeySpec secretKeySpec = new SecretKeySpec(key, CIPHER_ALGORITHM);

//            SecretKeyFactory factory = SecretKeyFactory.getInstance(HASHING_ALGORITHM);
//            String salt = "RAW";
//            int passwordIterations = 65536;
//            int keyLength = 256;
//            KeySpec spec = new PBEKeySpec(password.toCharArray(), salt.getBytes(), passwordIterations, keyLength);
//            SecretKey key = new SecretKeySpec(factory.generateSecret(spec).getEncoded(), CIPHER_ALGORITHM);

            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
            byte[] encryptedPassword = cipher.doFinal(password.getBytes(CHARSET_UTF_8));
            return Base64.getEncoder().encodeToString(encryptedPassword);
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
