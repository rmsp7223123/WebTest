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
//		if (loggedInUser == null) {
//			// 로그인되지 않은 경우 로그인 페이지로 리다이렉트
//			String loginErrorMessage = "로그인이 필요합니다.";
//			response.sendRedirect("/rxo");
//			return false;
//		}
		if (!request.getRequestURI().equals("/rxo/home")) {
            response.sendRedirect("/rxo"); // 로그인 페이지 경로로 수정
            return false; // 뒷단 컨트롤러 호출을 막음
        }
		return true;
	}
}
