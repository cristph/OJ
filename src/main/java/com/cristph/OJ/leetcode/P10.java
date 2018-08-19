package com.cristph.OJ.leetcode;

public class P10 {

    public boolean isMatch(String s, String p) {
        if (s.length() == 0) {
            if (p.length() == 0) {
                return true;
            } else {
                if (p.length() % 2 == 0) {
                    for (int i = 1; i < p.length(); i = i + 2) {
                        if (p.charAt(i) != '*') {
                            return false;
                        }
                    }
                    return true;
                } else {
                    return false;
                }
            }
        }
        if (p == null || p.length() == 0) {
            return false;
        }
        char[] sc = s.toCharArray();
        char[] pc = p.toCharArray();
        int s_len = sc.length, p_len = pc.length, i = 0, j = 0;
        while (i < s_len && j < p_len) {
            if (j + 1 < p_len) {
                if (pc[j + 1] == '*') {
                    if (pc[j] == '.') {
                        if (j == p_len - 2) {
                            return true;
                        }
                        String tmp = p.substring(j + 2);
                        while (i < s_len) {
                            if (!isMatch(s.substring(i), tmp)) {
                                i++;
                            } else {
                                return true;
                            }
                        }
                        return false;
                    } else {
                        String tmp = p.substring(j + 2);
                        if (isMatch(s.substring(i), tmp)) {
                            return true;
                        }
                        while (sc[i] == pc[j]) {
                            i++;
                            if (isMatch(s.substring(i), tmp)) {
                                return true;
                            }
                            if (i >= s_len) {
                                return true;
                            }
                        }
                    }
                    j += 2;
                } else {
                    if (pc[j] == '.') {
                        i++;
                        j++;
                    } else if (pc[j] == '*') {
                        return false;
                    } else {
                        if (sc[i] == pc[j]) {
                            i++;
                            j++;
                        } else {
                            return false;
                        }
                    }
                }
            } else {
                if (pc[j] == '.') {
                    if (i != s_len - 1) {
                        return false;
                    }
                    return true;
                } else if (pc[j] == '*') {
                    return false;
                } else {
                    if (sc[i] == pc[j] && i == s_len - 1) {
                        return true;
                    }
                    return false;
                }
            }

        }
        if (i >= s_len) {
            if (j >= p_len) {
                return true;
            } else {
                if (j + 1 == p_len - 1 && pc[j + 1] == '*') {
                    return true;
                } else {
                    return false;
                }
            }
        } else {
            return false;
        }
    }
}
