package com.nhnacademy.mart;

/**
 * Counter Class.
 */
public class Counter {

    public int pay(int customerMoney, int total) {

        int money = customerMoney - total;

        if (money < 0) {
            throw new IllegalArgumentException("고객님이 가진 돈을 초과하는 상품을 구매할 수 없습니다.");
        }

        System.out.println("총 가격은 " + total + "원 입니다.");
        System.out.println("고객님 결제 후 잔액 : " + money);
        return money;
    }

}
