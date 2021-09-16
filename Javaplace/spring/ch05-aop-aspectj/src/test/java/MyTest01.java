import com.nguyenxb.ba01.SomeService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest01 {

    @Test
    public void test01(){
        String config="applicationContext.xml";
        // 获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        SomeService proxy = (SomeService) ac.getBean("someService");
        System.out.println("proxy=="+proxy.getClass().getName());//该类类型为com.sun.proxy.$Proxy8
        proxy.doSome("haha",12);
    }
}
