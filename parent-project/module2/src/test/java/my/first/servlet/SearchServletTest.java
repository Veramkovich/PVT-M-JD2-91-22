package my.first.servlet;

import lombok.SneakyThrows;
import my.first.service.SearchService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Collections;

import static org.mockito.Mockito.*;

public class SearchServletTest {

    SearchServlet targetObject;

    @Before
    public void setUp() throws Exception {
        targetObject = new SearchServlet();

        ServletConfig servletConfig = mock(ServletConfig.class);
        ServletContext servletContext = mock(ServletContext.class);
        RequestDispatcher requestDispatcher = mock(RequestDispatcher.class);
        SearchService searchService = mock(SearchService.class);

        when(servletConfig.getServletContext()).thenReturn(servletContext);
        when(servletContext.getRequestDispatcher(any())).thenReturn(requestDispatcher);
        when(searchService.search(any())).thenReturn(Collections.emptyList());

        targetObject.init(servletConfig);
        targetObject.setSearchService(searchService);
    }

    @After
    public void tearDown() {
        targetObject = null;
    }

    @Test
    @SneakyThrows
    public void doPost() {
        //Given
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        when(request.getParameter("pname")).thenReturn("test");

        //When
        targetObject.doPost(request, response);

        //Then
        verify(request, atLeast(1)).setAttribute(eq("searchResult"), any());

    }
}