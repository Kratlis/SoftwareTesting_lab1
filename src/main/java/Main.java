import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arccos.arccos(1));
        System.out.println("------------");
//        System.out.println(Math.acos(0.76));

        int[] arrA = {2};
//        int[] arrA = {9, 10, 5, 3, 1, 2, 6};

        System.out.println("Original array is: " + Arrays.toString(arrA));
        HeapSort heapSort = new HeapSort();
        heapSort.sort(arrA);
        StringBuffer buffer = heapSort.getBuffer();
        System.out.println("Sorted array is (Heap Sort): " + Arrays.toString(arrA));
        System.out.println(buffer);
    }
}
