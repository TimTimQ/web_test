package Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "registerServlet")
public class registerServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String rePassword = req.getParameter("rePassword");
        String email = req.getParameter("email");
        String sex = req.getParameter("sex");
        String selectProvince = req.getParameter("selectProvince");
        String selectCity = req.getParameter("selectCity");
        String selectCounty = req.getParameter("selectCounty");
        String textareaPerson = req.getParameter("textareaPerson");

        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.print("<html>");
        writer.print("<head><title>注册信息获取界面</title>");
        writer.print("</head>");
        writer.print("<body style=mag>");

        String[] love = req.getParameterValues("love");
        String result = "";
        for (int i = 0; i < love.length; i++) {
            result += love[i]+" ";
        }

        writer.print(username + "的注册信息如下：<br><br>");
        writer.print("用户名：" + username + "<br>");
        writer.print("密码：" + password + "<br>");
        writer.print("确认密码：" + rePassword + "<br>");
        writer.print("邮箱：" + email + "<br>");
        writer.print("性别：" + sex + "<br>");
        writer.print("籍贯：" + selectProvince + " "+selectCity + " " + selectCounty +"<br>");
        writer.print("爱好：" + result + "<br>");
        writer.print("个人简介：" + textareaPerson + "<br>");

        writer.print("</body>");
        writer.print("</html>");

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
