package com.cristph.OJ.leetcode.problems;

import java.util.ArrayList;

public class P6 {

    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        int len = s.length();
        int count = Math.min(numRows, len);
        ArrayList<StringBuilder> list = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            list.add(new StringBuilder());
        }
        boolean goingDown = false;
        char[] array = s.toCharArray();
        int row = 0;
        for (int i = 0; i < len; i++) {
            list.get(row).append(array[i]);
            if (row == 0 || row == numRows - 1) goingDown = !goingDown;
            if (goingDown) row++;
            else row--;
        }
        StringBuilder stringBuilder = new StringBuilder(len);
        for (StringBuilder builder : list) {
            stringBuilder.append(builder);
        }
        return stringBuilder.toString();
    }
}
