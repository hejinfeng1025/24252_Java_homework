package com.huawei.classroom.student.h55;

import java.util.*;

/**
 * @author hejinfeng
 * @create 2025-06-11 14:03
 */
public class Voter {
    // 投票人微信ID
    private final String voterId;
    // 该微信ID的所有投票记录
    private final List<Record> records = new ArrayList<>();
    // 10分钟内最多允许的投票数
    private static final int MAX_RECORDS_IN_TEN_MINUTES = 5;

    /**
     * 构造方法，初始化微信ID
     */
    public Voter(String voterId) {
        this.voterId = voterId;
    }
    /**
     * 添加一条投票记录
     */
    public void addRecord(Record record) {
        records.add(record);
    }

    /**
     * 获取微信ID
     */
    public String getVoterId() {
        return voterId;
    }

    /**
     * 获取该微信ID的所有投票记录
     */
    public List<Record> getRecords() {
        return records;
    }

    /**
     * 移除无效投票记录，保证每个微信ID 1分钟内最多1票，10分钟内最多5票。
     * 算法思路：
     * 1. 先移除10分钟前的票，保证窗口内都是10分钟内的票。
     * 2. 如果10分钟窗口已满5票，当前票无效。
     * 3. 再判断1分钟内是否有票，有则当前票无效。
     * 4. 只有都通过才加入窗口。
     * 这样可以保证边界条件和统计的准确性。
     */
    public void removeInvalidRecords() {
        // 先按时间排序，保证后续处理的正确性
        records.sort(Record::compareTo);
        // tenMinWindow用于维护10分钟内的有效票
        List<Record> tenMinWindow = new ArrayList<>();
        for (Record record : records) {// 移除10分钟前的记录（只保留10分钟内的记录）
            while (!tenMinWindow.isEmpty() &&
                    record.getDate().getTime() - tenMinWindow.get(0).getDate().getTime() >= 600000) {
                tenMinWindow.remove(0);
            }
            if (tenMinWindow.size() >= 5) { // 如果10分钟窗口已满5票，当前票无效
                record.setInvalid();
                continue;
            }
            // 检查1分钟内是否有有效票（只需看窗口内最后一票即可，因为已排序）
            boolean oneMinConflict = false;
            for (int i = tenMinWindow.size() - 1; i >= 0; i--) {
                Record r = tenMinWindow.get(i);
                // 如果当前票与窗口内某票时间差小于1分钟，则冲突
                if (record.getDate().getTime() - r.getDate().getTime() < 60000) {
                    oneMinConflict = true;
                    break;
                } else {// 已排序，遇到超过1分钟的直接break
                    break;
                }
            }
            if (oneMinConflict) {
                record.setInvalid();
            } else {// 当前票有效，加入10分钟窗口
                tenMinWindow.add(record);
            }
        }
    }

    /**
     * 统计某个微信ID下所有有效投票，返回候选人及其票数的Map
     */
    public Map<String, Integer> getCandidates() {
        Map<String, Integer> candidates = new HashMap<>();
        for (Record record : records) {
            // 跳过无效票
            if (!record.isValid()) {
                continue;
            }
            // 获取候选人名字
            String candidate = record.getCandidate();
            // 统计票数
            int count = candidates.getOrDefault(candidate, 0);
            candidates.put(candidate, count + 1);
        }
        return candidates;
    }

}
