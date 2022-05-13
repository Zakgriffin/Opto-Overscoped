package com.example.optovisualtesting.Emulator;

public class Emulator {
    Register32[] registers = Arrays.fill(16, () -> new Register32());
    MemoryCell32[] memory = Arrays.fill(() -> new MemoryCell32());
    Register32 stackPointer = registers[15];

    public static void executeProcedure() {

    }
}
