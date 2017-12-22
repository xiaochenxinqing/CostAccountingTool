package cn.cat.pojo;



/**
 * 前台用户
 * @author kongxiangzhong
 * 2017/11/7 8:32
 */
public class User {
    private  int id; //主键Id
    private  String userCode; //账号
    private  String userName; //用户名称
    private  String passWord;   //密码

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
