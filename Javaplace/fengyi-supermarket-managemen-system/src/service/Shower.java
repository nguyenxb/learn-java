package service;

import entity.Admin;
import entity.Bill;
import entity.Product;
import entity.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 一些界面的资源都存放在这个类中
public class Shower {
    // 初始登录界面
    public static List<String> initShow;
    // 主菜单界面
    public static List<String> mainMenuShow;
    // 商品菜单界面
    public static List<String> prodMenuShow;
    // 会员菜单界面
    public static List<String> userMenuShow;
    // 结账界面
    public static List<String> checkOutMenuShow;

    private static final String title = "\t\t\t欢迎使用丰翼超市管理系统";
    private static final String line = "* * * * * * * * * * * * * * * * * * * * * * * *";

    public static final String cross_line = "=======================================================";
    public static final String tip = "###: ";

    // 初始化界面集合
    static {
        // 开始界面
        initShow = Arrays.asList(
                "1 登录系统",
                "2 退出系统"
        );
        // 主菜单界面,
        mainMenuShow = Arrays.asList(
                "1 商品管理",
                "2 会员管理",
                "3 结账",
                "4 退出系统"
        );

        // 商品管理菜单界面
        prodMenuShow = Arrays.asList(
                "1 添加商品",
                "2 删除商品",
                "3 显示所有商品",
                "4 返回上一级"
        );
        // 会员管理菜单界面
        userMenuShow = Arrays.asList(
                "1 添加会员",
                "2 删除会员",
                "3 显示所有会员",
                "4 返回上一级"
        );
    }

    /**
     * @param list 数据列表
     */
//    显示数据表格
    public static void tableShow(List list) {
        if (list.isEmpty()) {
            System.out.println("+-----------------------------------+");
            System.out.println("|\t\t\t\t未找到数据\t\t\t|");
            System.out.println("+-----------------------------------+");
            return;
        }
        if (list.get(0) instanceof User) {
            List<User> userList = (List<User>) list;
            getTabLine(userList.get(0).toString(), '+');
            System.out.printf("|%5s\t\t|%12s\t\t\t\t|%8s\t\t|%8s\t\t|%12s\t\t\t|\n", "序号", "编号", "姓名", "积分", "电话");
            getTabLine(userList.get(0).toString(), '|');
            for (int i = 0; i < userList.size(); i++) {
                System.out.printf("|%5s\t\t%s\n", (i + 1), userList.get(i).toString());
            }
            getTabLine(userList.get(0).toString(), '+');
        } else if (list.get(0) instanceof Product) {
            List<Product> productList = (List<Product>) list;
            getTabLine(productList.get(0).toString(), '+');
            System.out.printf("|%5s\t\t|%8s\t\t|%8s\t\t|%8s\t\t|%8s\t\t|\n", "序号", "商品名称", "库存(件)", "单价(元/件)", "合计(元)");
            getTabLine(productList.get(0).toString(), '|');
            for (int i = 0; i < productList.size(); i++) {
                System.out.printf("|%5s\t\t%s\n", (i + 1), productList.get(i).toString());
            }
            getTabLine(productList.get(0).toString(), '+');
        } else if (list.get(0) instanceof Bill) {
            List<Bill> billList = (List<Bill>) list;
            getTabLine(billList.get(0).toString(), '+');
            System.out.printf("|%5s\t\t|%8s\t\t|%8s\t\t|%8s\t\t|%8s\t\t|%8s\t\t|\n", "序号", "消费者", "商品名称", "数量(件)", "单价(元/件)", "应收(元)");
            getTabLine(billList.get(0).toString(), '|');
            double sum = 0;
            for (int i = 0; i < billList.size(); i++) {
                System.out.printf("|%5s\t\t%s\n", (i + 1), billList.get(i).toString());
                sum += billList.get(i).getTotal();
            }
            getTabLine(billList.get(0).toString(), '+');
            System.out.printf("\t\t\t\t\t\t\t\t\t\t合计:%5s元\t\t\t\n", sum);
            getTabLine(billList.get(0).toString(), '|');
        }

    }

    /**
     * @param str 表格长度
     * @param ch  表格左右截断符号
     */
    private static void getTabLine(String str, char ch) {
        str = String.format("|%5s\t\t", "序号") + str;
        char[] chars = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 3; i < str.length() - 2; i++) {
            if (chars[i] == '\t') {
                for (int j = 0; j < 4; j++) {
                    sb.append("-");
                }
            } else {
                sb.append("-");
            }
        }
        System.out.println(ch + sb.toString() + ch);
    }

    /**
     * @param title 标题名字
     */
    public static void title(String title) {
        System.out.println("$" + title + "$");
    }

    /**
     * @param message 输入信息
     */
    public static void input(String message) {
        System.out.print("\t>>> 输入" + message + " : ");
    }

    /**
     * @param message 提示信息
     */
    public static void tip(String message) {
        System.out.println();
        System.out.println(Shower.tip + message + "...");
        System.out.println();
    }

    /**
     * 界面分割符号
     */
    public static void crossShow() {
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println(cross_line);
    }

    /**
     * 根据界面集合,来显示控制台的窗口图像
     *
     * @param showList 界面展示集合
     * @param admin    管理员对象
     * @param flag     是否显示管理员名
     */
    public static void show(List<String> showList, Admin admin, boolean flag) {
        headShow(admin, flag);
        for (String str : showList) {
            System.out.println("\t\t\t" + str);
        }
        footShow();
    }

    /**
     * 根据管理员对象,显示  "你好! 管理员名字"
     *
     * @param admin 管理员对象
     * @param flag  是否显示管理员名
     */
    public static void headShow(Admin admin, boolean flag) {
        if (flag) {
            System.out.println(title + "\t\t你好!" + admin.getName());
        } else {
            System.out.println(title);
        }
        System.out.println(line);
    }

    /**
     * 显示界面的底部
     */
    public static void footShow() {
        System.out.println(line);
        input("你的选择");
    }
}
