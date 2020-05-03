public class SetZerosinArray {

    public static void setZerosInArray(int[][] arr) {

            int[] row = new int[arr.length];
            int[] col = new int[arr[0].length];

            for(int i = 0; i < arr.length; i++) {
                for(int j =0; j < arr[i].length; j++) {
                    if(arr[i][j] == 0) {
                        row[i] = 1;
                        col[j] = 1;
                    }
                }
            }

            for (int i = 0; i < arr.length; i++) {
                for(int j = 0; j < arr[0].length; j++) {

                    if(row[i] == 1 || col[j] == 1) {
                        arr[i][j] = 0;
                    }
                }

            }

    }

    public static void main(String[] args) {

        int[][] arr = {{0,1,0}, {1,1,1}, {1,1,1}};

        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++) {
                System.out.println(arr[i][j]);
            }
        }

        System.out.println("============================");

        setZerosInArray(arr);

        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++) {
                System.out.println(arr[i][j]);
            }
        }
    }
}

