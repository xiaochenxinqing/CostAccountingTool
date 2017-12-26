package cn.cat.dao.user;

import cn.cat.pojo.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author yinxiaochen
 * 2017/12/20 13:14
 */
public interface UserMapper {

    User findUser (@Param("userCode") String userCode, @Param("passWord") String passWord)throws  Exception;

    int   truncateAllTables () throws Exception;



}
