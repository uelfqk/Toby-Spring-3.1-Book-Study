package study.tobyspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import study.tobyspring.dao.DaoFactory;
import study.tobyspring.dao.UserDao;

@SpringBootApplication
public class TobySpringApplication {

	private static ApplicationContext ap = new AnnotationConfigApplicationContext(DaoFactory.class);

	public static void main(String[] args) {
		SpringApplication.run(TobySpringApplication.class, args);

		UserDao userDao = ap.getBean("userDao", UserDao.class);



	}

}
