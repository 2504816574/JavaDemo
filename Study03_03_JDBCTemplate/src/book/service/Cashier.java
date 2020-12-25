package book.service;

import java.util.List;

/**
 * @Auther Ashen One
 * @Date 2020/12/20
 */
public interface Cashier {
    void checkOut(String uid, List<String> bids);
}
