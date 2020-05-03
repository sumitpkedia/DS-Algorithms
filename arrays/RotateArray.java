
public class RotateArray { 

    // considering string with small case letters 
    public static void rotateArray(int[][] arr) {
    
        // Corner cases - null check , length check
    
        int m = arr.length;
        int n = arr.length;

        int start = 0;
        int end = arr.length  - 1;

        System.out.println("=======");
        System.out.println(end);
        System.out.println("=======");

        /*
            0,0     0,1         0,2         0,3
            2       3           4           5
            1,0        1,1         1,2         1,3
            5       6           7           6
            2,0                             2,3
            8       9           1           12
            3,0                             3,3
            13                              

            */


        while(start < end) {

            for(int i = 0; i < end - start ; i++) {
                
                int temp = arr[start][start + i];
                arr[start][start + i] = arr[end-i][start];
                arr[end-i][start] = arr[end][end-i];
                arr[end][end-i] = arr[start+i][end];
                arr[start+i][end] = temp;
            }

            start++;
            end--;
        }
    }
    
    public static void main(String[] args) {

        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++) {
                System.out.println(arr[i][j]);
            }
        }

        System.err.println("Rotating.......");

        rotateArray(arr);

        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++) {
                System.out.println(arr[i][j]);
            }
        }
    }
    }
    