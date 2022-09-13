import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] array = {1,8,2,3,9,13,4,1293,23,23,2313,231,3213,23123,232,23332,92838};
        Sorter.sort(array);
        System.out.println(Arrays.toString(array));
    }
}
