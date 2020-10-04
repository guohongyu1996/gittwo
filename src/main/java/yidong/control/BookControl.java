package yidong.control;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import yidong.biz.BookServiceInf;
import yidong.biz.CategoryServiceInf;
import yidong.vo.PagePara;
import yidong.vo.admin.Book;
import yidong.vo.admin.Category;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class BookControl {


    @Autowired
    private BookServiceInf bookServiceInf;

    @Autowired
    private CategoryServiceInf categoryServiceInf;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yy-mm-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }
//    查询一级目录跳转到图书添加页面
    @RequestMapping("tiaoInsertBook")
    public String tiaoInsertBook(Model model){
        List<Category> list = categoryServiceInf.getCategory1list();
        model.addAttribute("categorylist",list);
        return "adminjsps/admin/book/add";
    }
//    根据一级目录用ajax查询出二级目录
   @RequestMapping("ajaxselectcatefory2")
   @ResponseBody
    public String ajaxselectcatefory2(HttpServletRequest request){
       String id = request.getParameter("id");
       Category category=new Category();
       category.setCid(Integer.parseInt(id));
       List<Category> category2list2 = categoryServiceInf.getCategory2list2(category);
       String json=JSON.toJSONString(category2list2);
       return json;
   }
//   添加图书
    @RequestMapping("insertBook")
    public  String insertBook(HttpServletRequest req, Book book,  @RequestParam MultipartFile image_W, @RequestParam MultipartFile image_B){
        try {
            book.setImage_B(image_B.getBytes());
            book.setImage_W(image_W.getBytes());

        } catch (IOException e) {

            e.printStackTrace();
        }


            bookServiceInf.insertBook(book);
            System.out.println("555");


        return "forward:/tiaoInsertBook";
    }
//    查询搜索分页
    @RequestMapping("gjselectbook")
    public String gjselectBook(HttpServletRequest req,Book book){
        String page=req.getParameter("page");
        PagePara pp=new PagePara();
        if(page!=null){
            pp.setCurrentPageNo(Integer.parseInt(page));
        }
        Integer allcount=bookServiceInf.gjselectAllCount(book);
        pp.setRecordAllCount(allcount);
        pp.setvalue();
        pp.setiEnd(pp.getiEnd()-1);
        req.setAttribute("pp", pp);
        List<Book> list=bookServiceInf.gjselectBook(book,pp);
        req.setAttribute("booklist", list);
        req.setAttribute("book", book);
        return "adminjsps/admin/book/gjlist";
    }
//    查询出book
@RequestMapping("selectonebook")
public String selectOneBook(HttpServletRequest req){
    String bid=req.getParameter("bid");
    Book book=new Book();
    book.setBid(Integer.parseInt(bid));
    Book b=bookServiceInf.selectOneBook(book);
    req.setAttribute("book", b);
    List<Category>  list=categoryServiceInf.getCategory1list();
    req.setAttribute("categorylist", list);
    return "adminjsps/admin/book/desc";
}
    @ResponseBody
    @RequestMapping("getbookimg")
    public byte[] getBookImg(HttpServletRequest req){
        String bid=req.getParameter("bid");
        Book book=new Book();
        book.setBid(Integer.parseInt(bid));
        return bookServiceInf.getBookImg(book);
    }
//    更新修改book
    @RequestMapping("updatebook")
    public String updateBook(HttpServletRequest req,Book book){
        String bid=req.getParameter("bid");
        book.setBid(Integer.parseInt(bid));
        Book b=bookServiceInf.selectOneBook(book);
        bookServiceInf.updateBook(book);
        return "forward:/selectbook?id"+b.getCid();
    }
    @RequestMapping("selectbook")
    public String selectBook(HttpServletRequest req){
        String id=req.getParameter("id");
        String page=req.getParameter("page");
        PagePara pp=new PagePara();
        if(page!=null){
            pp.setCurrentPageNo(Integer.parseInt(page));
        }
        Book book=new Book();
        book.setCid(Integer.parseInt(id));
        Integer allcount=bookServiceInf.selectAllCount(book);
        pp.setRecordAllCount(allcount);
        pp.setvalue();

        List<Book> booklist=bookServiceInf.selectBook(book, pp);
        req.setAttribute("pp", pp);
        req.setAttribute("booklist", booklist);
        req.setAttribute("cid", id);
        return "adminjsps/admin/book/list";
    }
    @ResponseBody
    @RequestMapping("getbookimgbig")
    public byte[] getBookImgBig(HttpServletRequest req){
        String bid=req.getParameter("bid");
        Book book=new Book();
        book.setBid(Integer.parseInt(bid));
        return bookServiceInf.getBookImgBig(book);
    }
//    删除
    @RequestMapping("deletebook")
    public String deleteBook(HttpServletRequest req){
        String bid=req.getParameter("bid");
        Book book=new Book();
        book.setBid(Integer.parseInt(bid));
        Book b=bookServiceInf.selectOneBook(book);
        bookServiceInf.deleteBook(book);
        return "forward:/selectbook?id="+b.getCid();
    }


}
