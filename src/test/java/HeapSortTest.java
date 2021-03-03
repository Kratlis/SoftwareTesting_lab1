import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class HeapSortTest {
    private static int[] arr;
    private static String correctArr;
    private static int[] arrWithNegative;
    private static String correctArrWithNegative;
    private static int[] arrWithSameNumbers;
    private static String correctArrWithSameNumbers;
    private static int[] arrWithOneNumber;
    private static String correctArrWithOneNumber;
    private static int[] arrEmpty;
    private static String correctArrEmpty;

    @BeforeAll
    static void setUp() {
        arr = new int[]{5, 6, 3, 8, 9, 2};
        correctArr = "S-H62-H61-L-R-H64-H60-L-H61-L-H63-H50-L-H51-L-R-H54-H40-L-H41-L-H43-H30-L-H31-H20-H10-H00";
        arrWithNegative = new int[]{4, 5, -3, 0, 3, 7};
        correctArrWithNegative = "S-H62-L-H65-H61-H60-L-R-H62-H50-L-H51-L-R-H54-H40-L-R-H42-H30-L-H31-H20-L-H21-H10-H00";
        arrWithSameNumbers = new int[]{2, 2, 2, 2};
        correctArrWithSameNumbers = "S-H41-H40-H30-H20-H10-H00";
        arrWithOneNumber = new int[]{6};
        correctArrWithOneNumber = "S-H00";
        arrEmpty = new int[]{};
        correctArrEmpty = "S";
    }

    @Test
    public void testArr() {
        HeapSort sorting = new HeapSort();
        sorting.sort(arr);
        Assertions.assertEquals(correctArr, sorting.getBuffer().toString());
    }

    @Test
    public void testArrWithNegative() {
        HeapSort sorting = new HeapSort();
        sorting.sort(arrWithNegative);
        Assertions.assertEquals(correctArrWithNegative, sorting.getBuffer().toString());
    }

    @Test
    public void testArrWithSameNumbers() {
        HeapSort sorting = new HeapSort();
        sorting.sort(arrWithSameNumbers);
        Assertions.assertEquals(correctArrWithSameNumbers, sorting.getBuffer().toString());
    }

    @Test
    public void testArrWithOneNumber() {
        HeapSort sorting = new HeapSort();
        sorting.sort(arrWithOneNumber);
        Assertions.assertEquals(correctArrWithOneNumber, sorting.getBuffer().toString());
    }

    @Test
    public void testArrEmpty() {
        HeapSort sorting = new HeapSort();
        sorting.sort(arrEmpty);
        Assertions.assertEquals(correctArrEmpty, sorting.getBuffer().toString());
    }
}
