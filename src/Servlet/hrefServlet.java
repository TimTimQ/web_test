package Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "hrefServlet")
public class hrefServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // ctrl + alt + v  快速赋值本地变量
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.print("<html>");
        writer.print("<head><title>hrefServlet响应界面</title>");
        writer.print("</head>");
        writer.print("<body>");
        writer.print("<br>小写字母：");
        for (char c = 'a'; c <= 'z'; c++) {
            writer.print(" "+ c ) ;
        }
        writer.print("<br>大写字母：");
        for (char c ='A' ; c <= 'Z' ; c++){
            writer.print(" "+c);
        }

        writer.print("</body>");
        writer.print("</html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
