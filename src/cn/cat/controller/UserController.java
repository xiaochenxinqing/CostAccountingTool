package cn.cat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author yinxiaochen
 * 2017/11/6 18:46
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/dologin.do")
    public String chooseIdentity(@RequestParam("userCode") String userCode,@RequestParam("passWord")String passWord) {

            return "frame";

    }
}