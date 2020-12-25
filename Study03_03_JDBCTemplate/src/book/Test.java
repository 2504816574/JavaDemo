package book;

import book.controller.BookController;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Auther Ashen One
 * @Date 2020/12/18
 */
public class Test {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("book.xml");
        BookController bookController = classPathXmlApplicationContext.getBean("bookController", BookController.class);
        bookController.buyBook();
        // bookController.checkOut();



    }
}
