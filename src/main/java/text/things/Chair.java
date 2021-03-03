package text.things;

import text.human.Person;

public class Chair extends Furniture{
    private Person owner = null;

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        if (owner != null){
            return "Chair in which "+owner+" sits";
        }
        return "Chair that is empty";
    }
}
