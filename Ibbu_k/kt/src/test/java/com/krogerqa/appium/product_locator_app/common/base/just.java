package com.krogerqa.appium.product_locator_app.common.base;

public class just {
    public static void main(String[] args) {


        int myNumber[] = new int[] { 1, 3, 4, 2, 3, 4, 5, 5, 6, 2, 3, 4, 5, 7, 8, 9 };

        for (int i = 0; i < myNumber.length; i++) {

            for (int j = i + 1; j < myNumber.length; j++) {

                if (myNumber[i] == myNumber[j])

                    System.out.println(myNumber[j]);

            }


        }

    }

}
