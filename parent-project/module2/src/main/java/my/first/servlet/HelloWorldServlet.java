package my.first.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HelloWorldServlet", urlPatterns = "/sayhello")
public class HelloWorldServlet extends HttpServlet {

    private static int counter = 0;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        counter++;
        final PrintWriter writer = resp.getWriter();
        writer.println("<h1>Say Hello</h1>");
        writer.println("<h2>Request Number: " + counter + "</h2>");
        final HttpSession session = req.getSession();
        writer.println("<h2>" + session.getId() + "</h2>");
        writer.println("<h2>" + req.getParameter("username") + "</h2>");
        resp.addHeader("username", req.getParameter("username"));
    }
}
