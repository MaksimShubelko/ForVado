package com.company;

public class Main {

    public static void main(String[] args) {
        int[] firstArrayA = new int[]{5, 6, 7, 8, 11, 8, 5, 7, 2};
        int[] secondArrayB = new int[]{50, 6, 70, 80, 11, 80, 50, 70, 20};

        int[] resultArray = getDifference(firstArrayA, secondArrayB);

        printArrayIntoConsole(resultArray);
    }

    private static int[] getDifference(int[] firstArrayA, int[] secondArrayB) {
        int position = 0;
        int[] resultArray = new int[secondArrayB.length];

        for (int value : secondArrayB) {
            if (isElementExist(value, firstArrayA)) {
                resultArray[position] = value;
                position++;
            }
        }

        return resultArray;
    }

    private static boolean isElementExist(int element, int[] array) {

        for (int value : array) {
            if (element == value)
                return true;

        }

        return false;

    }

    private static void printArrayIntoConsole(int[] array) {

        for (int value : array) {
            if (value != 0)
                System.out.print(value + " ");
        }
    }
}
