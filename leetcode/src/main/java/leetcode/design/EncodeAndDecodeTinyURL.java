package leetcode.design;

import com.sun.deploy.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class EncodeAndDecodeTinyURL {

    Map<String, String> map = new HashMap<>();

    long index = 10000;
    private static String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static int scale = 62;

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {

        String tinyUrl = indexToStr(index, 7);
        map.put(tinyUrl, longUrl);
        return tinyUrl;
    }

    public String indexToStr(long num, int length) {
        StringBuilder sb = new StringBuilder();
        int remainder = 0;

        while (num > scale - 1) {
            /**
             * 对 scale 进行求余，然后将余数追加至 sb 中，由于是从末位开始追加的，因此最后需要反转（reverse）字符串
             */
            remainder = Long.valueOf(num % scale).intValue();
            sb.append(chars.charAt(remainder));

            num = num / scale;
        }

        sb.append(chars.charAt(Long.valueOf(num).intValue()));
        String value = sb.reverse().toString();

        while (value.length() < length) {
            value = "0" + value;
        }
        return value;


    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(shortUrl);
    }




    public static void main(String[] args) {
        EncodeAndDecodeTinyURL codec = new EncodeAndDecodeTinyURL();
        codec.decode(codec.encode("https://leetcode.com/problems/design-tinyurl"));
    }


    public String bytesToHexString(byte[] bArr) {
        StringBuffer sb = new StringBuffer(bArr.length);
        String sTmp;

        for (int i = 0; i < bArr.length; i++) {
            sTmp = Integer.toHexString(0xFF & bArr[i]);
            if (sTmp.length() < 2)
                sb.append(0);
            sb.append(sTmp.toUpperCase());
        }

        return sb.toString();
    }

}
// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
