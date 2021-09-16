package service;

import entity.Admin;
import entity.Bill;
import entity.Product;
import entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    static Admin admin = Admin.getAdmin();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        new Main().init();
    }

    public void init() {
        while (true) {
            Shower.title("欢迎界面");
            Shower.show(Shower.initShow, admin, false);
            int select = getSelect();
            Shower.crossShow();
            if (select == 1) {
                Shower.title("登录系统");
                Shower.input("用户名");
                String name = scanner.next();
                Shower.input("密码");
                String password = scanner.next();
                if (admin.check(name, password)) {
                    mainMenu();
                } else {
                    Shower.crossShow();
                    Shower.tip("用户名或密码输入不正确");
                }
            } else if (select == 2) {
                break;
            } else {
                Shower.tip("无效选项");
            }
        }
        Shower.title("退出系统");
        Shower.tip("成功退出系统");
    }

    public void mainMenu() {
        while (true) {
            Shower.crossShow();
            Shower.title("主菜单");
            Shower.show(Shower.mainMenuShow, admin, true);
            int select = getSelect();
            Shower.crossShow();
            if (select == 1) {
                prodMenu();
            } else if (select == 2) {
                userMenu();
            } else if (select == 3) {
                checkOut();
            } else if (select == 4) {
                return;
            } else {
                Shower.tip("无效选项");
            }
        }
    }

    public void checkOut() {
        Shower.crossShow();
        Shower.headShow(admin, true);
        Shower.title("商品信息");
        Shower.tableShow(Comment.getProductList());
        List<Bill> bills = new ArrayList<>();
        int count = 1;
        while (true) {
            Shower.title("创建第 " + count + " 个订单");
            Shower.input("商品名称");
            String name = scanner.next();
            Product product = Comment.findProduct(name);
            if (product == null) {
                Shower.tip("无此商品信息,重新输入");
                continue;
            }
            Shower.input("商品数量");
            int num = getInt();
            if (num < 0) {
                Shower.tip("检测到无效数据");
                Shower.tip("生成数据失败,重新输入");
                continue;
            }
            if (num > product.getNum()) {
                Shower.tip("商品库存量不足,重新输入");
                continue;
            }
            Product newProd = new Product(name, num, product.getPrice());

            if (getQY("添加订单")) {
                Bill bill = new Bill(admin.getName(), name, num, product.getPrice());
                if (bills.add(bill)) {
                    Shower.tip("添加订单成功");
                    count++;
                } else {
                    Shower.tip("添加订单失败");
                }
            } else {
                Shower.tip("取消添加订单");
            }
            boolean flag = false;
            while (true) {
                Shower.input(" y 继续添加订单,输入 f 完成订单");
                String s = scanner.next();
                if (s.equalsIgnoreCase("y")) {
                    break;
                } else if (s.equalsIgnoreCase("f")) {
                    flag = true;
                    Shower.title("订单结账");
                    Shower.headShow(admin, true);
                    Shower.tableShow(bills);
                    break;
                } else {
                    Shower.tip("无效选项");
                }
            }
            if (flag) {
                break;
            }

        }
        addShow(bills);

    }

    public void userMenu() {
        while (true) {
            Shower.crossShow();
            Shower.title("会员管理");
            Shower.show(Shower.userMenuShow, admin, true);
            int select = getSelect();
            Shower.crossShow();
            if (select == 1) {
                Shower.title("添加会员");
                Shower.headShow(admin, true);
                Shower.input("会员姓名");
                String name = scanner.next();
                Shower.input("会员积分");
                int credit = getInt();
                Shower.input("会员电话");
                String phone = getPhone();
                System.out.println();
                Shower.tip("正在生成会员数据");

                if (credit < 0 || phone == null) {
                    Shower.tip("检测到无效数据");
                    Shower.tip("生成会员数据失败,自动返回上一级");
                    continue;
                }

                User user = new User(name, credit, phone);
                List<User> list = new ArrayList<>();
                list.add(user);
                Shower.tableShow(list);
                Shower.tip("即将录入会员数据");
                addShow(user);
            } else if (select == 2) {
                Shower.title("删除会员");
                Shower.headShow(admin, true);
                Shower.input("会员编号");
                String id = scanner.next();
                List<User> user = Comment.findUser(id);

                Shower.tableShow(user);
                delUserShow(user, id);
            } else if (select == 3) {
                Shower.title("显示所有会员");
                Shower.headShow(admin, true);
                Shower.tableShow(Comment.getUserList());
                if (getQ()) {
                    continue;
                }
            } else if (select == 4) {
                return;
            } else {
                Shower.tip("无效选项!");
            }
        }
    }

    public void prodMenu() {
        while (true) {
            Shower.crossShow();
            Shower.title("商品管理");
            Shower.show(Shower.prodMenuShow, admin, true);
            int select = getSelect();
            Shower.crossShow();
            if (select == 1) {
                Shower.title("添加商品");
                Shower.headShow(admin, true);
                Shower.input("商品名称");
                String name = scanner.next();
                Shower.input("商品数量");
                int num = getInt();
                Shower.input("商品单价");
                double price = getDouble();
                System.out.println();
                Shower.tip("正在生成商品数据");

                if (num < 0 || price < 0) {
                    Shower.tip("检测到无效数据");
                    Shower.tip("生成商品数据失败,自动返回上一级");
                    continue;
                }
                Product product = new Product(name, num, price);
                List<Product> list = new ArrayList<>();
                list.add(product);
                Shower.tableShow(list);
                Shower.tip("即将录入商品数据");

                if (addShow(product)) {
                    continue;
                }
            } else if (select == 2) {
                Shower.title("删除商品");
                Shower.headShow(admin, true);
                Shower.input("商品名称");
                String name = scanner.next();
                List<Product> prod = Comment.findProd(name);

                Shower.tableShow(prod);
                if (delProdShow(prod, name)) {
                    continue;
                }
            } else if (select == 3) {
                Shower.title("显示所有商品");
                Shower.headShow(admin, true);
                Shower.tableShow(Comment.getProductList());
                if (getQ()) {
                    continue;
                }
            } else if (select == 4) {
                return;
            } else {
                Shower.tip("无效选项!");
            }
        }
    }

    public static boolean delProdShow(List<Product> prod, String name) {
        if (!prod.isEmpty()) {
            if (getQY("删除")) {
                if (Comment.deleteProd(name)) {
                    Shower.tip("删除成功");
                } else {
                    Shower.tip("删除失败");
                }
            } else {
                Shower.tip("取消删除");
            }
        }
        getQ();
        return true;
    }

    public static boolean delUserShow(List<User> user, String id) {
        if (!user.isEmpty()) {
            if (getQY("删除")) {
                if (Comment.deleteUser(id)) {
                    Shower.tip("删除成功");
                } else {
                    Shower.tip("删除失败");
                }
            } else {
                Shower.tip("取消删除");
            }
        }
        getQ();
        return true;
    }

    public static boolean addShow(User user) {
        if (getQY("添加")) {
            if (Comment.add(user)) {
                Shower.tip("添加成功");
            } else {
                Shower.tip("添加失败");
            }
            getQ();
        } else {
            Shower.tip("取消添加");
        }
        return true;
    }

    public static boolean addShow(List<Bill> bills) {
        if (getQY("结账")) {
            if (Comment.add(bills)) {
                Shower.tip("结账成功");
            } else {
                Shower.tip("购物车无商品");
            }
            getQ();
        } else {
            Shower.tip("取消结账");
        }
        return true;
    }

    public static boolean addShow(Product product) {
        if (getQY("添加")) {
            if (Comment.add(product)) {
                Shower.tip("添加成功");
            } else {
                Shower.tip("添加失败");
            }
            getQ();
        } else {
            Shower.tip("取消添加");
        }
        return true;
    }

    public static String getPhone() {
        String regex = "\\d*";

        String in = scanner.next();
        try {
            if (!Pattern.matches(regex, in)) {
                return null;
            }
        } catch (Exception e) {
        }
        return in;
    }

    public static boolean getQ() {
        while (true) {
            Shower.input("q返回上一级");
            String s = scanner.next();
            if (s.equalsIgnoreCase("q")) {
                break;
            } else {
                Shower.tip("无效选项");
            }
        }
        return true;
    }

    public static boolean getQY(String message) {
        boolean flag = false;
        while (true) {
            Shower.input(" y 确认" + message + ",输入 q 返回上一级");
            String s = scanner.next();
            if (s.equalsIgnoreCase("y")) {
                flag = true;
                break;
            } else if (s.equalsIgnoreCase("q")) {
                break;
            } else {
                Shower.tip("无效选项");
            }
        }
        return flag;
    }

    public static double getDouble() {
        String s = scanner.next();
        double in = -1;
        try {
            in = Double.parseDouble(s);
        } catch (Exception e) {
        }
        return in;
    }

    public static int getInt() {
        String s = scanner.next();
        int in = -1;
        try {
            in = Integer.parseInt(s);
        } catch (Exception e) {
        }
        return in;
    }

    public static int getSelect() {
        String s = scanner.next();
        int select = -1;
        try {
            select = Integer.parseInt(s);
        } catch (Exception e) {
        }
        return select;
    }

}

