package cn.rusth.testController;

import cn.rusth.dao.UserDao;
import cn.rusth.entity.User;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


/**
 * Created by rusth on 2017/7/17.
 * @RestController (类里面的所有的返回都是json)  spring 4
 * 和
 * @Controller的返回需要@ResponseBody返回json的接口 spring 3
 */

@Controller
@RequestMapping("/user")
public class UserOperationController {

    @Autowired
    private UserDao userDao;

    /**
     * 返回json值
     *
     * @return
     */
    @RequestMapping("/login1.json")
    @ResponseBody
    public JSONObject login1() {
        JSONObject result = new JSONObject();
        User user = userDao.selectByPrimaryKey(1);
        if (user != null) {
            result.put("message", "登陆成功");
        } else {
            result.put("message", "登陆失败");
        }
        return result;
    }
    @RequestMapping(value = "/tologin")
    public String toLoginPage(){
        return "login";
    }

    /**
     * modelAndView返回
     *
     * @param username
     * @param password
     * @return
     */
    @RequestMapping(value = "/login")
    public ModelAndView login(String username, String password) {
        //验证传递过来的参数是否正确，否则返回到登陆页面。
        User user = userDao.login(username, password);
        if (user != null) {
            //指定要返回的页面为succ.jsp
            ModelAndView mav = new ModelAndView("loginsuccess");
            //将参数返回给页面
            mav.addObject("username", username);
            mav.addObject("password", password);
            return mav;
        } else {
            return new ModelAndView("loginerror");
        }
    }

    /**
     * 返回值区别
     *
     * @param username
     * @param password
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/login2")
    public String login2(String username, String password, ModelMap modelMap) {
        User user = userDao.login(username, password);
        if (user != null) {
            //将参数返回给页面
            modelMap.addAttribute("username", username);
            modelMap.addAttribute("password", password);
            return "loginsuccess";//匹配文件名
        } else {
            return "loginerror";
        }
    }

    /**
     * 重定向
     *
     * @param username
     * @param password
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/login3")
    public String login3(String username, String password, ModelMap modelMap) {
        User user = userDao.login(username, password);
        if (user != null) {
            //将参数返回给页面
            modelMap.addAttribute("username", username);
            modelMap.addAttribute("password", password);
            return "redirect:/index.html";//重定向 无法跳转到web-inf下 如果要跳转，做方法 跳转
        } else {
            return "loginerror";
        }
    }

    /**
     * 重定向
     *
     * @param username
     * @param password
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/login4")
    public ModelAndView login4(String username, String password, ModelMap modelMap) {
        User user = userDao.login(username, password);
        if (user != null) {
            //将参数返回给页面
            modelMap.addAttribute("username", username);
            modelMap.addAttribute("password", password);
            return new ModelAndView("redirect:/index.html");
        } else {
            return new ModelAndView("loginerror");
        }
    }

    @RequestMapping(value = "/getuser/{id}")
    @ResponseBody
    public User getUrlParam(@PathVariable("id") String id) {
        User user = userDao.selectByPrimaryKey(Integer.parseInt(id));
        return user;
    }
}
