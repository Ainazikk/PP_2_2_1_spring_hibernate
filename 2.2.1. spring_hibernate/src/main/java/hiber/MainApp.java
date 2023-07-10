package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context =
              new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      User user1 = new User("User1", "Lastname1", "user1@mail.ru");
      User user2 = new User("User2", "Lastname2", "user2@mail.ru");
      User user3 = new User("User3", "Lastname3", "user3@mail.ru");
      User user4 = new User("User4", "Lastname4", "user4@mail.ru");


      Car car1 = new Car("bmw", 228);
      Car car2 = new Car("lada", 123);
      Car car3 = new Car("mers", 542);
      Car car4 = new Car("alpharomeo", 245);


      user1.setCar(car1);
      user2.setCar(car3);
      user3.setCar(car4);
      user4.setCar(car2);


      userService.add(user1);
      userService.add(user2);
      userService.add(user3);
      userService.add(user4);


      System.out.println(userService.getUserbyCar(car2));

      context.close();
   }
}