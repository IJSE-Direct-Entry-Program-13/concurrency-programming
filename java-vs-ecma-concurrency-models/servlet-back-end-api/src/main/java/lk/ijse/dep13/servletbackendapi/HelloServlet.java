package lk.ijse.dep13.servletbackendapi;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

@WebServlet(name = "hello-servlet", urlPatterns = "/")
public class HelloServlet extends HttpServlet {

    AtomicInteger counter = new AtomicInteger(0);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().printf("<h1>Hello %s</h1>",
                counter.getAndIncrement());
        if (counter.get() == 2){
            sleep(20000);
        }
    }

    private void sleep(int ms){
        final long t1 = System.currentTimeMillis();
        while (System.currentTimeMillis() - t1 < ms) ;
    }
}
