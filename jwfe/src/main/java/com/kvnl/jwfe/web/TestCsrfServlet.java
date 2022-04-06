package com.kvnl.jwfe.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kvnl.jwfe.security.csrf.CsrfProtectionProvider;
import com.kvnl.jwfe.security.csrf.annotation.CsrfTag;
import com.kvnl.jwfe.security.csrf.annotation.RequestMethod;



@WebServlet(urlPatterns = "/testCsrf/*")
public class TestCsrfServlet extends HttpServlet {
	
    public TestCsrfServlet() {
        super();
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		doGetProcess(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		doPostProcess(request, response);
	}

	protected void doGetProcess(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		String path = request.getPathInfo();
		if (path.matches("/testGet1")) {
			testGet1(request,response);
		}
	}
	
	protected void doPostProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getPathInfo();
		if (path.matches("/testPost1")) {
			testPost1(request,response);
		}
	}
	
	private void testGet1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/TestCsrfPage.jsp").forward(request, response);
		return;
	}
	
	@CsrfTag(requestMethod = RequestMethod.POST, urlPattern = "/testCsrf/testPost1", key="test")
	private void testPost1(HttpServletRequest request, HttpServletResponse response) {
		
		String paramsName = CsrfProtectionProvider.getInstance().getReqParamsKeyCsrf();
		String message = request.getParameter(paramsName);
		
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer = null;
		try {
			writer = response.getWriter();
			writer.write(message);
			writer.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			writer.close();
		}
	}

}
