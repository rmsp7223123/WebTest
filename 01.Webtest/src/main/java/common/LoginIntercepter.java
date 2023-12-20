package common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

public class LoginIntercepter implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 로그인 여부 확인
		Object loggedInUser = request.getSession().getAttribute("loggedInUser");
		if (loggedInUser == null) {
			response.sendRedirect("/rxo");
			return false;
		}
		return true;
	}
	
	
}
