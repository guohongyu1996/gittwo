package yidong.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yidong.dao.CategoryDaoInf;
import yidong.vo.admin.Category;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryServiceInf{
    @Autowired
    private CategoryDaoInf categoryDaoInf;
    @Override
    public void insertCatefory1(Category category) {
        categoryDaoInf.insertCatefory1(category);
    }

    @Override
    public void updateCatefory1(Category category) {
        categoryDaoInf.updateCatefory1(category);
    }



    @Override
    public void deleteCatefory1(Category category) {
       categoryDaoInf.deleteCatefory1(category);
    }


    @Override
    public List<Category> getCategory1list() {
        return categoryDaoInf.getCategory1list();
    }

    @Override
    public Category getcategory1(Category category) {
        return categoryDaoInf.getcategory1(category);
    }

    @Override
    public void insertCatefory2(Category category) {
        categoryDaoInf.insertCatefory2(category);
    }

    @Override
    public void updateCatefory2(Category category) {
        categoryDaoInf.updateCatefory2(category);
    }

    @Override
    public void deleteCatefory2(Category category) {
        categoryDaoInf.deleteCatefory2(category);
    }

    @Override
    public List<Category> getCategory2list() {
        return categoryDaoInf.getCategory2list();
    }

    @Override
    public Category getCategory2(Category category) {
        return categoryDaoInf.getCategory2(category);
    }

    @Override
    public List<Category> getCategory2list2(Category category) {
        return categoryDaoInf.getCategory2list2(category);
    }
}
