package model;

import java.util.Objects;


public class CardUserModel {
    private int id;
    private int money;
    private int password;
    private String name;
    private String surname;
    private String cardNumber;
    private String validUntil;
    private String currency;


    public void setCardUserData(int money, int password, String name, String surname, String cardNumber, String validUntil, String currency) {
        this.money = money;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.cardNumber = cardNumber;
        this.validUntil = validUntil;
        this.currency = currency;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(String validUntil) {
        this.validUntil = validUntil;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CardUserModel that = (CardUserModel) o;
        return id == that.id &&
                money == that.money &&
                Objects.equals(name, that.name) &&
                Objects.equals(surname, that.surname) &&
                Objects.equals(cardNumber, that.cardNumber) &&
                Objects.equals(validUntil, that.validUntil) &&
                Objects.equals(currency, that.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, money, name, surname, cardNumber, validUntil, currency);
    }

    @Override
    public String toString() {
        return "UserCardModel{" +
                "id=" + id +
                ", money=" + money +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", validUntil='" + validUntil + '\'' +
                ", currency='" + currency + '\'' +
                '}';
    }
}
