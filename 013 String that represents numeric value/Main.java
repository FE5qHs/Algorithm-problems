package com;

public class Main {

    public static void main(String[] args) {
        char[] test = new char[]{'1', '2', '3'};
        System.out.println(isNumeric(test));
    }

    private static boolean isNumeric(char[] str) {
        if ('+' == str[0] || '-' == str[0]) {
            return core(str, 0, statusType.minusOrPlus, false, false);
        } else if ('0' < str[0] && str[0] < '9') {
            return core(str, 0, statusType.number, false, false);
        } else if ('.' == str[0]) {
            return core(str, 0, statusType.point, true, false);
        } else {
            return false;
        }
    }

    private enum statusType {
        minusOrPlus, number, e, point
    }

    private static boolean core(char[] str, int index, statusType type, boolean existPoint, boolean existE) {
        if (str.length == index) {
            return false;
        }
        switch (type) {
            case minusOrPlus:
                if ('+' == str[index] || '-' == str[index]) {
                    return core(str, index + 1, statusType.number, existPoint, existE) ||
                            core(str, index + 1, statusType.point, false, false);
                }
                break;
            case number:
                if ('0' <= str[index] && str[index] <= '9') {
                    if (index == str.length - 1) {
                        return true;
                    }
                    return core(str, index + 1, statusType.e, existPoint, existE) ||
                            core(str, index + 1, statusType.number, existPoint, existE) ||
                            core(str, index + 1, statusType.point, existPoint, existE);
                }
                break;
            case e:
                if (existE) {
                    return false;
                } else if ('e' == str[index] || 'E' == str[index]) {
                    return core(str, index + 1, statusType.minusOrPlus, existPoint, true) ||
                            core(str, index + 1, statusType.number, existPoint, true);
                }
                break;
            case point:
                if (existPoint || existE) {
                    return false;
                } else if ('.' == str[index]) {
                    return core(str, index + 1, statusType.number, true, existE);
                }
                break;
        }
        return false;
    }
}