package yidong.biz;

import yidong.vo.user.User;

public interface UserServiceInf {

    public User ajaxLoginName(User user);

    public void regist(User user);

    public User loginUser(User user);

    public User ajaxLoginpassword(User user);

    public void updatepassword(User user);

    public void updateBalance(User user);
}
