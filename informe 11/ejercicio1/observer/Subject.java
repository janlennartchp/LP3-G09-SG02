package observer;
import java.util.*;
public class Subject {
    private List<Observer> observers = new ArrayList<>();
    public void attach(Observer o){ observers.add(o);}
    public void detach(Observer o){ observers.remove(o);}
    public void notifyObservers(String m){ for(Observer o:observers)o.update(m);}
}