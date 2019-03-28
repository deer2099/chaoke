package com.syc.tools;

import java.io.IOException;
import java.io.Reader;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

public class DBUtils {
	/**
	 * @author adai
	 * @data 2019-3-26 15:45
	 * @detail 实现mybatis数据库连接操作
	 */
	public static SqlSession getSession() {
		// 使用日志对象输出信息
		Logger log = Logger.getLogger(DBUtils.class);
		SqlSessionFactory sf = null;
		SqlSession ss = null;
		try {
			// (1)生成字符输入对象,传入sessionFactory中
			Reader rd = Resources.getResourceAsReader("my.xml");
			// (2)创建一个sessionFactory的实现类的对象
			SqlSessionFactoryBuilder sfb = new SqlSessionFactoryBuilder();
			// (3)sf指向它的子类对象
			sf = sfb.build(rd);
			// (4)生成数据库操作对象
			ss = sf.openSession();
            log.info("连接成功");
			//System.out.println("----ok----");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			 log.info("----o,my god!----");
			e.printStackTrace();
		}

		return ss;
	}

	// 关闭数据库操作对象
	public static void closeDB(SqlSession ss) {
		if (ss != null) {
			ss.close();
		}
	}

}
