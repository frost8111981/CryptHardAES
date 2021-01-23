package com.company;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Crypt {
    String input;

    Crypt(String input) {
        this.input = input;
    }

    public static String decrypt(String input) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        Scanner scan = new Scanner(System.in);
        input = scan.nextLine();
        Cipher cipher = Cipher.getInstance("AES");

        SecretKeySpec key = new SecretKeySpec("Bar12345Bar12345".getBytes(), "AES");
        cipher.init(Cipher.ENCRYPT_MODE, key);

        byte[] bytes = cipher.doFinal(input.getBytes());
        for (byte b : bytes) {
            System.out.print(b);
        }
        System.out.print("\n");
        return input;
    }

    public static String encrypt(String input) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        Cipher decryptCipher = Cipher.getInstance("AES");
        SecretKeySpec key = new SecretKeySpec("Bar12345Bar12345".getBytes(), "AES");

        byte[] bytes = decryptCipher.doFinal(input.getBytes());
        decryptCipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decryptedBytes = decryptCipher.doFinal(bytes);
        for (byte b : decryptedBytes) {
            System.out.print((char) b);

        }
        return input;
    }
}
