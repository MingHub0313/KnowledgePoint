package com.zmm.day0521.spring.ioc.servlet;

import com.zmm.day0521.spring.ioc.factory.BeanFactory;
import com.zmm.day0521.spring.ioc.pojo.Order;
import com.zmm.day0521.spring.ioc.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

/**
 * @Name OrderServlet
 * @Author 900045
 * @Created by 2020/5/21 0021
 */
@WebServlet(name = "orderServlet", urlPatterns = "/order")
public class OrderServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置请求体的字符编码
        req.setCharacterEncoding("UTF-8");
        String userId = req.getParameter("userId");
        String name = req.getParameter("name");

        Order order = new Order();
        order.setOrderId(UUID.randomUUID().toString());
        order.setUserId(userId);
        order.setName(name);
        try {
            OrderService orderService = (OrderService) BeanFactory.getBean("orderService");
            // 2. 调用service层方法
            orderService.order(order);
        } catch (Exception e) {
            e.printStackTrace();
        }
        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().print("下单成功");
    }
}
