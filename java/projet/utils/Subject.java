package projet.utils;

import java.util.ArrayList;
import java.util.List;
/**
 * subject class, used for the different views
 *
 */
public abstract class Subject {
	/**
	 * observer list
	 */
    protected List<Observer> attached;
/**
 * constructor
 */
    public Subject() {
        attached = new ArrayList<>();
    }
/**
 *  attaches the current subject to a view
 * @param obs attached view
 */
    public void attach(Observer obs) {
        if (! attached.contains( obs)) {
            attached.add(obs);
        }
    }
/**
 * detaches the current subject from a view
 * @param obs attached view
 */
    public void detach(Observer obs) {
        if (attached.contains( obs)) {
            attached.remove(obs);
        }
    }
/**
 * notifies the observer from any modification
 */
    public void notifyObservers() {
        for (Observer o : attached) {
            o.update(this);
        }
    }

/**
 * notifies the observer from a given element
 * @param data the element
 */
    public void notifyObservers(Object data) {
        for (Observer o : attached) {
            o.update(this, data);
        }
    }

}
