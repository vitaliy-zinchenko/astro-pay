package test;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.Md5Crypt;
import org.springframework.util.DigestUtils;
import sun.misc.BASE64Encoder;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Vitaliy on 11/28/2015.
 */
public class Main {
    public static void main1(String[] args) throws GeneralSecurityException, UnsupportedEncodingException {
//        org.apache.commons.codec.digest.DigestUtils.getMd5Digest().
        String s = "test_test_test1;www.test.test.test;DH783025;1415379863;1;UAH;webinar;1;1";
       String s2 = "test_test_test1;www.test.test.test;5659df189518b6b3839ca29d;1448730392453;1.0;UAH;webinar;1;1.0";
//        String s = "test_merchant;www.market.ua;DH783023;1415379863;1547.36;UAH;Процессор Intel Core i5-4670 3.4GHz;Память Kingston DDR3-1600 4096MB PC3-12800;1;1;1000;547.36";
        String key = "7c6d103e1f848ff5939169215298cacd641cdfd9";
//        String key = "dhkq3vUi94{Z!5frxs(02ML";

        //$secret_key = 'foo';
        //$sig_str = 'bar';
        //$hash = hash_hmac('md5', $sig_str, $secret_key);

        SecretKeySpec keySpec = new SecretKeySpec(s.getBytes(), "HmacMD5");
        Mac mac = Mac.getInstance(keySpec.getAlgorithm());
        mac.init(keySpec);
        String result = new BASE64Encoder().encode(mac.doFinal(key.getBytes()));

        result = computeSignature(s, key);

        System.out.println(result);
    }

    private static String computeSignature(String baseString, String keyString) throws GeneralSecurityException, UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException {

        SecretKey secretKey = null;

        byte[] keyBytes = keyString.getBytes("UTF-8");
        secretKey = new SecretKeySpec(keyBytes, "HmacMD5");

        Mac mac = Mac.getInstance("HmacMD5");

        mac.init(secretKey);

        byte[] text = baseString.getBytes("UTF-8");

        return new String(Hex.encodeHex(mac.doFinal(text))).trim();
    }
}
