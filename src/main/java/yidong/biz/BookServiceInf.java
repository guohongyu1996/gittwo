package yidong.biz;

import org.apache.ibatis.annotations.Param;
import yidong.vo.PagePara;
import yidong.vo.admin.Book;

import java.util.List;

public interface BookServiceInf {

    public void insertBook(Book book);// 添加图书
    public Integer gjselectAllCount(Book book);
    public List<Book> gjselectBook(@Param("book")Book book, @Param("pp") PagePara pp);
    public Book selectOneBook(Book book);
    public byte[] getBookImg(Book book);
    public void updateBook(Book book);
    public void deleteBook(Book book);
    public Integer selectAllCount(Book book);
    public List<Book> selectBook(@Param("book")Book book,@Param("pp")PagePara pp);
    public byte[] getBookImgBig(Book book);
}
