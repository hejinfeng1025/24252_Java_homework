package com.huawei.classroom.student.h08;

public class Dog {
	private int feedMaxTimes=3;

	public int getFeedMaxTimes() {
		return feedMaxTimes;
	}

	public void setFeedMaxTimes(int feedMaxTimes) {
		this.feedMaxTimes = feedMaxTimes;
	}
	public void feed() throws Exception {
		if(feedMaxTimes<=0) {
			throw new Exception("I can not eat more!");
		}
		feedMaxTimes--;
	}
}
