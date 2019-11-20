package com.tactfactory.tactpoeioctobre2019.servlets;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
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
@WebServlet(name = "JSPTestServlet", urlPatterns = { "/JspTestServlet" })
public class JspTestServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        boolean x = false, y = false;

        // Get Server Context
        ServletContext application = this.getServletContext();

        Integer count = (Integer) application.getAttribute("counter");
        if (count != null) {
//            System.out.println("COUNT : " + ++count);
        } else {
            count = Integer.parseInt(application.getInitParameter("counter"));
        }
        application.setAttribute("counter", count);


        // Get current session.
//        System.out.println("************************************************************************************");
        HttpSession session = request.getSession();
//        System.out.println("Session ID : " + session.getId());
//        System.out.println("Max Age : " + session.getMaxInactiveInterval());
//        System.out.println("KeySession : " + session.getAttribute("key_session"));

        User sessionUser = (User)session.getAttribute("user_session");
        if (sessionUser != null) {
//            System.out.println("User : " + sessionUser.displayName());
        }

        // Get Cookie
//        System.out.println("====================================================================================");
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
//                System.out.println("------------------------------------------------------------------------------------");
//                System.out.println("Domain : " + cookie.getDomain());
//                System.out.println("Max Age : " + cookie.getMaxAge());
//                System.out.println("key : " + cookie.getName());
//                System.out.println("Value : " + cookie.getValue());

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

        // Create Data
        User user = new User();
        user.setFirstname("jean-michel");
        user.setLastname("el michou");
        user.setIsValidate(true);

        // Create and set parameter
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

        // Add data to Session
        session.setAttribute("user_session", user);

        // Destroy session (logout style)
        session.invalidate();

        // Return JSP
        RequestDispatcher rd;
        rd = this.getServletContext().getNamedDispatcher("JspTest");
        rd.forward(request, response);
    }

}
