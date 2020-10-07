package Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "cookieServlet")
public class cookieServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean cookieFound = false;
        Cookie myCookie = null;
        Cookie[] cookies = req.getCookies();

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();

        writer.print("<html>");
        writer.print("<head><title>cookie响应界面</title>");
        writer.print("</head>");
        writer.print("<body>");


        for (int i = 0; i < cookies.length; i++) {
            if (cookies[i].getName().equals(username)) {
                cookieFound = true;
                myCookie = cookies[i];
            }
        }


        if (cookieFound) {
            int temp = Integer.parseInt(myCookie.getValue());
            temp++;
            System.out.println(temp);
            writer.print("亲！这是你第" + String.valueOf(temp) + "次访问本网站！谢谢你的支持(＾Ｕ＾)ノ~ＹＯ");
            myCookie.setValue(String.valueOf(temp));
            myCookie.setMaxAge(60);     // 设置生命周期
            resp.addCookie(myCookie);
            if (temp == 3) {
                writer.print("<br>恭喜你连续登陆3次，祝贺祝贺！！");
            }
        }
        else {
            int temp = 1;
            writer.print("欢迎您~ 首次登陆本站！");
            myCookie = new Cookie(username, String.valueOf(temp));
            myCookie.setMaxAge(60);
            resp.addCookie(myCookie);
        }

        writer.print("</body>");
        writer.print("</html>");


    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
