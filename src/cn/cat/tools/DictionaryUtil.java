package cn.cat.tools;

/**
 * @author yinxiaochen
 * 2017/11/10 15:50
 */
public class DictionaryUtil {

    public  static  String showPlatformName(Integer id){
       if(id==1) {

           return "手机";
       }else if(id==2){
           return "平板";
       }else{
           return "通用";
       }

    }


    public  static  String showStatusName(Integer id){
        if(id==1) {

            return "待审核";
        }else if(id==2){
            return "审核通过";
        }else if(id==3){
            return "审核未通过";
        }else if(id==4){
            return "已上架";
        }else {
            return "已下架";
        }

    }


}
