package yidong.dao;

import yidong.vo.user.User;

public interface UserDaoInf {

    public User ajaxLoginName(User user);
    public void regist(User user);

    public User loginUser(User user);


    public User ajaxloginUserpassword(User user);

    public void updatepassword(User user);

    public void updatebalance(User user);

}
