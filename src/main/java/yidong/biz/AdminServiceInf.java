package yidong.biz;

import yidong.vo.admin.Admin;

public interface AdminServiceInf {
    public Admin loginAdmin(Admin admin);
    public void updateAdminPwd(Admin admin);
}
