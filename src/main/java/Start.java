import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Start {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("appContext.xml");

        CourseDAO courseDAO = context.getBean(CourseDAO.class);
        System.out.println(courseDAO.findById(5));

        context.close();
    }
}
