package my.first.servlet;

import my.first.model.ProductInfo;
import my.first.service.SearchService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SearchServlet", urlPatterns = "/search.do")
public class SearchServlet extends HttpServlet {

    private SearchService searchService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        searchService = new SearchService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Read input from HTTP request
        final String pname = req.getParameter("pname");
        // Handle input data with business service
        final List<ProductInfo> searchResult = searchService.search(pname);
        // Save output for view/UI (JSP)
        req.setAttribute("searchResult", searchResult);
        getServletContext().getRequestDispatcher("/jsp/searchResult.jsp")
                .forward(req, resp);
    }
}
