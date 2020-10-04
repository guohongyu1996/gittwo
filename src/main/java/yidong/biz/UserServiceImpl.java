package yidong.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yidong.dao.UserDaoInf;
import yidong.vo.user.User;
@Service
public class UserServiceImpl implements  UserServiceInf {
    @Autowired
    private UserDaoInf userDaoInf;
    @Override
    public User ajaxLoginName(User user) {
        return userDaoInf.ajaxLoginName(user);
    }

    @Override
    public void regist(User user) {
     userDaoInf.regist(user);
    }

    @Override
    public User loginUser(User user) {
        return userDaoInf.loginUser(user);
    }

    @Override
    public User ajaxLoginpassword(User user) {
        return userDaoInf.ajaxloginUserpassword(user);
    }

    @Override
    public void updatepassword(User user) {
userDaoInf.updatepassword(user);
    }

    @Override
    public void updateBalance(User user) {
userDaoInf.updatebalance(user);
    }
}
