package text.human;

import text.human.body.Hand;
import text.human.body.Head;

public class TwoHeadedPerson extends Person {
    private final Head rightHead;
    private final Head leftHead;
    private final Hand rightHand;
    private final Hand leftHand;

    public TwoHeadedPerson() {
        super();
        rightHead = new Head("right head", false);
        leftHead = new Head("left head");
        rightHand = new Hand("right hand");
        leftHand = new Hand("left hand");
        System.out.println("It is " + this);
    }

    @Override
    public String toString() {
        return "Two-headed person" + (name != null ? " " + name : "");
    }

    public Head getRightHead() {
        return rightHead;
    }

    public Head getLeftHead() {
        return leftHead;
    }

    public Hand getLeftHand() {
        return leftHand;
    }

    public void pickInTeeth(Hand hand, Head head) {
        setFeeling(Feeling.CONCENTRATED, head);
        System.out.println(this + " is picking with " + hand + " in the teeth of " + head);
        Thread thread = new Thread(() -> {
            if (!head.getTeeth().areClean()) {
                cleanTeeth(head.getTeeth());
            }
            System.out.println(this + " " + head + "'s  has " + head.getTeeth());
            setFeeling(Feeling.SATISFIED, head);
            System.out.println(this + " finished picking with " + hand + " in the teeth of " + head);
        });
        thread.start();
    }

    @Override
    public void smile(Head head) {
        head.setFeeling(Feeling.HAPPY);
        System.out.println(this + "'s " + head + " is smiling");
    }
}
