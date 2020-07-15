/*
https://leetcode.com/problems/reformat-date/

Given a date string in the form Day Month Year, where:
Day is in the set {"1st", "2nd", "3rd", "4th", ..., "30th", "31st"}.
Month is in the set {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}.
Year is in the range [1900, 2100].
Convert the date string to the format YYYY-MM-DD, where:

Example 1:
Input: date = "20th Oct 2052"
Output: "2052-10-20"

Example 2:
Input: date = "6th Jun 1933"
Output: "1933-06-06"

Example 3:
Input: date = "26th May 1960"
Output: "1960-05-26"
*/

class Solution {
    public String reformatDate(String date) {
        String[] arr = date.split(" ");

        int day = Integer.parseInt(arr[0].substring(0, arr[0].length() - 2));
        int month = getMonth(arr[1]);
        int year = Integer.parseInt(arr[2]);

        return String.format("%d-%02d-%02d", year, month, day);
    }

    private int getMonth(String m) {
        switch (m) {
            case "Jan": return 1;
            case "Feb": return 2;
            case "Mar": return 3;
            case "Apr": return 4;
            case "May": return 5;
            case "Jun": return 6;
            case "Jul": return 7;
            case "Aug": return 8;
            case "Sep": return 9;
            case "Oct": return 10;
            case "Nov": return 11;
            case "Dec": return 12;
        }
        return 0;
    }
}
