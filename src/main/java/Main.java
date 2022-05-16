import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Integer[] intData = new Integer[]{1, 5, 2, 4, 3, 6};
        String[] strData = new String[]{"one", "five", "two", "four", "three", "six"};

        sort(strData, intData);

        System.out.println(Arrays.toString(strData));
    }

    private static <T> void swap(T[] array, int i, int j) {
        T element = array[i];
        array[i] = array[j];
        array[j] = element;
    }

    public static <T> SortData<T> sort(T[] data, Integer[] orderValues) {
        for (int i = 1; i < orderValues.length; i++)
            for (int j = i; j > 0 && orderValues[j - 1] > orderValues[j]; j--) {
                swap(orderValues, j - 1, j);
                swap(data, j - 1, j);
            }

        return new SortData<>(data, orderValues);
    }
}
