package zhc.algorithm;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring(new String("pwwkew")));

        String  pattern="^(.+?)(\\[.+?\\])(.+?)$";
        String line = "This order ˈfɑː.ðər wa /ˈfɑː.ðɚ/s placed for QT3000! OK?";
        Pattern r = Pattern.compile(pattern);

        // 现在创建 matcher 对象
        Matcher m = r.matcher(line);
        if (m.find( )) {
            System.out.println("Found value: " + m.group(0) );
            System.out.println("Found value: " + m.group(1) );
            System.out.println("Found value: " + m.group(2) );
            System.out.println("Found value: " + m.group(3) );
        } else {
            System.out.println("NO MATCH");
        }

    }

    public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<Character>();
        int left = -1, len = 0;

        for (int i = 0; i < s.length(); i++) {
            if (i != 0) {
                set.remove(s.charAt(i-1));
            }
            while (left + 1 < s.length() && !set.contains(s.charAt(left + 1))) {
                set.add(s.charAt(left + 1));
                left++;
            }

            len = Math.max(len, left - i + 1);
        }
        return len;
    }
}
