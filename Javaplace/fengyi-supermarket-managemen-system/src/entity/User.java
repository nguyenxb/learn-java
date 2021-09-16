package entity;

import java.text.SimpleDateFormat;
import java.util.Date;

// 存放会员对象
public class User {
    private static int uid = 1;
    private String id;
    private String name;
    private int credit;
    private String phone;

    @Override
    public String toString() {
        return String.format("|%20s\t\t|%8s\t\t|%8s\t\t|%16s\t\t|", id, name, credit, phone);
    }

    public User(String name, int credit, String phone) {
        this.id = makeId();
        this.name = name;
        this.credit = credit;
        this.phone = phone;
    }

    public User() {
        this.id = makeId();
    }

    // 创建一个id ,
    private String makeId() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmm");
        String temp = String.valueOf(uid);
        uid++;
        // 如果 编号的长度不够5位数,在前面填 0,直到 够5位数
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 5 - temp.length(); i++) {
            stringBuilder.append("0");
        }
        stringBuilder.append(temp);
        return simpleDateFormat.format(new Date()) + stringBuilder.toString();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
