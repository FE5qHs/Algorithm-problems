package com;

public class Main {

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7};
        reOrderArray(array);
        for (int i = 0; i < array.length; ++i) {
            System.out.println(array[i]);
        }
    }

    static void reOrderArray(int[] array) {
        if (array.length < 2) {
            return;
        }
        boolean status = array[0] % 2 == 0;
        for (int i = 1; i < array.length; ++i) {
            if (status && array[i] % 2 != 0) {
                for (int j = i; j > 0 && array[j - 1] % 2 == 0; --j) {
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
            status = array[i] % 2 == 0;
        }
    }
}