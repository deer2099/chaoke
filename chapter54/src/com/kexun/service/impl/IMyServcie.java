package com.kexun.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.kexun.dao.impl.IDao;
import com.kexun.entity.Student;
import com.kexun.service.MyService;

//默认按类名首字母小写注入,比如:此处有一个隐含的对象名
//为iMyServcie;此处也可以指定一个属性名
//比如:@Repository("imys")
@Service
public class IMyServcie implements MyService {
	// 它是以属性名称注入
	@Resource
	IDao iDao;// 此名称为之前注解指定默认对象名
	// 使用@Autowired并结合@Qualifier也能按名称注入
	// @Autowired
	// @Qualifier("iDao")
	// IDao iDao;
	// 将集合中的对象按face大小排序

	@Override
	public List<Student> queryAll() {
		// TODO Auto-generated method stub
		List<Student> list = iDao.selectAll();
		//冒泡排序
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < list.size()-i- 1; j++) {
				Student temp = list.get(j);
				if (list.get(j).getFace() > list.get(j + 1).getFace()) {
					list.set(j, list.get(j + 1));
					list.set(j + 1, temp);
				}
			}
		}
		return list;
	}

}
