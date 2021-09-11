package ssm.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ssm.bean.User;
import ssm.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@Controller
public class RegistHandler {
    @Autowired
    private UserService userService;

    /**
     * 去往登陆页面
     * @return
     */
    @RequestMapping("/registJsp")
    public String goLoginJsp(){
        return "regist";
    }

    /**
     * 处理登陆请求
     * @param req
     * @param resp
     * @return
     * @throws Exception
     */
    @RequestMapping("/regist")
    public String registServlet(HttpServletRequest req, HttpServletResponse resp) throws Exception {

        //1. 接受浏览器端的请求数据
        req.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String repassword = req.getParameter("repassword");

        //2. 判断数据
        User user = userService.getUserByName(username);
        if (user == null && password.equals(repassword)) {
            //可以注册
            userService.addUser(username, password);
            //注册成功，去往登陆界面
            return "login";
        } else if(user == null && password.equals(repassword)){
            //注册失败
            resp.setContentType("text/html;charset=utf-8");
            req.setAttribute("regist_msg", "注册失败，密码不一致！");
            //重新去往注册界面
            return "regist";

        } else {
            //注册失败
            resp.setContentType("text/html;charset=utf-8");
            req.setAttribute("regist_msg", "注册失败，用户名已存在！");
            //重新去往注册界面
            return "regist";
        }
    }

}
