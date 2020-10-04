package yidong.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import yidong.biz.UserServiceInf;
import yidong.vo.user.User;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserControl {
    @Autowired
    private UserServiceInf userServiceInf;
    @RequestMapping("registuser")
    public String registUser(HttpServletRequest req, User user){
        try {
            userServiceInf.regist(user);
            req.setAttribute("result", "注册成功");
        } catch (Exception e) {
            req.setAttribute("result", "注册失败");
        }

        return "jsps/user/regist";
    }
    @RequestMapping("updatepassword")
    public String updatepassword(HttpServletRequest req,User user){
        try{
            userServiceInf.updatepassword(user);
            req.setAttribute("msg", "修改成功");
        }catch(Exception e){
            req.setAttribute("msg", "修改失败");
        }


        return "jsps/user/pwd";
    }
}
