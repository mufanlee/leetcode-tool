package com.mufan.leetcode.manager;

import cn.hutool.core.text.StrPool;
import cn.hutool.log.Log;
import com.mufan.leetcode.helper.LeetCodeWeeklyContestHelper;
import com.mufan.leetcode.model.WeeklyContest;
import com.mufan.leetcode.util.PropUtils;

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
        String path = rootPath + "contest/c" + weeklyContestId + StrPool.SLASH;
        contest.get().getQuestions().forEach(question -> AnswerNoteManager.generateNote(question.getTitleSlug(), path));
    }

    public static void generateBiWeeklyNote(int weeklyContestId, String rootPath) {
        Optional<WeeklyContest> contest = LeetCodeWeeklyContestHelper.getBiweeklyContest(weeklyContestId);
        if (!contest.isPresent()) {
            LOG.error("Weekly Contest {} request failed!", weeklyContestId);
            return;
        }

        LOG.info(contest.get().getContest().getTitle());
        LOG.info("[第{}场](leetcode/weekly-contest/第{}场.md)", weeklyContestId, weeklyContestId);
        String path = rootPath + "contest/cc" + weeklyContestId + StrPool.SLASH;
        contest.get().getQuestions().forEach(question -> AnswerNoteManager.generateNote(question.getTitleSlug(), path));
    }

    public static void main(String[] args) {
        String path = PropUtils.getStr("configs/config.properties", "code-path");
//        WeeklyContestManager.generateNote(298, path);
//        WeeklyContestManager.generateNote(300, path);
        WeeklyContestManager.generateNote(301, path);
//        WeeklyContestManager.generateBiWeeklyNote(81, path);
    }
}
