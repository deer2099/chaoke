package com.kexun.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.kexun.dao.impl.IDao;
import com.kexun.entity.Student;
import com.kexun.service.MyService;

//Ĭ�ϰ���������ĸСдע��,����:�˴���һ�������Ķ�����
//ΪiMyServcie;�˴�Ҳ����ָ��һ��������
//����:@Repository("imys")
@Service
public class IMyServcie implements MyService {
	// ��������������ע��
	@Resource
	IDao iDao;// ������Ϊ֮ǰע��ָ��Ĭ�϶�����
	// ʹ��@Autowired�����@QualifierҲ�ܰ�����ע��
	// @Autowired
	// @Qualifier("iDao")
	// IDao iDao;
	// �������еĶ���face��С����

	@Override
	public List<Student> queryAll() {
		// TODO Auto-generated method stub
		List<Student> list = iDao.selectAll();
		//ð������
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
