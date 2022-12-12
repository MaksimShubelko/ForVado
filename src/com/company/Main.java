package com.company;

import java.util.HashSet;
import java.util.Set;

public class Main {

    private static Set<Character> setWhiteSpace = new HashSet<>(Set.of(' '));
    private static int i, j;
    private static boolean isSpace;


    public static void main(String[] args) {
        System.out.println(deleteWhiteSpacesFromLine("d   d     f     s    a"));

    }

    public static String deleteWhiteSpacesFromLine(String line) {
        j = line.length();

        while (i < j) {
            if (setWhiteSpace.contains(line.charAt(i))) {
                if (!isSpace) {
                    isSpace = true;
                    i++;
                } else {
                    line = deleteCharAtFromString(line, i);
                    j = line.length();
                }
            } else {
                if (!setWhiteSpace.contains(line.charAt(i))) {
                    isSpace = false;
                    i++;
                }
            }
        }

        return line;

    }

    public static String deleteCharAtFromString(String line, int position) {
        return line.substring(0, position) + line.substring(position + 1);
    }


}
