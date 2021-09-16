package entity;

// 管理员对象
public class Admin {
    // 管理员使用单例设计模式,仅有一名管理员
    private static final Admin admin = new Admin();

    private Admin() {
    }

    private static String id = "20210101000000001";
    private static String name = "admin";  // 管理员名
    private static String password = "123456"; // 密码

    public static Admin getAdmin() {
        return admin;
    }

    // 检验登录的账号密码是否正确
    public boolean check(String name, String password) {
        if (this.name.equals(name) && this.password.equals(password)) {
            return true;
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }
}
