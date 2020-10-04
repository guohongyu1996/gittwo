package yidong.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yidong.dao.BookDaoInf;
import yidong.vo.PagePara;
import yidong.vo.admin.Book;

import java.util.List;

@Service
public class BookServiceImpl implements BookServiceInf{
@Autowired
private BookDaoInf bookDaoInf;

    @Override
    public void insertBook(Book book) {
        bookDaoInf.insertBook(book);
    }

    @Override
    public Integer gjselectAllCount(Book book) {
        return bookDaoInf.gjselectAllCount(book);
    }

    @Override
    public List<Book> gjselectBook(Book book, PagePara pp) {
        return bookDaoInf.gjselectBook(book,pp);
    }

    @Override
    public Book selectOneBook(Book book) {
        return bookDaoInf.selectOneBook(book);
    }

    @Override
    public byte[] getBookImg(Book book) {
        Book b = bookDaoInf.getBookImg(book);
        return b.getImage_B();
    }

    @Override
    public void updateBook(Book book) {
        bookDaoInf.updateBook(book);
    }

    @Override
    public void deleteBook(Book book) {
   bookDaoInf.deleteBook(book);
    }

    @Override
    public Integer selectAllCount(Book book) {
        return bookDaoInf.selectAllCount(book);
    }

    @Override
    public List<Book> selectBook(Book book, PagePara pp) {
        return bookDaoInf.selectBook(book,pp);
    }

    @Override
    public byte[] getBookImgBig(Book book) {
        Book b = bookDaoInf.getBookImg(book);
        return b.getImage_B();
    }
}
