package book.controller;

import book.service.BookService;
import book.service.Cashier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;

/**
 * @Auther Ashen One
 * @Date 2020/12/17
 */
@Controller
public class BookController {
    @Autowired
    BookService bookService;

    @Autowired
    Cashier cashier;

    public void buyBook() {
        bookService.buyBook("1", "1001");
    }

    public void checkOut() {
        ArrayList<String> bids = new ArrayList<>();
        bids.add("1");
        bids.add("2");
        cashier.checkOut("1001", bids);
    }

}
