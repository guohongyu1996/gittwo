package yidong.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import yidong.biz.CategoryServiceInf;
import yidong.util.CategoryList;
import yidong.vo.admin.Category;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class CategoryControl {

    @Autowired
    private CategoryServiceInf categoryServiceInf;
//    添加一级目录
    @RequestMapping("insertCatefory1")
    public  String insertCatefory1(Category category){
        categoryServiceInf.insertCatefory1(category);
        return "forward:/selectCateforylist";
    }
//    更新一级目录
    @RequestMapping("updateCatefory1")
    public String updateCatefory1(Category category){
        categoryServiceInf.updateCatefory1(category);
        return "forward:/selectCateforylist";
    }
//    删除一级目录
    @RequestMapping("deleteCatefory")
    public String deleteCatefory(HttpServletRequest req){
        String cid = req.getParameter("cid");
        Category category=new Category();
        category.setCid(Integer.parseInt(cid));
        categoryServiceInf.deleteCatefory1(category);
        System.out.println("111");
        return "forward:/selectCateforylist";
    }
//    查询所有
    @RequestMapping("selectCateforylist")
    public String selectCateforylist(Model model){
        List<Category> list1 = categoryServiceInf.getCategory1list();
        List<Category> list2 = categoryServiceInf.getCategory2list();
        List<Category> list = CategoryList.sort(list1, list2);
        model.addAttribute("cateforylist",list);
        return "adminjsps/admin/category/list";

    }
//    添加二级目录
    @RequestMapping("insertCatefory2")
    public  String insertCatefory2(Category category){
        categoryServiceInf.insertCatefory2(category);
        return "forward:/selectCateforylist";
    }
//  更新二级目录
@RequestMapping("updateCatefory2")
public String updateCatefory2(Category category){
    categoryServiceInf.updateCatefory2(category);
    return "forward:/selectCateforylist";
}
//删除二级目录
    @RequestMapping("deleteCatefory2")
    public String deleteCatefory2(HttpServletRequest req){
        String cid=req.getParameter("cid");
        Category category=new Category();
        category.setCid(Integer.parseInt(cid));
        categoryServiceInf.deleteCatefory2(category);
        return "forward:/selectCateforylist";
    }
//    查询出一级目录跳转到添加二级目录页面
    @RequestMapping("findAllBooktoadd2")
    public String findAllBooktoadd2(Model model,Category category){
        List<Category> category1list1 = categoryServiceInf.getCategory1list();

        model.addAttribute("category1list",category1list1);
        model.addAttribute("category",category);
        return "adminjsps/admin/category/add2";
    }
//    查询出一级目录跳转到修改页面
    @RequestMapping("findOneBookById")
    public  String  findOneBookById(Model model,Category category,HttpServletRequest request){

        Category category2 = categoryServiceInf.getcategory1(category);
        model.addAttribute("category2",category2);
        return "adminjsps/admin/category/edit";

    }
//    查询二级目录跳转到袖肥页面
    @RequestMapping("findOneBookById2")
public  String  findOneBookById2(Model model,Category category,HttpServletRequest request){
        Category category2 = categoryServiceInf.getCategory2(category);
        model.addAttribute("category2",category2);
        return "adminjsps/admin/category/edit2";
    }


}
