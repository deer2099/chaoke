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

//添加@Controller注解后此类就为Controller类了,可以处理前端请求并响应擞据
@Controller
@RequestMapping("/kx")
public class MyController {
	@RequestMapping("/hqy")
	public ModelAndView play(HttpServletRequest req, HttpServletResponse resp) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("msg", "注解让我来的");
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
		//// 在springmvc默认情况下使用重定向是不允许传数据,
		//// 但可以使用flash技术实现重定向传值,spring3.0以后可以
		return "redirect:/index.jsp";
	}

	@RequestMapping("/disp2")
	public String go() {
		// return "forward:/index.jsp";
		//// 可以使用原生的请求域对象传数据/////
		// (1)生成请求对象,此处仅作参考
		HttpServletRequest req = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
				.getRequest();
		req.setAttribute("req", "我就是我");
		// (2)通过req生成HttpSession会话对象
		HttpSession hs = req.getSession();
		hs.setAttribute("session", "不一样的烟火");
		// (2)通过req生成Application应用对象,此处对应的是ServletContext对象
		ServletContext sc = req.getServletContext();
		sc.setAttribute("app", "谁是烟火");
		return "/index.jsp";
	}

	int sum;

	// 此处没有返回值,仅处理一些业务逻辑,不需要跳转
	@RequestMapping("/daniu")
	public void dn() {
		int a = 10;
		int b = 90;
		sum = a + b;
	}
}
