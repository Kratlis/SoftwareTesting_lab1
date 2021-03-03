package text.human;

import text.human.body.Hand;
import text.human.body.Head;

public class OneHeadedPerson extends Person {
    private final Head head;

    public OneHeadedPerson(String name) {
        super(name);
        head = new Head();
        System.out.println("It is " + this);
    }

    @Override
    public String toString() {
        return "One-headed person" + (name != null ? " " + name : "");
    }

    void pickInTeeth(Hand hand) {
        super.pickInTeeth(hand, head);
    }

    void smile() {
        super.smile(head);
    }
}
