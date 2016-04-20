package com.greenowl.model;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by acube on 20.04.2016.
 */
public class SimpleHashPass {

    public String password;

    public SimpleHashPass(String pass) {
        this.password = pass;
    }

    public String HashPass() {
        String hashPass = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(this.password.getBytes());
            byte byteData[] = md.digest();

            StringBuilder hexString = new StringBuilder();
            for (byte aByteData : byteData) {
                hexString.append(Integer.toString((aByteData & 0xff) + 0x100, 16).substring(1));
            }
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return hashPass;
    }

    public boolean IsEqualsPass(String passwordFromDb) {
        return (passwordFromDb != null && this.password != null && this.password.equals(passwordFromDb));
    }

}
