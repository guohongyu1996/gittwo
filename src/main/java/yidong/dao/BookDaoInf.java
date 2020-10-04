package yidong.dao;

import org.apache.ibatis.annotations.Param;
import yidong.vo.PagePara;
import yidong.vo.admin.Book;

import java.util.List;

public interface BookDaoInf {

     public void insertBook(Book book);// 添加图书
     public Integer gjselectAllCount(Book book);// 查询出一共有多少条数据
     public List<Book> gjselectBook(@Param("book")Book book, @Param("pp") PagePara pp);// 查询出所有
     public Book selectOneBook(Book book);
     public Book getBookImg(Book book);
     public void updateBook(Book book);
     public void deleteBook(Book book);
     public Integer selectAllCount(Book book);
     public List<Book> selectBook(@Param("book")Book book,@Param("pp")PagePara pp);
}
