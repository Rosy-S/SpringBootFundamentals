package ttl.larku.jconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import ttl.larku.dao.BaseDAO;
import ttl.larku.dao.inmemory.InMemoryStudentDAO;
import ttl.larku.domain.Student;
import ttl.larku.service.StudentService;

@Configuration
@ComponentScan({"ttl.larku.service", "ttl.larku.dao"})
public class LarkUConfig {


//    <bean id="inMemoryStudentDAO" class="ttl.larku.dao.inmemory.InMemoryStudentDAO"/>
//
//    <bean id="studentService" class="ttl.larku.service.StudentService">
//        <property name="studentDAO" ref="inMemoryStudentDAO"/>
//    </bean>


    @Bean
    public StudentService studentService() {
        StudentService ss = new StudentService();
        ss.setStudentDAO(studentDAO());

        return ss;
    }


    @Bean
    public BaseDAO<Student> studentDAO() {
        return new InMemoryStudentDAO();
    }
}