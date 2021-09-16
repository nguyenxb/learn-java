import service.Impl.SomeServiceImpl;
import service.SomeService;

public class Main {
    public static void main(String[] args) {
        SomeService someService = new SomeServiceImpl();
        someService.doSome();
        System.out.println("====================================");
        someService.doOther();
    }
}
