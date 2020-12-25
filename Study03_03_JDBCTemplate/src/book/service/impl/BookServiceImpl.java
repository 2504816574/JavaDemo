package book.service.impl;

import book.dao.BookDao;
import book.exception.MyException;
import book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Auther Ashen One
 * @Date 2020/12/17
 */
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookDao bookDao;

    @Override
    public void buyBook(String bid, String uid) {
/*        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        Integer price = bookDao.selectPrice(bid);
        bookDao.updateSt(bid);
        bookDao.updateBalance(uid, price);
    
    }
}
