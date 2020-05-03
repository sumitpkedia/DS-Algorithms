import java.awt.List;
import java.util.ArrayList;

public class ArrayPermutations {

    /*
     * 
     * {1, 2, 3}
     * 
     */
    public static void permuteArray(int[] arr, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> curPerms) {

        if (curPerms.size() == arr.length) {
            result.add(new ArrayList<>(curPerms));
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (curPerms.contains(arr[i])) {
                continue;
            }

            curPerms.add(arr[i]);
            permuteArray(arr, result, curPerms);
            curPerms.remove(curPerms.size() - 1);
        }
    }

    public static void permuteArrayUsingSwap(int[] arr, ArrayList<int[]> result, int index) {

        if (index == arr.length) {
            result.add(arr.clone());

            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i]);
                System.out.print("  ");
            }

            System.out.println("Next if....");
            return;
        }

        for (int i = index; i < arr.length; i++) {
            swap(arr, index, i);
            permuteArrayUsingSwap(arr, result, index + 1);
            swap(arr, index, i);
        }
    }

    public static void swap(int[] arr, int i, int j) {

        System.out.println("swapping....");
        System.out.print(arr[i]);
        System.out.print("   ");
        System.out.println(arr[j]);

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {

        int[] arr = { 1, 2, 3 };
        /*
         * ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
         * ArrayList<Integer> curPerms = new ArrayList<>(); permuteArray(arr, result,
         * curPerms); for (int i = 0; i < result.size(); i++) { for (int j = 0; j <
         * result.get(i).size(); j++) { System.out.print(result.get(i).get(j));
         * System.out.print("    "); } System.out.println("next permutations"); }
         */

        ArrayList<int[]> listOfPermsArrays = new ArrayList<int[]>();
        permuteArrayUsingSwap(arr, listOfPermsArrays, 0);
        for (int i = 0; i < listOfPermsArrays.size(); i++) {
            for (int j = 0; j < listOfPermsArrays.get(i).length; j++) {
                System.out.print(listOfPermsArrays.get(i)[j]);
                System.out.print("    ");
            }

            System.out.println("next permutations");
        }

    }
}
