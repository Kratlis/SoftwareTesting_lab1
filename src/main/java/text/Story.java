package text;

import text.human.Feeling;
import text.human.Person;
import text.human.TwoHeadedPerson;
import text.things.Chair;
import text.things.ControlPanel;

public class Story {
    public static void main(String[] args) {
        Person arthur = new Person("Arthur", Feeling.NERVOUS);
        TwoHeadedPerson twoHeadedPerson = new TwoHeadedPerson();
        twoHeadedPerson.collapseInChair(new Chair());
        twoHeadedPerson.putFeet(new ControlPanel());
        twoHeadedPerson.pickInTeeth(twoHeadedPerson.getLeftHand(), twoHeadedPerson.getRightHead());
        twoHeadedPerson.smile(twoHeadedPerson.getLeftHead());
        arthur.surprise();
        arthur.lookAround(10);
    }
}
