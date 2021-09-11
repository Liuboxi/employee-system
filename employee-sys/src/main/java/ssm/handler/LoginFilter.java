package ssm.handler;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginFilter implements Filter {

    //初始化方法
    public void init(FilterConfig fConfig) throws ServletException {
        System.out.println("LoginFilter初始化完成");
    }

    //过滤方法
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse resp = (HttpServletResponse)response;

        System.out.println("URL:" + req.getRequestURL());
        System.out.println("URI:" + req.getRequestURI());

        //判断要过滤的请求
        String url = req.getRequestURI();
        if(url.endsWith("/success.jsp")){
            //过滤，引导去往登陆页面
            resp.sendRedirect("login.jsp");
        }else if(url.endsWith("emps")){
            //过滤，引导去往登陆页面
            resp.sendRedirect("login.jsp");
        }else{
            //放行，继续执行后续处理
            //FilterChain: 过滤器链对象
            chain.doFilter(req, resp);
        }
    }

    //销毁方法
    public void destroy() {
        System.out.println("LoginFilter销毁完成");
    }
}
