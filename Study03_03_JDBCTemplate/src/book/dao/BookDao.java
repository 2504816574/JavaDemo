package book.dao;

/**
 * @Auther Ashen One
 * @Date 2020/12/17
 */
public interface BookDao {
    /**
     * 查询价格
     * @param bid
     * @return
     */
    Integer selectPrice(String bid);

    /**
     * 修改库存
     * @param bid
     */
    void updateSt(String bid);

    /**
     * 修改用户余额
     * @param uid
     * @param price
     */
    void updateBalance(String uid, Integer price);
}
