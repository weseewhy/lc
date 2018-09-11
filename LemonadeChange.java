/*
https://leetcode.com/problems/lemonade-change/

At a lemonade stand, each lemonade costs $5.
Customers are standing in a queue to buy from you, and order one at a time (in the order specified by bills).
Each customer will only buy one lemonade and pay with either a $5, $10, or $20 bill.
You must provide the correct change to each customer, so that the net transaction is that the customer pays $5.
Note that you don't have any change in hand at first.
Return true if and only if you can provide every customer with correct change.
 */

public class LemonadeChange {

    public boolean lemonadeChange(int[] bills) {
        int[] cashBox = new int[]{0, 0};

        for (int i = 0; i < bills.length; i++) {
            int curBill = bills[i];
            if (curBill == 5) {
                cashBox[0] += 1;
            } else if (curBill == 10) {
                if (cashBox[0] == 0) {
                    return false;
                } else {
                    cashBox[1] += 1;
                    cashBox[0] -= 1;
                }
            } else if (curBill == 20) {
                if (cashBox[1] >= 1 && cashBox[0] >= 1) {
                    cashBox[0] -= 1;
                    cashBox[1] -= 1;
                } else if (cashBox[0] >= 3) {
                    cashBox[0] -= 3;
                } else {
                    return false;
                }
            }
        }

        return true;
    }
}
