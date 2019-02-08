package com;

public class Main {

    public static void main(String[] args) {
        StringBuffer c = new StringBuffer();
        StringBuffer r = new StringBuffer("aa");
        allPermutation(c, r);
    }

    static void allPermutation(StringBuffer current, StringBuffer remain) {
        if (remain.length() != 0) {
            for (int i = 0; i < remain.length(); ++i) {
                StringBuffer tempRemain = new StringBuffer(remain);
                StringBuffer tempCurrent = new StringBuffer(current);
                tempCurrent.append(remain.charAt(i));
                tempRemain.deleteCharAt(i);
                allPermutation(tempCurrent, tempRemain);
            }
        } else {
            System.out.println(current);
        }
    }
}