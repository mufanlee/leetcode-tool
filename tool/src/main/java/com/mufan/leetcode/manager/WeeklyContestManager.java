package com.mufan.leetcode.manager;

import cn.hutool.core.text.StrPool;
import cn.hutool.log.Log;
import com.mufan.leetcode.enums.Region;
import com.mufan.leetcode.helper.LeetCodeWeeklyContestHelper;
import com.mufan.leetcode.model.ContestRank;
import com.mufan.leetcode.model.UserRank;
import com.mufan.leetcode.model.WeeklyContest;
import com.mufan.leetcode.util.ExcelUtils;
import com.mufan.leetcode.util.PropUtils;

import java.util.List;
import java.util.Optional;

/**
 * WeeklyContest Manager
 *
 * @author lipeng
 */
public final class WeeklyContestManager {
    private static final Log LOG = Log.get();

    private WeeklyContestManager() {
    }

    public static void generateNote(int weeklyContestId, String rootPath) {
        Optional<WeeklyContest> contest = LeetCodeWeeklyContestHelper.getWeeklyContest(weeklyContestId);
        if (!contest.isPresent()) {
            LOG.error("Weekly contest {} request failed!", weeklyContestId);
            return;
        }

        LOG.info(contest.get().getContest().getTitle());
        LOG.info("[第{}场](leetcode/weekly-contest/第{}场.md)", weeklyContestId, weeklyContestId);
        String path = rootPath + "contest/c" + weeklyContestId + StrPool.SLASH;
        contest.get().getQuestions().forEach(question -> AnswerNoteManager.generateNote(question.getTitleSlug(), path));
    }

    public static void generateBiWeeklyNote(int weeklyContestId, String rootPath) {
        Optional<WeeklyContest> contest = LeetCodeWeeklyContestHelper.getBiweeklyContest(weeklyContestId);
        if (!contest.isPresent()) {
            LOG.error("BiWeekly contest {} request failed!", weeklyContestId);
            return;
        }

        LOG.info(contest.get().getContest().getTitle());
        LOG.info("[第{}场](leetcode/weekly-contest/第{}场.md)", weeklyContestId, weeklyContestId);
        String path = rootPath + "contest/cc" + weeklyContestId + StrPool.SLASH;
        contest.get().getQuestions().forEach(question -> AnswerNoteManager.generateNote(question.getTitleSlug(), path));
    }

    public static void generateRanking(int weeklyContestId, String rootPath) {
        Optional<ContestRank> contestRank = LeetCodeWeeklyContestHelper.getRanking(weeklyContestId, Region.LOCAL);
        if (!contestRank.isPresent()) {
            LOG.error("Weekly contest {} ranking request failed!", weeklyContestId);
            return;
        }

        List<UserRank> totalRank = contestRank.get().getTotalRank();
        String path = rootPath + "contest/c" + weeklyContestId + "/Ranking-" + weeklyContestId + ".xlsx";
        LOG.info(path);
        ExcelUtils.write(path, totalRank);
    }

    public static void main(String[] args) {
        String path = PropUtils.getStr("configs/config.properties", "code-path");
//        WeeklyContestManager.generateNote(298, path);
//        WeeklyContestManager.generateNote(300, path);
//        WeeklyContestManager.generateNote(301, path);
//        WeeklyContestManager.generateNote(305, path);
//        WeeklyContestManager.generateRanking(305, path);
//        WeeklyContestManager.generateNote(311, path);
        WeeklyContestManager.generateRanking(319, path);
//        WeeklyContestManager.generateNote(318, path);
//        WeeklyContestManager.generateRanking(313, path);
//        WeeklyContestManager.generateBiWeeklyNote(88, path);
    }
}
