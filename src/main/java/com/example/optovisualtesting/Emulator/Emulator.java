package com.example.optovisualtesting.Emulator;

import java.util.Arrays;

public class Emulator {
    Register32[] registers = new Register32[16];
    MemoryCell32[] memory = new MemoryCell32[1024];
    Register32 stackPointer = registers[15];

    public Emulator() {
        Arrays.setAll(registers, i -> new Register32());
        Arrays.setAll(memory, i -> new MemoryCell32());
    }

    public static void executeProcedure() {

    }
}
