package com.epam.sort;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();

        int[] arraySmall = {5, 4, 3, 2, 1};
        int[] arrayDifficult = {99, 98, 97, 96, 95, 94, 93, 92, 91, 90, 89, 88, 87, 86, 85, 84, 83, 82, 81, 80, 79, 78, 77, 76, 75, 74, 73, 72, 71, 70, 69, 68, 67, 66, 65, 64, 63, 62, 61, 60, 59, 58, 57, 56, 55, 54, 53, 52, 51, 50, 49, 48, 47, 46, 45, 44, 43, 42, 41, 40, 39, 38, 37, 36, 35, 34, 33, 32, 31, 30, 29, 28, 27, 26, 25, 24, 23, 22, 21, 20, 19, 18, 17, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        int[] arrayEasy = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99};

        int[] array = arraySmall;
        int[] oneWay = bubbleSort.sortOneWayBubble(array);
        int[] twoWay = bubbleSort.sortTwoWayBubble(array);
        Arrays.stream(array).forEach(System.out::print);
        System.out.println();
        Arrays.stream(oneWay).forEach(System.out::print);
        System.out.println();
        Arrays.stream(twoWay).forEach(System.out::print);


    }

    public int[] sortOneWayBubble(int[] array) {
        int[] result = new int[array.length];
        System.arraycopy(array, 0, result, 0, array.length);
        boolean sorted = false;
        int iterations = 0;
        int swaps = 0;
        int scanDistance = array.length - 1;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < scanDistance; i++) {
                if (result[i] > result[i + 1]) {
                    sorted = false;
                    int temp = result[i];
                    result[i] = result[i + 1];
                    result[i + 1] = temp;
                    swaps++;
                }

                iterations++;
            }
            scanDistance--;
        }
        System.out.println("OneWayBubble. ArraySize: " + array.length);
        System.out.println("Iterations: " + iterations);
        System.out.println("Swaps: " + swaps);
        return result;
    }

    public int[] sortTwoWayBubble(int[] array) {
        int[] result = new int[array.length];
        System.arraycopy(array, 0, result, 0, array.length);
        boolean sorted = false;
        int iterations = 0;
        int swaps = 0;
        int leftLimit = 0;
        int rightLimit = array.length - 1;
        boolean forwardScan = true;

        while (!sorted) {
            sorted = true;
            int scanStart, scanFinish, additional;
            if (forwardScan) {
                scanStart = leftLimit;
                scanFinish = rightLimit - 1;
                additional = 1;
            } else {
                scanStart = rightLimit;
                scanFinish = leftLimit + 1;
                additional = -1;
            }
            for (int i = scanStart; i != scanFinish; i += additional) {
                if (result[i] > result[i + additional]) {
                    sorted = false;
                    int temp = result[i];
                    result[i] = result[i + additional];
                    result[i + additional] = temp;
                    swaps++;
                }
            }
            iterations++;
            if (forwardScan) rightLimit--;
            else leftLimit++;
            forwardScan = !forwardScan;
        }
        System.out.println("TwoWayBubble. ArraySize: " + array.length);
        System.out.println("Iterations: " + iterations);
        System.out.println("Swaps: " + swaps);
        return result;
    }

}
