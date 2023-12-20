package common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

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
	
	@Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        System.out.println("vo.getUser_id(): " + modelAndView.getModel().get("vo.getUser_id()"));
        System.out.println("vo.getUsername(): " + modelAndView.getModel().get("vo.getUsername()"));
        System.out.println("username: " + modelAndView.getModel().get("username"));
    }
	
}
