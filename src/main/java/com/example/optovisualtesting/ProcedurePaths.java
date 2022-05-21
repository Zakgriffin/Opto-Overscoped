package com.example.optovisualtesting;

import java.util.Set;

public class ProcedurePaths<Context> {
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
