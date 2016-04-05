package com.courses.spalah;

import dao.CarDao;
import dao.DaoFactory;
import entity.CarEntity;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Ievgen Tararaka
 */
public class TestHttpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DaoFactory daoFactory = new DaoFactory();
        List<CarEntity> carList = null;
        try {
            Connection connection = daoFactory.getConnection();
            CarDao carDao = daoFactory.getCarDao(connection);
            carList = carDao.findAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for(CarEntity car : carList) {
            //response.getWriter().write("<html><body>GET response</body></html>");
            response.getWriter().write(car.toString());
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
