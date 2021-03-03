package text.human.body;

public class Hand extends BodyPart {
    public Hand(String name) {
        super(name);
    }

    public Hand() {
    }

    @Override
    public String toString() {
        if (name != null) {
            return "Hand " + name;
        }
        return "Hand";
    }
}
