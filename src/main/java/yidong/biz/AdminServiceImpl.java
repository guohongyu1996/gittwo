package yidong.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yidong.dao.AdminDaoInf;
import yidong.vo.admin.Admin;

@Service
public class AdminServiceImpl implements AdminServiceInf {
    @Autowired
    private AdminDaoInf adminDaoInf;

    @Override
    public Admin loginAdmin(Admin admin) {
        return adminDaoInf.loginAdmin(admin);
    }

    @Override
    public void updateAdminPwd(Admin admin) {
adminDaoInf.updateAdminPwd(admin);
    }
}
