import org.junit.jupiter.api.*;
import text.human.Feeling;
import text.human.Person;
import text.human.TwoHeadedPerson;
import text.human.body.Hand;
import text.human.body.Head;
import text.human.body.Jaw;
import text.human.body.Teeth;
import text.things.Chair;
import text.things.ControlPanel;
import text.things.Furniture;
import text.things.Thing;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ModelTest {
    private static Person arthur;
    private static TwoHeadedPerson twoHeadedPerson;
    private static Chair chair;

    @BeforeAll
    public static void setUp() {
        arthur = new Person("Arthur", Feeling.NERVOUS);
        twoHeadedPerson = new TwoHeadedPerson();
        chair = new Chair();
        twoHeadedPerson.collapseInChair(chair);
        twoHeadedPerson.putFeet(new ControlPanel());
    }

    @Test
    @Order(1)
    public void testChair() {
        Assertions.assertEquals(twoHeadedPerson, chair.getOwner());
        arthur.collapseInChair(chair);
        Assertions.assertEquals(Feeling.DISPLEASED, arthur.getFeeling());
    }

    @Test
    @Order(2)
    public void testDirtyTeeth() {
        Head rightHead = twoHeadedPerson.getRightHead();
        Teeth teeth = rightHead.getTeeth();
        Assertions.assertEquals(false, teeth.areClean());
    }

    @Test
    @Order(3)
    public void testHeadsBeforeSmiling() {
        Head rightHead = twoHeadedPerson.getRightHead();
        Head leftHead = twoHeadedPerson.getLeftHead();
        twoHeadedPerson.pickInTeeth(twoHeadedPerson.getLeftHand(), twoHeadedPerson.getRightHead());
        Assertions.assertEquals(Feeling.CONCENTRATED, rightHead.getFeeling());
        Assertions.assertNull(leftHead.getFeeling());
    }

    @Test
    @Order(3)
    public void testHeadsAfterSmiling() {
        Head rightHead = twoHeadedPerson.getRightHead();
        Head leftHead = twoHeadedPerson.getLeftHead();
        twoHeadedPerson.smile(twoHeadedPerson.getLeftHead());
        Assertions.assertEquals(Feeling.HAPPY, leftHead.getFeeling());
    }

    @Test
    @Order(4)
    public void testArthurOverwhelmed() {
        arthur.surprise();
        Assertions.assertEquals(Feeling.OVERWHELMED, arthur.getFeeling());
    }

    @Test
    @Order(5)
    public void testThings10() {
        arthur.lookAround(10);
        Jaw jaw = arthur.getHead().getJaw();
        Assertions.assertTrue(jaw.isDropped());
    }

    @Test
    @Order(6)
    public void testThings20() {
        arthur.lookAround(20);
        Jaw jaw = arthur.getHead().getJaw();
        Assertions.assertTrue(jaw.isDropped());
    }

    @Test
    @Order(7)
    public void testThings5JawClosed() {
        arthur.lookAround(5);
        Jaw jaw = arthur.getHead().getJaw();
        Assertions.assertTrue(jaw.isDropped());
        jaw.close();
        Assertions.assertFalse(jaw.isDropped());
    }

    @Test
    @Order(8)
    public void testPersonSmile() {
        arthur.smile(arthur.getHead());
        Assertions.assertEquals(Feeling.HAPPY, arthur.getFeeling());
    }

    @Test
    public void testHand(){
        Hand hand = new Hand();
        Assertions.assertEquals("Hand", hand.toString());
    }

    @Test
    public void testHead(){
        Head head = new Head();
        Assertions.assertEquals("Head with Closed Jaw and Clean Teeth that is feeling null", head.toString());
    }

    @Test
    public void testFurniture(){
        Furniture furniture = new Furniture();
        Assertions.assertEquals("Furniture", furniture.toString());
    }

    @Test
    public void testThing(){
        Thing thing = new Thing();
        Assertions.assertEquals("Thing", thing.toString());
    }
}

