package model;

public abstract class Doable {

    protected String description;
    protected boolean complete;

    public Doable(String description) {
        this.description = description;
        complete = false;
    }

    public boolean getStatus() { return complete; }


    public abstract String getDescription();
    public abstract void complete();
    public abstract void display(String indentSpace);
}
