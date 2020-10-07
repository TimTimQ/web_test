package Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "myServlet")
public class myServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //response.getWriter().append("Served at: ").append(request.getContextPath());
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>servlet OK</title></head>");
        out.println("<body>我的天 Servlet</body>");
        out.println("</html>");
    }

    @Override
    public void init() throws ServletException {
        super.init();
    }

    public void service(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.setContentType("text/html;charset=GB2312");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        String length = request.getParameter("length");  //获取客户提交的信息
        String width = request.getParameter("width");
        double area = 0;
        try {
            double length1 = Double.parseDouble(length);
            double width1 = Double.parseDouble(width);
            if (length1 >= 0 && width1 >= 0) {
                out.print("<BR>长是 " + length1 + " ；宽是 " + width1 + "  的矩形面积：");
                out.print(length1 * width1);
            } else {
                out.print("<BR>矩形的长或宽不可以是负数!!");
            }
        } catch (NumberFormatException e) {
            out.print("<H1>请输入数字字符! </H1>");
        }
        out.println("</body></html>");
    }

}
