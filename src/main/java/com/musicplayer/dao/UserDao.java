package com.musicplayer.dao;

import org.springframework.stereotype.Repository;

import com.musicplayer.entity.User;

@Repository(value = "userDao")
public interface UserDao {

	/**
     * �˷�����Ӧ�����ݿ��еı� ,user
     * ��д�����ݿ��¼
     *
     * @param record
     */
	void add(User user);
	 /**
     * �˷�����Ӧ�����ݿ��еı� ,user
     * �������������·������������ݿ��¼
     *
     * @param record
     */
	void update(User user);
}
