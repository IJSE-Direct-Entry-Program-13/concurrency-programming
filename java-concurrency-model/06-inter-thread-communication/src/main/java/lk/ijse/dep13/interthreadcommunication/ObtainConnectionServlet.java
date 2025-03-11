package lk.ijse.dep13.interthreadcommunication;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.ijse.dep13.interthreadcommunication.db.MontisoriCP;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "obtain-connection-servlet", urlPatterns = "/connections/random")
public class ObtainConnectionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MontisoriCP connectionPool = (MontisoriCP) getServletContext().getAttribute("datasource");
        MontisoriCP.ConnectionWrapper cWrapper = connectionPool.getConnection();

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.printf("<h1>Id: %s</h1>", cWrapper.id());
        out.printf("<h1>Connection Ref: %s</h1>", cWrapper.connection());
    }
}
