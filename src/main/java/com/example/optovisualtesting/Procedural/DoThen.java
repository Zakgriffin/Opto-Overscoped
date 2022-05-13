package com.example.optovisualtesting.Procedural;


public class DoThen implements ControlFlowAction {
    Effect effect;
    ControlFlowAction next;

    public DoThen(Effect effect, ControlFlowAction next) {
        this.effect = effect;
        this.next = next;
    }
}
