package Pr02Shop1Lv;

public class Customer {
    private String name;
    private int age;
    private double balance;

    public Customer(String name, int age, double balance) {
        setName(name);
        setAge(age);
        setBalance(balance);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.isEmpty() || name.equals(null)) {
            throw new IllegalArgumentException("Customer name cannot be empty or null.");
        }
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Customer age cannot be negative.");
        }
        this.age = age;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        String customerInfo = String.format("Customer: %s, age: %d, balance: %.2flv",
                getName(), getAge(), getBalance());
        return customerInfo;
    }
}
