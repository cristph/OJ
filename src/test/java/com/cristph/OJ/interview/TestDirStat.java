package com.cristph.OJ.interview;

import com.cristph.OJ.interview.alibaba.DirStat;
import org.junit.jupiter.api.Test;

public class TestDirStat {

    @Test
    public void testDirStat() {
        DirStat dirStat = new DirStat();
        dirStat.stat("/Users/cristph/Desktop");
    }
}
