package book.service.impl;

import book.service.BookService;
import book.service.Cashier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Auther Ashen One
 * @Date 2020/12/20
 */
@Service
public class CashierImpl implements Cashier {
    @Autowired
    private BookService bookService;

    @Override
    public void checkOut(String uid, List<String> bids) {
        for (String bid : bids) {
            bookService.buyBook(bid, uid);
        }

    }
}
