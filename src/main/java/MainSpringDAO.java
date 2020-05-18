import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.easium.service.CourseService;

public class MainSpringDAO {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        CourseService courseService = context.getBean(CourseService.class);
        System.out.println(courseService.findAllCourses());
    }
}
