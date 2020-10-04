package yidong.dao;

import yidong.vo.admin.Admin;

public interface AdminDaoInf {
    public Admin loginAdmin(Admin admin);//管理员登陆
    public void updateAdminPwd(Admin admin);//修改管理员密码
}
