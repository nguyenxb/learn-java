import com.nguyenxb.ba02.SomeService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest02 {
    @Test
    public void test02(){
        String config = "ba02/applicationContext.xml";

        ApplicationContext ac = new ClassPathXmlApplicationContext(config);

        SomeService proxy = (SomeService) ac.getBean("someService");
        String s = proxy.doOther("t002", 45);
        System.out.println(s);
    }
}
