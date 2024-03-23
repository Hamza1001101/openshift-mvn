package org.farah.openshiftmvn.util;

import java.util.HashMap;
import java.util.Map;

public class Util {
    public static void main(String[] args) {

        Map<Character, Integer> somaliland = countDuplicateCharacters("somaliland");
        System.out.println(somaliland);
    }
    public static Map<Character, Integer> countDuplicateCharacters(String str) {
        var map = new HashMap<Character, Integer>();
        for (int i = 0; i < str.length(); i++) {
            map.putIfAbsent(str.charAt(i), 0);
            map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
        }
        return map;
    }
}
