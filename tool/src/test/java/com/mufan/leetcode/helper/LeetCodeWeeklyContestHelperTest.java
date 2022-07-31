package com.mufan.leetcode.helper;

import com.mufan.leetcode.enums.Region;
import com.mufan.leetcode.model.ContestRank;
import com.mufan.leetcode.model.WeeklyContest;
import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

public class LeetCodeWeeklyContestHelperTest {

    @Test
    public void getWeeklyContest() {
        Optional<WeeklyContest> weeklyContest = LeetCodeWeeklyContestHelper.getWeeklyContest(299);
        Assert.assertTrue(weeklyContest.isPresent());
    }

    @Test
    public void getRanking() {
        Optional<ContestRank> contestRank = LeetCodeWeeklyContestHelper.getRanking(304, Region.LOCAL);
        Assert.assertTrue(contestRank.isPresent());
    }
}