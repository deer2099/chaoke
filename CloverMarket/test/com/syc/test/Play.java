package com.syc.test;

import org.apache.ibatis.session.SqlSession;

import com.syc.tools.DBUtils;

public class Play {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      play();
	}
	public static void play(){
		SqlSession ss=DBUtils.getSession();
		ss.close();
	}

}
