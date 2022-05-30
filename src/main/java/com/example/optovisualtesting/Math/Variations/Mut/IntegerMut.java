package com.example.optovisualtesting.Math.Variations.Mut;

import com.example.optovisualtesting.Math.IntegerO;
import com.example.optovisualtesting.Procedural.Listeners;

public class IntegerMut {
    IntegerO integer;

    public Listeners<Integer> assign_i_listeners = new Listeners<>();
    public void assign_i(int i) {
        integer.i = i;

        assign_i_listeners.runAll(i);
    }
}
