package com.mufan.leetcode.manager;

import cn.hutool.log.Log;
import com.mufan.leetcode.constant.Constant;
import com.mufan.leetcode.helper.LeetCodeWeeklyContestHelper;
import com.mufan.leetcode.model.WeeklyContest;

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
            LOG.error("Weekly Contest {} request failed!", weeklyContestId);
            return;
        }

        LOG.info(contest.get().getContest().getTitle());
        LOG.info("[第{}场](leetcode/weekly-contest/第{}场.md)", weeklyContestId, weeklyContestId);
        String path = rootPath + "contest\\c" + weeklyContestId + "\\";
        contest.get().getQuestions().forEach(question -> AnswerNoteManager.generateNote(question.getTitleSlug(), path));
    }

    public static void main(String[] args) {
        WeeklyContestManager.generateNote(298, Constant.CODING_PATH);
        WeeklyContestManager.generateNote(299, Constant.CODING_PATH);
    }
}
