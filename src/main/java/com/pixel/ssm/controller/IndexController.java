package com.pixel.ssm.controller;

import com.pixel.ssm.model.User;
import com.pixel.ssm.service.IndexService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import org.w3c.dom.Comment;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Administrator on 2017/11/20 0020.
 * <p/>
 * 首页控制器
 */
@RequestMapping("/index")
@Scope("prototype") // 每次都创建一个控制器对象
@Controller
public class IndexController {
    // 当前控制器对应的控制器
    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @RequestMapping("/home")
    public String home() {
        logger.info("日志输出 IndexController index");
        return "home";
    }

    @RequestMapping("test/login.do")  // 请求url地址映射，类似Struts的action-mapping
    public String testLogin(@RequestParam(value = "username") String username, String password, HttpServletRequest request) {
        // @RequestParam是指请求url地址映射中必须含有的参数(除非属性required=false)
        // @RequestParam可简写为：@RequestParam("username")

        if (!"admin".equals(username) || !"admin".equals(password)) {
            return "loginError"; // 跳转页面路径（默认为转发），该路径不需要包含spring-servlet配置文件中配置的前缀和后缀
        }
        return "loginSuccess";
    }

    @RequestMapping("/test/login2.do")
    public ModelAndView testLogin2(String username, String password, int age) {
        // request和response不必非要出现在方法中，如果用不上的话可以去掉
        // 参数的名称是与页面控件的name相匹配，参数类型会自动被转换

        if (!"admin".equals(username) || !"admin".equals(password) || age < 5) {
            return new ModelAndView("loginError"); // 手动实例化ModelAndView完成跳转页面（转发），效果等同于上面的方法返回字符串
        }
        return new ModelAndView(new RedirectView("../index.jsp"));  // 采用重定向方式跳转页面
        // 重定向还有一种简单写法
        // return new ModelAndView("redirect:../index.jsp");
    }

    @RequestMapping("/test/login3.do")
    public ModelAndView testLogin3(User user) {
        // 同样支持参数为表单对象，类似于Struts的ActionForm，User不需要任何配置，直接写即可
        String username = user.getUsername();
        String password = user.getPassword();
        int age = user.getAge();

        if (!"admin".equals(username) || !"admin".equals(password) || age < 5) {
            return new ModelAndView("loginError");
        }
        return new ModelAndView("loginSuccess");
    }

    @Resource(name = "indexService")  // 获取applicationContext.xml中bean的id为loginService的，并注入
    private IndexService loginService;  //等价于spring传统注入方式写get和set方法，这样的好处是简洁工整，省去了不必要得代码

    @RequestMapping("/test/login4.do")
    public String testLogin4(User user) {

        if (loginService.login(user) == false) {
            return "loginError";
        }
        return "loginSuccess";
    }

    @RequestMapping
    public String testLogin(String username, String password, int age) {
        // 如果不加任何参数，则在请求/test2/login.do时，便默认执行该方法

        if (!"admin".equals(username) || !"admin".equals(password) || age < 5) {
            return "loginError";
        }
        return "loginSuccess";
    }

    @RequestMapping(params = "method=1", method = RequestMethod.POST)
    public String testLogin2(String username, String password) {
        // 依据params的参数method的值来区分不同的调用方法
        // 可以指定页面请求方式的类型，默认为get请求

        if (!"admin".equals(username) || !"admin".equals(password)) {
            return "loginError";
        }
        return "loginSuccess";
    }

    @RequestMapping(params = "method=2")    // 如果参数method = 2
    public String testLogin3(String username, String password, int age) {
        if (!"admin".equals(username) || !"admin".equals(password) || age < 5) {
            return "loginError";
        }
        return "loginSuccess";
    }

    /**
     * blogId是被@PathVariable标记为请求路径变量的，
     * 如果请求的是/blog/comment/1.do的时候就表示blogId的值为1.
     * 同样@RequestParam也是用来给参数传值的，
     * 但是它是从头request的参数里面取值，
     * 相当于request.getParameter("参数名")方法
     */
    @RequestMapping(value = "/comment/{blogId}", method = RequestMethod.POST)
    public void comment(Comment comment, @PathVariable int blogId, HttpSession session, HttpServletResponse response) throws IOException {

    }

    /**
     * 在Controller的方法中，
     * 如果需要WEB元素HttpServletRequest，HttpServletResponse和HttpSession，
     * 只需要在给方法一个对应的参数，
     * 那么在访问的时候SpringMVC就会自动给其传值，
     * 但是需要注意的是在传入Session的时候如果是第一次访问系统的时候就调用session会报错，
     * 因为这个时候session还没有生成。
     */
    @RequestMapping(value = "/comment2", method = RequestMethod.POST)
    public void comment(HttpServletRequest request, HttpServletResponse response, HttpSession session) {

    }

}
