package text.human;

import text.human.body.Hand;
import text.human.body.Head;
import text.human.body.Teeth;
import text.things.Chair;
import text.things.Furniture;
import text.things.Thing;

import java.util.ArrayList;

public class Person {
    private final Head head;
    protected String name;
    ArrayList<Thing> thingsAround;

    public Person() {
        head = new Head();
        thingsAround = new ArrayList<>();
        System.out.println("Here is a " + this);
    }

    public Head getHead() {
        return head;
    }

    public Person(String name, Feeling feeling) {
        this();
        this.name = name;
        System.out.println("It is " + this);
        setFeeling(feeling);
        thingsAround = new ArrayList<>();
    }

    public void collapseInChair(Chair chair) {
        if (chair.getOwner() != null) {
            System.out.println(this + " couldn't collapse in the chair " + chair);
            setFeeling(Feeling.DISPLEASED);
            return;
        }
        System.out.println(this + " collapsed in the chair " + chair);
        chair.setOwner(this);
        setFeeling(Feeling.RELAXED);
        System.out.println("Now the chair is " + chair);

    }

    @Override
    public String toString() {
        return "Person" + (name != null ? " " + name : "");
    }

    public void surprise() {
        setFeeling(Feeling.OVERWHELMED);
    }

    public void putFeet(Furniture furniture) {
        System.out.println("Feet of " + this + " are on the " + furniture);
    }

    public void smile(Head head) {
        setFeeling(Feeling.HAPPY);
    }

    public void lookAround(double sec) {
        System.out.println(this + " is looking around...");
        int coefficient = (int) Math.ceil(Math.random() * 5);
        while (sec >= 0) {
            // how long he examines one thing
            double examineTimeSec = Math.random() * coefficient;
            sec -= examineTimeSec;
            Thing newThing = new Thing();
            thingsAround.add(newThing);
        }
        System.out.println(this + " saw " + thingsAround.size() + " things");
        setFeeling(Feeling.TERRIFIED);
        dropJaw();
    }

    public Feeling getFeeling(){
        return head.getFeeling();
    }

    protected void setFeeling(Feeling feeling, Head head) {
        head.setFeeling(feeling);
        System.out.println(this + "'s " + head + " is " + head.getFeeling());
    }

    protected void setFeeling(Feeling feeling) {
        head.setFeeling(feeling);
        System.out.println(this + " is " + head.getFeeling());
    }

    protected void cleanTeeth(Teeth teeth) {
        while (!teeth.areClean()) {
            double dirty = teeth.getDirty();
            dirty -= Math.random();
            if (dirty <= 0) {
                teeth.setDirty(0);
                teeth.setClean(true);
            } else {
                teeth.setDirty(dirty);
            }
        }
    }

    protected void dropJaw() {
        System.out.println(this + " is dropping " + head.getJaw());
        head.dropJaw();
    }


}
