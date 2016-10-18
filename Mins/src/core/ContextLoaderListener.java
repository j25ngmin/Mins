package core;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.commons.dbcp.BasicDataSource;

import dao.UserDAO;

/*AppInitServlet을 사용하지 않고 ContextLoaderListener를 사용하는 이유
AppInitServlet은 서블릿을 상속받는 우리의 편의성을 위한 일반 서블릿이다.
서블릿의 init, destory 메서드를 재정의해 좀 더 객체들을 효율적으로 사용하기 위해 만든 서블릿.
하지만, 톰캣에는 ServletContextListener라는 인터페이스가 존재한다.
웹 서버가 켜지거나 꺼질 때 알림을 해주는데 이 ServletContextListener 가 알림을 받는 아이다.
이미 있는 기능을 사용하는 것이 더 효율적!*/


@WebListener
public class ContextLoaderListener implements ServletContextListener {
  /*Connection conn;*/
  /* DBConnectionPool connPool;*/
	BasicDataSource ds;
  
  @Override
  public void contextInitialized(ServletContextEvent event) {
    try {
      ServletContext sc = event.getServletContext();

      //Class.forName(sc.getInitParameter("driver"));
      ds = new BasicDataSource();
      ds.setDriverClassName(sc.getInitParameter("driver"));
      ds.setUrl(sc.getInitParameter("url"));
      ds.setUsername(sc.getInitParameter("username"));
      ds.setPassword(sc.getInitParameter("password"));

      UserDAO userDAO = new UserDAO();
      userDAO.setDataSource(ds);

      sc.setAttribute("userDAO", userDAO);

    } catch(Throwable e) {
      e.printStackTrace();
    }
  }

  @Override
  public void contextDestroyed(ServletContextEvent event) {
    try {
    	connPool.closeAll();
    } catch (Exception e) {}
  }
}
