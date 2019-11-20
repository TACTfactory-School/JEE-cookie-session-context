package com.tactfactory.tactpoeioctobre2019.servlets;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class TestRequestListener
 *
 */
@WebListener
public class TestRequestListener implements ServletRequestListener {

    /**
     * Default constructor.
     */
    public TestRequestListener() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @see ServletRequestListener#requestDestroyed(ServletRequestEvent)
     */
    public void requestDestroyed(ServletRequestEvent sre)  {
        System.out.println("REQUEST DOWN !!!!!");
    }

    /**
     * @see ServletRequestListener#requestInitialized(ServletRequestEvent)
     */
    public void requestInitialized(ServletRequestEvent sre)  {
        System.out.println("REQUEST UP !!!!!");
    }

}
