package com.example.optovisualtesting.Procedural;

import com.example.optovisualtesting.Procedural.Procedure;

import java.util.Set;

public class Listeners<Context> {
    Set<Procedure<Context>> procedurePaths;

    public void runAll(Context context) {
        for(Procedure<Context> procedure : procedurePaths) {
            procedure.run(context);
        }
    }

    public void add(Procedure<Context> procedure) {
        procedurePaths.add(procedure);
    }
}
