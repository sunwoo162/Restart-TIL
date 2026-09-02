package kr.gsm.minibank.domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
// 고객 - [번호 ,이름, 전화번호]....
public class Customer {
    private Long id; // int(0), Long(null)
    private String name;
    private String phone;
    // 고객(1) : 계좌(N)
    private List<Account> accountList=new ArrayList<>();

    public  void addAccount(Account account){
        this.accountList.add(account);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", accountList=" + accountList +
                '}';
    }

    public Customer(Long id, String name, String phone, List<Account> accountList) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.accountList = accountList;
    }
}
