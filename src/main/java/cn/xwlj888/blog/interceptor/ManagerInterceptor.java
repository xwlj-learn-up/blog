package cn.xwlj888.blog.interceptor;

import cn.xwlj888.blog.enums.UserEnum;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author zs
 */
@Component
public class ManagerInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        Integer uuid = (Integer) session.getAttribute(UserEnum.UUID.getCode());
        String role = (String) session.getAttribute(UserEnum.ROLE.getCode());
        if (uuid == null || StringUtils.isAllEmpty(role) || !UserEnum.ADMIN.getCode().equals(role)){
            response.sendRedirect("/");
            return  false;
        }
        return  true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
