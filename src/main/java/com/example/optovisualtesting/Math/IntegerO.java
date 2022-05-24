package com.example.optovisualtesting.Math;

import com.example.optovisualtesting.Procedural.Listeners;

public class IntegerO {
    public int i;

    public SetO<Object> references_this;

    public IntegerO(int i) {
        this.i = i;
    }

    public Listeners<Integer> assign_i_listeners = new Listeners<>();
    public void assign_i(int i) {
        this.i = i;

        assign_i_listeners.runAll(i);
    }
}
