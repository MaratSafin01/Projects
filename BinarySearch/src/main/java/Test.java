import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] array = {1,1,3,63,8,23,56,78};
        System.out.println(Arrays.toString(array));
        int valueToFind = 9;

        int index = BinarySearch.binarySearch(array, valueToFind);
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
        System.out.println(index);
    }
}
