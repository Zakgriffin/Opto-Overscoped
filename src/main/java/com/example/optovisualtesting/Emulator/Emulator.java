package com.example.optovisualtesting.Emulator;

public class Emulator {
    int stackPointer;
    int instructionPointer;
    Register32[] registers = Arrays.fill(() -> new Register32());
    MemoryCell32[] memory = Arrays.fill(() -> new MemoryCell32());

    public static void executeProcedure() {

    }
}
