import java.util.Arrays;

public class BinarySearch {
    public static int binarySearch(int[] array, int valueToFind) {
        Arrays.sort(array);
        int low = 0;
        int high = array.length-1;
        int index = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (array[mid] < valueToFind) {
                low = mid + 1;
            } else if (array[mid] > valueToFind) {
                high = mid - 1;
            } else if (array[mid] == valueToFind) {
                index = mid;
                break;
            }
        }
        if (index == -1) {
            throw new RuntimeException("Такого значения в массиве нет");
        }
        return index;


    }
}
