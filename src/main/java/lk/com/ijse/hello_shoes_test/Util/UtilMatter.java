package lk.com.ijse.hello_shoes_test.Util;

import java.util.Base64;

public class UtilMatter {
    public static String convertBase64(String data) {
        return Base64.getEncoder().encodeToString(data.getBytes());
    }
}
