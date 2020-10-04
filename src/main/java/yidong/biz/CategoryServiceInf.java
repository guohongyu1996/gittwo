package yidong.biz;

import yidong.vo.admin.Category;

import java.util.List;

public interface CategoryServiceInf {
    public void insertCatefory1(Category category);//添加一级目录
    public void updateCatefory1(Category category);;//修改一级目录

    public void deleteCatefory1(Category category);//删除一级目录
    public List<Category> getCategory1list();//获取所有一级目录
    public Category getcategory1(Category category);//获取单个一级目录

    public void insertCatefory2(Category category);//添加二级目录
    public void updateCatefory2(Category category);//修改二级目录
    public void deleteCatefory2(Category category);//删除二级目录
    public List<Category> getCategory2list();//获取所有二级目录
    public Category getCategory2(Category category);//获取单个二级目录
    public List<Category> getCategory2list2(Category category);
}
