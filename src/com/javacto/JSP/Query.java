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
import java.util.List;

/**
 * WX742241103
 */

public class Query extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        PhoneService phoneService=new PhoneServiceImpl();
        List<Phone> list=phoneService.queryAll();
        req.setAttribute("sbqqq",list);
        req.getRequestDispatcher("user.jsp").forward(req,resp);
    }
}
