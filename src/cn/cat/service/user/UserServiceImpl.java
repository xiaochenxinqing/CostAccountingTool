package cn.cat.service.user;

import cn.cat.dao.user.UserMapper;
import cn.cat.pojo.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author yinxiaochen
 * 2017/12/20 13:58
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper UserMapper;
    /**
     * 根据用户名和密码查找相关用户对象
     * @param userCode
     * @param passWord
     * @return
     * @throws Exception
     */
    @Override
    public User findUser(String userCode, String passWord) throws Exception {
        return UserMapper.findUser(userCode,passWord);
    }

    @Override
    public int truncateAllTables() throws Exception {
        return UserMapper.truncateAllTables();
    }
}
