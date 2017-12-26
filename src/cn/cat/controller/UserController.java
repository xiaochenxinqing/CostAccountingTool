package cn.cat.controller;

import cn.cat.pojo.User;

import cn.cat.service.user.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author yinxiaochen
 * 2017/11/6 18:46
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;


    @RequestMapping("/dologin.do")
    public String chooseIdentity(User user, Model model, HttpSession session) {
        User userTemp = null;
        try {
            userTemp = userService.findUser(user.getUserCode(), user.getPassWord());
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (userTemp != null) {
            session.setAttribute("user", userTemp);
            return "frame";
        }
        model.addAttribute("error", "账号或密码错误！");
        return "index";

    }

    @RequestMapping("/loginout.do")
    public String loginout(HttpServletRequest request) {//登出
        //    注销用户，使session失效。
        request.getSession().removeAttribute("user");

        return "index";
    }

    @RequestMapping("/resetData.do")
    @ResponseBody
    public String resetData() throws Exception {
        String reInfo = "";
        int result = -1;
        result = userService.truncateAllTables();
        if (result > 0) {
            reInfo = "success";
        }
        return "{\"status\":\"" + reInfo + "\"}";
    }

}