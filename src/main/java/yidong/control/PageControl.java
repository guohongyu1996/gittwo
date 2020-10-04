package yidong.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import yidong.biz.AdminServiceInf;
import yidong.biz.CategoryServiceInf;
import yidong.biz.UserServiceInf;
import yidong.util.CategoryList;
import yidong.vo.admin.Admin;
import yidong.vo.admin.Category;
import yidong.vo.user.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class PageControl {
    @Autowired
    private AdminServiceInf adminServiceInf;

    @Autowired
    private UserServiceInf userServiceInf;

    @Autowired
    private CategoryServiceInf categoryServiceInf;
//管理员登录
    @RequestMapping("login")
    public String login() {
        return "adminjsps/login";
    }
//    用户跳转登录
    @RequestMapping( "usertiaologin")
    public String userlogin() {
        return "jsps/user/login";
    }
//用户登录
    @RequestMapping("userlogin")
    public String userLogin(HttpServletRequest req, User user, HttpSession session){
        User u=userServiceInf.loginUser(user);
        if(u!=null){
            session.setAttribute("user", u);
            return "jsps/main";
        }else{
            req.setAttribute("msg", "登陆失败，账号或密码错误");
            return "jsps/user/login";
        }
    }
//    进入数据库查询用户名，如如果存在则返回1失败
    @ResponseBody
    @RequestMapping("ajaxloginname")
    public String ajaxLoginName(User user){
        String a="";
        User u=userServiceInf.ajaxLoginName(user);
        if(u!=null){
            a="{\"result\":1}";//失败
        }else{
            a="{\"result\":0}";
        }

        return a;
    }

    @ResponseBody
    @RequestMapping("ajaxloginpassword")
    public String ajaxLoginpassword(User user){
        String a="";
        User u=userServiceInf.ajaxLoginpassword(user);
        if(u!=null){
            a="{\"result\":0}";
        }else{
            a="{\"result\":1}";
        }

        return a;
    }


    //登陆
    @RequestMapping(value = "loginpost", method = RequestMethod.POST)
    public String loginAdmin(Admin admin, HttpServletRequest req, HttpSession session){
        Admin ad=adminServiceInf.loginAdmin(admin);
        if(ad!=null){
            session.setAttribute("admin", ad);
            return "adminjsps/admin/main";
        }else{
            req.setAttribute("msg", "登陆失败，账号或密码错误");
            return "adminjsps/login";
        }

    }
    //退出
    @RequestMapping("loginout")
    public String loginOut(HttpSession session){
        session.invalidate();
        return "adminjsps/login";
    }
    @RequestMapping("userloginout")
    public String userloginOut(HttpSession session){
        session.invalidate();
        return "jsps/main";
    }
    @RequestMapping("getcategorylist")
    public String getcategorylist(HttpServletRequest req){
        List<Category> list1=categoryServiceInf.getCategory1list();
        List<Category> list2=categoryServiceInf.getCategory2list();
        List<Category> list= CategoryList.sort(list1, list2);
        req.setAttribute("cateforylist", list);
        return "jsps/left";
    }

}
