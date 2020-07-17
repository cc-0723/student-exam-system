package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class loginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        //判断是否为敏感资源，如果不是，重定向到登录界面
        String uri = req.getServletPath();
        if(!uri.startsWith("/public/") && (!uri.startsWith("/static/")) && !"/user/login".equals(uri)) {
            HttpSession session = req.getSession(false);
            if(session == null) {
                String schema = req.getScheme();
                String host = req.getServerName();
                int port = req.getServerPort();
                String contestPath = req.getContextPath();
                String basePath = schema + "://" + host + ":" + port + contestPath;
                resp.sendRedirect(basePath + "/public/index.html");
                return;
            }
        }
        //继续调用过滤器
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
