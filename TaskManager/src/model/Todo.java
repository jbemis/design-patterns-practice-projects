package model;

import java.util.LinkedList;
import java.util.List;


public class Todo extends Doable {

    private List<Doable> subs;

    public Todo(String description) {
        super(description);
        subs = new LinkedList<>();
    }

    // getters
    public List<Doable> getSubTasks() { return subs; }
    public String getDescription(){ return description; }

    public void complete() {
        boolean allComplete = true;
        for(Doable d : subs) {
            if (!d.getStatus()) {
                allComplete = false;
            }
        }
        complete = allComplete;
    }

    public boolean addDoable(Doable d){
        if (!subs.contains(d)){
            subs.add(d);
            return true;
        } else {
            return false;
        }
    }

    public boolean removeDoable(Doable d) {
        if (subs.contains(d)) {
            subs.remove(d);
            return true;
        } else {
            return true;
        }
    }

    public void display(String indentSpace) {
        System.out.println(indentSpace + getDescription());
        for (Doable d : subs) {
            d.display(indentSpace + indentSpace);
        }
    }


}