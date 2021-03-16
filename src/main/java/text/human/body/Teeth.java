package text.human.body;

public class Teeth extends BodyPart {
    private Boolean isClean = true;
    private double dirty = 0;

    public Teeth(Boolean isClean) {
        if (!isClean) {
            dirty = Math.random() * 10;
        }
        this.isClean = isClean;
    }

    public Teeth() {
        isClean = true;
    }

    @Override
    public String toString() {
        return (isClean ? "Clean Teeth" : "Dirty Teeth");
    }

    public Boolean areClean() {
        return isClean;
    }

    public void setClean(Boolean clean) {
        isClean = clean;
        System.out.println(this + " are clean");
    }

    public double getDirty() {
        return dirty;
    }

    public void setDirty(double dirty) {
        this.dirty = dirty;
    }
}
