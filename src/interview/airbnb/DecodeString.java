package interview.airbnb;

/**
 * Created by tyh on 2017/9/12.
 */
public class DecodeString {
    /*
    Often, we want to encode raw IDs in our database by hiding them behind some

2-way decodeable hash. So, a URL which would have at one time been:

https://www.airbnb.com/rooms/848662
becomes
https://www.airbnb.com/rooms/kljJJ324hjkS_

We decode the ID kljJJ324hjkS_ to 848662 on our backend and serve the
 relevant content. at some point, we start getting 404 errors from clients
 requesting a certain URL of the form

https://www.airbnb.com/rooms/kljjj324hjks_

This can happen if certain clients, email services, or url shorteners "
 sanitize" the url. Unfortunately, this change breaks decoding and the
 resource cannot be found.
 To assess how big of a deal this is, we may want to recover the IDs of the
 targets that were 404ing.

Your task:
 Given a method decode(testEncStr) which will return the decoded int id if
 testEncStr is decodeable or will throw an exception or return null (
 depending on the language) if not, implement a new method decodeFind(String
 badEncStr) which takes a string and returns the decoded int id.
     */

    public static void main(String[] args) {
        String badEncStr = "kLjjj324hijks_";
        Integer result = decodeFind(badEncStr);

        System.out.println(result);
    }

    public static Integer decodeFind(String badEncString) {
        if (badEncString == null || badEncString.length() == 0) {
            return -1;
        }

        StringBuffer sb = new StringBuffer();

        return decodeFindHelper(0, sb, badEncString);
    }

    private static Integer decodeFindHelper(int start, StringBuffer curr, String badEncString) {
        if (start == badEncString.length()) {
            String testEncStr = curr.toString();
            Integer result = decode(testEncStr);

            if (result != null) {
                return result;
            } else {
                return null;
            }
        }

        char c = badEncString.charAt(start);
        if (!Character.isLetter(c)) {
            curr.append(c);
            Integer result = decodeFindHelper(start + 1, curr, badEncString);
            if (result != null) {
                return result;
            }
            curr.deleteCharAt(curr.length() - 1);
        } else {
            // To lower case
            char lower = Character.toLowerCase(c);
            curr.append(lower);
            Integer result = decodeFindHelper(start + 1, curr, badEncString);
            if (result != null) {
                return result;
            }
            curr.deleteCharAt(curr.length() - 1);

            // To upper case
            char upper = Character.toUpperCase(c);
            curr.append(upper);
            result = decodeFindHelper(start + 1, curr, badEncString);
            if (result != null) {
                return result;
            }
            curr.deleteCharAt(curr.length() - 1);
        }

        return null;
    }

    public static Integer decode(String testEncStr) {
        String truth = "kljJJ324hijkS_";

        if (testEncStr.equals(truth)) {
            return 848662;
        } else {
            return null;
        }
    }
}
