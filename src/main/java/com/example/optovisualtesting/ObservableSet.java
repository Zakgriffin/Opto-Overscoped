package com.example.optovisualtesting;

import java.util.*;

public class ObservableSet<Item> {
    Set<Item> set;

    Set<Listener<Item>> addListeners;
    Set<Listener<Item>> removeListeners;

    public ObservableSet(Set<Item> set) {
        this.set = set;
        this.addListeners = new HashSet<>();
        this.removeListeners = new HashSet<>();
    }

    public void add(Item item) {
        set.add(item);
        addListeners.forEach(listener -> listener.listen(item));
    }

    public void remove(Item item) {
        set.remove(item);
        removeListeners.forEach(listener -> listener.listen(item));
    }

    public void addAddListener(Listener<Item> listener) {
        addListeners.add(listener);
    }

    public void addRemoveListener(Listener<Item> listener) {
        removeListeners.add(listener);
    }
}
