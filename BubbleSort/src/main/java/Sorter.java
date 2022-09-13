public class Sorter {
    public static int[] sort(int[] array) {

        boolean isSorted = false;

        while (!isSorted) {
            for (int i = 0; i < array.length-1; i++) {
                for (int j = 0; j < array.length-1; j++) {
                    if(array[j] > array[j+1]) {
                        int buffer = array[j];
                        array[j] = array[j+1];
                        array[j+1] = buffer;
                        break;
                    }
                }
            }
            isSorted=true;
        }
        return array;
    }
}
