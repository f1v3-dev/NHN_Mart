package com.nhnacademy.mart;

import java.util.Scanner;
import java.util.StringTokenizer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * NHN Mart를 시작하는 클래스.
 */

public class NhnMartShell {
    private static final Logger log = LoggerFactory.getLogger(NhnMartShell.class);

    /**
     * NHN Mart의 main Method.
     */
    public static void main(String[] args) {
        NhnMart mart = new NhnMart();
        mart.prepareMart();

        BuyList buyList = inputBuyListFromShell();
        log.info("총 {}개의 항목이 추가되었습니다.", buyList.getItems().size());

        // 본인이름을 각자 맞게 영어로 변경
        log.info("새로운 Customer 객체를 생성합니다.");
        Customer seungJo = new Customer(buyList);

        // 장바구니를 챙긴다.
        log.info("Customer가 장바구니를 챙깁니다.");
        seungJo.bring(mart.provideBasket());

        // 식품을 담는다.
        log.info("Customer가 식품을 담습니다.");
        seungJo.pickFoods(mart.getFoodStand());

        // 카운터에서 계산한다.
        log.info("Customer가 담은 식품을 계산합니다.");
        seungJo.payTox(mart.getCounter());
    }

    private static BuyList inputBuyListFromShell() {
        
        Scanner sc = new Scanner(System.in);

        System.out.println("NHN 마트에 오신 것을 환영합니다. 사고 싶은 물건을 골라주세요. \n ");
        System.out.print("> ");

        BuyList buyList = new BuyList();

        // (양파 2) (계란 2) (파 4)
        StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");
        while (st.hasMoreTokens()) {
            String name = st.nextToken();
            int amount = Integer.parseInt(st.nextToken());
            buyList.add(new BuyList.Item(name, amount));
            log.info("구매 항목에 {}를 {}만큼 추가하였습니다..", name, amount);
        }

        return buyList;
    }
}
