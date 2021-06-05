package com.javacto.JSP;

import com.javacto.Service.PhoneService;
import com.javacto.Service.PhoneServiceImpl;
import com.javacto.po.Phone;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * WX742241103
 */
@WebServlet("/do.dd")
public class LoginAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        String usename=req.getParameter("usename");
        String pwsname=req.getParameter("pwsname");

        PhoneService phoneService=new PhoneServiceImpl();
        Phone phone=phoneService.login(usename,pwsname);
        if (null!=phone){
            System.out.println("登录成功");
            req.getRequestDispatcher("/query.cc").forward(req,resp);

        }else {
            System.out.println("登录失败");
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }
    }
}
