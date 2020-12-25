package Demo01;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 *
 */
@WebServlet("/HelloWorld_Servlet")
public class HelloWorld_Servlet implements Servlet {
    private ServletConfig servletConfig;
    //初始化
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init");
        this.servletConfig=servletConfig;

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("service");

    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
