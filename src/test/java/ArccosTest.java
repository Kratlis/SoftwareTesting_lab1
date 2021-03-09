import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ArccosTest {
    //hashMap, key - correct result, value - test value
    private static final HashMap<Double, Double> testRightInsideValues = new HashMap<>();
    private static final HashMap<Double, Double> testCenterValues = new HashMap<>();
    private static final HashMap<Double, Double> testLeftInsideValues = new HashMap<>();
    private static final ArrayList<Double> testRightOutsideValues = new ArrayList<>();
    private static final ArrayList<Double> testLeftOutsideValues = new ArrayList<>();

    @BeforeEach
    void setUp() {
        //right side check
        testRightInsideValues.put(0d, 1.0);
        testRightInsideValues.put(0.66, 0.79);
        testRightInsideValues.put(1.0, 0.5403);

        // center check
        testCenterValues.put(1.57, 0.0008);
        testCenterValues.put(1.58, -0.0092);

        //left side check
        testLeftInsideValues.put(2.52, -0.813);
        testLeftInsideValues.put(1.9, -0.3233);
        testLeftInsideValues.put(Math.PI, -1.0);

        // outside the boundaries
        testRightOutsideValues.add(2.0);
        testRightOutsideValues.add(1.0001);

        testLeftOutsideValues.add(-1.0001);
        testLeftOutsideValues.add(-2.0);
    }

    @AfterEach
    public void tearDown() {
        testCenterValues.clear();
        testRightInsideValues.clear();
        testLeftInsideValues.clear();
        testRightOutsideValues.clear();
        testLeftOutsideValues.clear();
    }

    @Test
    public void testRightInside() {
        testRightInsideValues.forEach(
                (key, value) -> assertEquals(key, Arccos.arccos(value)));
    }

    @Test
    public void testCenter() {
        testCenterValues.forEach(
                (key, value) -> assertEquals(key, Arccos.arccos(value)));
    }

    @Test
    public void testLeftInside() {
        testLeftInsideValues.forEach(
                (key, value) -> assertEquals(key, Arccos.arccos(value)));
    }

    @Test
    public void testRightOutside() {
        testRightOutsideValues.forEach(
                (value) -> assertThrows(IllegalArgumentException.class,
                        () -> Arccos.arccos(value)));
    }

    @Test
    public void testLeftOutside() {
        testLeftOutsideValues.forEach(
                (value) -> assertThrows(IllegalArgumentException.class,
                        () -> Arccos.arccos(value)));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/arccosValues.csv", delimiter = ';')
    public void testFile(double expected, double x) {
        assertEquals(expected, Arccos.arccos(x));
    }


}
