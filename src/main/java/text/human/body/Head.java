package text.human.body;

import text.human.Feeling;

public class Head extends BodyPart {
    protected Feeling feeling;
    private final Teeth teeth;
    private final Jaw jaw;

    public Head(String name) {
        super(name);
        teeth = new Teeth();
        jaw = new Jaw();
    }

    public Head() {
        teeth = new Teeth();
        jaw = new Jaw();
    }

    public Head(String name, boolean areTeethClean) {
        super(name);
        this.teeth = new Teeth(areTeethClean);
        jaw = new Jaw();

    }

    public Teeth getTeeth() {
        return teeth;
    }

    public Feeling getFeeling() {
        return feeling;
    }

    public void setFeeling(Feeling feeling) {
        this.feeling = feeling;
    }

    @Override
    public String toString() {
        if (name != null) {
            return "Head " + name + " with " + jaw + " and " + teeth + " that is feeling " + feeling;
        }
        return "Head with " + jaw + " and " + teeth + " that is feeling " + feeling;
    }

    public Jaw getJaw() {
        return jaw;
    }

    public void dropJaw() {
        jaw.drop();
    }
}
