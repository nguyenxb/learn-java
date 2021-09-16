package service;

import entity.Bill;
import entity.Product;
import entity.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 一些公共的资源都存放在这里,比如数据资源,存放商品和会员的数据,以及对数据进行添加和删除,查找的方法
public class Comment {
    private static final List<User> userList;
    private static final List<Product> productList;
    private static List<Bill> billList = new ArrayList<>();

    // 初始化userList 与 productList
    static {
        List<User> userListTmp = Arrays.asList(
                new User("孙悟空", 12, "13937638261"),
                new User("郭德纲", 42, "13937638201"),
                new User("猪八戒", 79, "13737639261"),
                new User("林黛玉", 6, "13937838251")
        );
        userList = new ArrayList<>(userListTmp);

        List<Product> productListTmp = Arrays.asList(
                new Product("水杯", 28, 27.5),
                new Product("钢笔", 15, 8),
                new Product("牙刷", 35, 1),
                new Product("u盘", 5, 80),
                new Product("毛巾", 10, 2)
        );

        productList = new ArrayList<>(productListTmp);

    }

    public static List<Bill> getBillList() {
        return billList;
    }

    /**
     * @param list 订单列表
     * @return 是否成功
     */
    public static boolean add(List<Bill> list) {
        if (!list.isEmpty() && !productList.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                for (int j = 0; j < productList.size(); j++) {
                    if (productList.get(j).getName().equals(list.get(i).getProdName())) {
                        Bill bill = list.get(i);
                        Product product = productList.get(j);

                        product.setNum(product.getNum() - bill.getNum());
                        productList.set(j, product);
                    }
                }
            }
        }
        return billList.addAll(list);
    }

    /**
     * @param id 会员编号
     * @return 会员列表
     */
    public static List<User> findUser(String id) {
        ArrayList<User> list = new ArrayList<>();
        if (!userList.isEmpty()) {
            for (int i = 0; i < userList.size(); i++) {
                if (userList.get(i).getId().equals(id)) {
                    list.add(userList.get(i));
                }
            }
        }
        return list;
    }

    /**
     * @param name 商品名
     * @return 商品列表
     */
    // 查找商品
    public static List<Product> findProd(String name) {
        ArrayList<Product> list = new ArrayList<>();
        if (!productList.isEmpty()) {
            for (int i = 0; i < productList.size(); i++) {
                if (productList.get(i).getName().equals(name)) {
                    list.add(productList.get(i));
                }
            }
        }
        return list;
    }

    /**
     * @param name 商品名
     * @return 商品列表
     */
    // 查找商品
    public static Product findProduct(String name) {
        if (!productList.isEmpty()) {
            for (int i = 0; i < productList.size(); i++) {
                if (productList.get(i).getName().equals(name)) {
                    return productList.get(i);
                }
            }
        }
        return null;
    }

    /**
     * @return 会员列表
     */
    // 获取会员列表
    public static List<User> getUserList() {
        return userList;
    }

    /**
     * @return 商品列表
     */
    // 获取商品列表
    public static List<Product> getProductList() {
        return productList;
    }

    /**
     * @param user 会员对象
     * @return 是否添加成功
     */
    // 添加会员
    public static boolean add(User user) {
        return userList.add(user);
    }

    /**
     * @param product 商品对象
     * @return 是否成功
     */
    // 添加商品
    public static boolean add(Product product) {
        return productList.add(product);
    }

    /**
     * @param name 商品名
     * @return 是否成功
     */
    // 删除商品
    public static boolean deleteProd(String name) {
        if (!productList.isEmpty()) {
            for (int i = 0; i < productList.size(); i++) {
                if (productList.get(i).getName().equals(name)) {
                    productList.remove(i);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * @param id 会员编号
     * @return 是否成功
     */
    // 删除会员
    public static boolean deleteUser(String id) {
        if (!userList.isEmpty()) {
            for (int i = 0; i < userList.size(); i++) {
                if (userList.get(i).getId().equals(id)) {
                    userList.remove(i);
                    return true;
                }
            }
        }
        return false;
    }
}
