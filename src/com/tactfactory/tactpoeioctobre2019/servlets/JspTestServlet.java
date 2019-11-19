package com.tactfactory.tactpoeioctobre2019.servlets;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tactfactory.tactpoeioctobre2019.entites.User;

/**
 * Servlet implementation class JspTestServlet
 */
@WebServlet("/JspTestServlet")
public class JspTestServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        boolean x = false, y = false;

        // Get current session.
        System.out.println("************************************************************************************");
        HttpSession session = request.getSession();
        System.out.println("Session ID : " + session.getId());
        System.out.println("Max Age : " + session.getMaxInactiveInterval());
        System.out.println("KeySession : " + session.getAttribute("key_session"));

        // Get Cookie
        System.out.println("====================================================================================");
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                System.out.println("------------------------------------------------------------------------------------");
                System.out.println("Domain : " + cookie.getDomain());
                System.out.println("Max Age : " + cookie.getMaxAge());
                System.out.println("key : " + cookie.getName());
                System.out.println("Value : " + cookie.getValue());

                // Detect si cookie est valide
                if ("my_key".equals(cookie.getName())) {
                    x = true;
                }

                // Detect si cookie est valide
                if ("User".equals(cookie.getName())) {
                    y = true;
                }
            }
        } else {
            System.out.println("No cookie !!");
        }

        User user = new User();
        user.setFirstname("jean-michel");
        user.setLastname("el michou");
        user.setIsValidate(true);

        request.setAttribute("THE_USER", user);

        // Create and set cookie (to browser)
        if (!x) {
            Cookie cook = new Cookie("MY_KEY", "key_value1");
            cook.setMaxAge(4);
            response.addCookie(cook);
        }

        // Create and set cookie (to browser)
        if (!y) {
            Cookie cook = new Cookie("User", URLEncoder.encode(user.toJSON()));
            cook.setMaxAge(10);
            response.addCookie(cook);
        }

        // Add data to Session
        session.setAttribute("key_session", "data1");

        RequestDispatcher rd;
        rd = this.getServletContext().getNamedDispatcher("JspTest");
        rd.forward(request, response);
    }

}
