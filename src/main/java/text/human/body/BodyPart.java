package text.human.body;

public class BodyPart {
    protected String name;

    public BodyPart() {
    }

    public BodyPart(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name != null ? name : "furniture";
    }
}
