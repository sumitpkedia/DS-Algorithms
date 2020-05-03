
public class InsertionSort {

    public static void insertionSort(int[] arr) {

        /*
         * j i {2, 11, 9, 0, 3}
         * 
         * 
         */

        int key;
        int j;

        for (int i = 1; i < arr.length; i++) {

            j = i - 1;
            key = arr[i];
            int temp = i;

            while (j >= 0 && arr[j] > key) {

                arr[temp] = arr[j];
                temp--;
                j--;
            }

            if (temp != i) {
                arr[temp] = key;
            }
        }
    }

    public static void main(String[] args) {

        int[] arr = { 1, 2, 9, 0, 3 };

        insertionSort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}