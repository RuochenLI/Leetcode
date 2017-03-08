import java.util.HashMap;
import java.util.Map;

/**
 * TinyURL is a URL shortening service where you enter a URL such as https://leetcode.com/problems/design-tinyurl and it returns a short URL such as http://tinyurl.com/4e9iAk.

 Design the encode and decode methods for the TinyURL service. There is no restriction on how your encode/decode algorithm should work. You just need to ensure that a URL can be encoded to a tiny URL and the tiny URL can be decoded to the original URL.
 *
 * Created by Ruochen on 08/03/2017.
 */
public class EncodeAndDecodeTinyURL {

    private Map<String, String> urlMap = new HashMap();;
    private int index = -1;

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        index++;
        String indexStr = String.valueOf(index);
        urlMap.put(indexStr, longUrl);
        return indexStr;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return urlMap.get(shortUrl);
    }
}
