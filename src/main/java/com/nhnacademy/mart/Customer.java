package com.nhnacademy.mart;

import java.util.ArrayList;

/**
 * Customer Class.
 */
public class Customer {

    // 고객 구매 목록
    private final BuyList buyList;

    // 고객 장바구니
    private Basket basket;

    private int customerMoney;

    public Customer(BuyList buyList) {
        this.buyList = buyList;
        this.customerMoney = 20_000;
    }


    public int getCustomerMoney() {
        return customerMoney;
    }

    public BuyList getBuyList() {
        return buyList;
    }

    public Basket getBasket() {
        return basket;
    }

    public void setCustomerMoney(int customerMoney) {
        this.customerMoney = customerMoney;
    }

    // 장바구니 챙기기
    public void bring(Basket basket) {
        this.basket = basket;
    }

    /**
     * 고객의 바구니에 넣고 상품을 지우는 방식을 사용.
     */
    public void pickFoods(FoodStand foodStand) {
        ArrayList<BuyList.Item> items = buyList.getItems();
        for (BuyList.Item item : items) {
            for (int i = 0; i < item.getAmount(); i++) {
                basket.add(foodStand.remove(item.getName()));
            }
        }
    }

    public void payTox(Counter counter) {
        ArrayList<Food> foods = basket.getFoods();

        int total = 0;
        for (Food food : foods) {
            total += food.getPrice();
        }
        setCustomerMoney(counter.pay(getCustomerMoney(), total));

    }
}
