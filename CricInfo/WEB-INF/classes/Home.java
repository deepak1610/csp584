import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.*;
@WebServlet("/Home")

/*
	Home class uses the printHtml Function of Utilities class and prints the Header,LeftNavigationBar,
	Content,Footer of CricInfo Application.

*/

public class Home extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();

		Utilities utility = new Utilities(request,pw);
		utility.printHtml("Header.html");
		utility.printHtml("LeftNavigationBar.html");
		
		RequestDispatcher rd=request.getRequestDispatcher("DealMatchesUtilities");
		rd.include(request,response);

		RequestDispatcher rd1=request.getRequestDispatcher("DealMatches");
rd1.include(request,response);
		utility.printHtml("Content.html");
		utility.printHtml("Footer.html");

	}

}
