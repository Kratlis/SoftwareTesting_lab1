package text.human.body;

public class Jaw extends BodyPart {
    private boolean isDropped = false;

    public void drop() {
        isDropped = true;
        System.out.println(this + " is dropped");
    }

    public void close() {
        isDropped = false;
        System.out.println(this + " is closed");
    }

    public boolean isDropped() {
        return isDropped;
    }

    @Override
    public String toString() {
        if (name != null) {
            return (isDropped ? "Dropped Jaw " + name : "Closed Jaw " + name);
        }
        return (isDropped ? "Dropped Jaw" : "Closed Jaw");
    }
}
