package cn.cat.service.user;

import cn.cat.pojo.User;

/**
 * @author yinxiaochen
 * 2017/12/20 13:58
 */
public interface UserService {
    User findUser ( String userCode, String passWord)throws  Exception;
}
