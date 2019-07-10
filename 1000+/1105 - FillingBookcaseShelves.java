/*
https://leetcode.com/problems/filling-bookcase-shelves/

We have a sequence of books: the i-th book has thickness books[i][0] and height books[i][1].
We want to place these books in order onto bookcase shelves that have total width shelf_width.
We choose some of the books to place on this shelf (such that the sum of their thickness is <= shelf_width),
then build another level of shelf of the bookcase so that the total height of the bookcase has increased
by the maximum height of the books we just put down. We repeat this process until there are no more books to place.

Note again that at each step of the above process, the order of the books we place is the same order
as the given sequence of books.  For example, if we have an ordered list of 5 books,
we might place the first and second book onto the first shelf, the third book on the second shelf,
and the fourth and fifth book on the last shelf.

Return the minimum possible height that the total bookshelf can be after placing shelves in this manner.

Example 1:
Input: books = [[1,1],[2,3],[2,3],[1,1],[1,1],[1,1],[1,2]], shelf_width = 4
Output: 6
Explanation:
1        -> w=1, h=1
2,3      -> w=4, h=3
4,5,6,7  -> w=4, h=2
The sum of the heights of the 3 shelves are 1 + 3 + 2 = 6.
Notice that book number 2 does not have to be on the first shelf.
*/

class Solution {
    public int minHeightShelves(int[][] books, int shelf_width) {
        int n = books.length;

        // dp[i] --> the min height after placing first i books
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            // Start by placing the current book in new shelf
            dp[i] = dp[i - 1] + books[i - 1][1];

            // Height and width of this new shelf
            int height = books[i - 1][1];
            int width = books[i - 1][0];

            // Now keep adding previous books one by one (until we reach the max width),
            // to find the best combination
            for (int j = i - 1; j > 0; j--) {
                width += books[j - 1][0];
                if (width > shelf_width) {
                    break;
                }

                height = Math.max(height, books[j - 1][1]);

                // Check if adding a previous book to this shelf reduces total height
                dp[i] = Math.min(dp[i], dp[j - 1] + height);
            }
        }

        return dp[n];
    }
}

/*
Hint:
https://leetcode.com/problems/filling-bookcase-shelves/discuss/323932
*/
