package com.huawei.classroom.student.h55;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author hejinfeng
 * @create 2025-06-10 16:56
 */
public class Record implements Comparable<Record>{
    //记录：投票的时间（yyyy-MM-dd HH:mm:ss 格式） +\t+投票的微信ID+\t+候选人
    //例如2021-05-03 09:03:05	wxid_2	wang
    private Date date;
    private String voterId;
    private String candidate;
    private boolean valid;

    public Record(String date, String voterId, String candidate) {
        DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            this.date = fmt.parse(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.voterId = voterId;
        this.candidate = candidate;
        valid = true; // 默认有效
    }

    public void setInvalid() {
        this.valid = false;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date voteTime) {
        this.date = voteTime;
    }

    public String getCandidate() {
        return candidate;
    }

    public void setCandidate(String candidate) {
        this.candidate = candidate;
    }

    public String getVoterId() {
        return voterId;
    }

    public void setVoterId(String voterId) {
        this.voterId = voterId;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    /**
     * 按投票时间升序排序
     */
    @Override
    public int compareTo(Record o) {
        return this.date.compareTo(o.date);
    }


}
