package ssm.handler;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ssm.bean.User;
import ssm.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

@Controller
public class LoginHandler {

    @Autowired
    private UserService userService;

    /**
     * 去往登陆页面
     * @return
     */
    @RequestMapping("/loginJsp")
    public String goLoginJsp(){
        return "login";
    }

    /**
     * 处理登陆请求
     * @param req
     * @param resp
     * @return
     * @throws Exception
     */
    @RequestMapping("/login")
    public String loginServlet(HttpServletRequest req, HttpServletResponse resp) throws Exception {

        // 登陆功能的实现
        // 设置接受到的信息的字符编码集
        req.setCharacterEncoding("utf-8");

        // 获取用户登陆的用户名和密码
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        // 设置相应信息的编码集
        resp.setContentType("text/html;charset=utf-8");
        // 获取响应信息相关的流
        PrintWriter writer = resp.getWriter();
        // 判断登陆是否有效
        User user = userService.getUserByNameAndPassword(username, password);
        if (user != null) {

            //登陆成功，去往主界面
            return "success";

        } else {
            //发送登陆失败提示信息
            req.setAttribute("login_msg", "用户名或密码错误！！！");
            //登陆失败，重新去往登陆页面
            return "login";

        }
    }


}