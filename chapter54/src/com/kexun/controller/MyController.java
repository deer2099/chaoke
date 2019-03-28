package com.kexun.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

//���@Controllerע�������ΪController����,���Դ���ǰ��������Ӧ�Ӿ�
@Controller
@RequestMapping("/kx")
public class MyController {
	@RequestMapping("/hqy")
	public ModelAndView play(HttpServletRequest req, HttpServletResponse resp) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("msg", "ע����������");
		mv.setViewName("/WEB-INF/beifeng.jsp");
		return mv;
	}

	@RequestMapping("/disp1")
	public String gogo(HttpServletRequest req, HttpServletResponse resp) {
		@SuppressWarnings("unused")
		HttpSession ss = req.getSession();
		@SuppressWarnings("unused")
		ServletContext sc = req.getServletContext();
		req.setAttribute("name", "tom");
		//// ��springmvcĬ�������ʹ���ض����ǲ���������,
		//// ������ʹ��flash����ʵ���ض���ֵ,spring3.0�Ժ����
		return "redirect:/index.jsp";
	}

	@RequestMapping("/disp2")
	public String go() {
		// return "forward:/index.jsp";
		//// ����ʹ��ԭ�����������������/////
		// (1)�����������,�˴������ο�
		HttpServletRequest req = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
				.getRequest();
		req.setAttribute("req", "�Ҿ�����");
		// (2)ͨ��req����HttpSession�Ự����
		HttpSession hs = req.getSession();
		hs.setAttribute("session", "��һ�����̻�");
		// (2)ͨ��req����ApplicationӦ�ö���,�˴���Ӧ����ServletContext����
		ServletContext sc = req.getServletContext();
		sc.setAttribute("app", "˭���̻�");
		return "/index.jsp";
	}

	int sum;

	// �˴�û�з���ֵ,������һЩҵ���߼�,����Ҫ��ת
	@RequestMapping("/daniu")
	public void dn() {
		int a = 10;
		int b = 90;
		sum = a + b;
	}
}
