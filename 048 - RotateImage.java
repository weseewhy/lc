/*
https://leetcode.com/problems/rotate-image/

You are given an n x n 2D matrix representing an image. Rotate the image by 90 degrees (clockwise).

Note:
You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
DO NOT allocate another 2D matrix and do the rotation.

Example 1:
[1,2,3]       [7,4,1],
[4,5,6]  -->  [8,5,2],
[7,8,9]       [9,6,3]

Example 2:
[ 5, 1, 9,11]        [ 5, 1, 9,11]
[ 2, 4, 8,10]  --->  [ 2, 4, 8,10]
[13, 3, 6, 7]        [13, 3, 6, 7]
[15,14,12,16]        [15,14,12,16]
*/

class Solution {
    public void rotate(int[][] matrix) {
        int maxLayers = matrix.length / 2;
        for (int layer = 0; layer < maxLayers; layer++) {
            rotateLayer(matrix, layer);
        }
    }

    private void rotateLayer(int[][] matrix, int layer) {
        int rowMin = layer;
        int colMin = layer;
        int rowMax = matrix.length - 1 - layer;
        int colMax = matrix.length - 1 - layer;

        if (rowMin >= rowMax) return;
        int maxOffset = rowMax - rowMin;

        for (int offset = 0; offset < maxOffset; offset++) {
            int temp = matrix[rowMin][colMin + offset];
            matrix[rowMin][colMin + offset] = matrix[rowMax - offset][colMin];
            matrix[rowMax - offset][colMin] = matrix[rowMax][colMax - offset];
            matrix[rowMax][colMax - offset] = matrix[rowMin + offset][colMax];
            matrix[rowMin + offset][colMax] = temp;
        }
    }
}


/*
https://leetcode.com/problems/rotate-image/discuss/18872

ALTERNATE APPROACH:
  - Reverse up to down
  - Swap the symmetry around diagonal

1 2 3     7 8 9     7 4 1
4 5 6  => 4 5 6  => 8 5 2
7 8 9     1 2 3     9 6 3

void rotate(vector<vector<int> > &matrix) {
    reverse(matrix.begin(), matrix.end());
    for (int i = 0; i < matrix.size(); ++i) {
        for (int j = i + 1; j < matrix[i].size(); ++j)
            swap(matrix[i][j], matrix[j][i]);
    }
}
*/
