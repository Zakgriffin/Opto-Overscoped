package com.example.optovisualtesting.Example.SimpleExpression;

import com.example.optovisualtesting.Expression.NumberExpression;
import com.example.optovisualtesting.Number;
import com.example.optovisualtesting.NumberVariable;
import com.example.optovisualtesting.Procedural.ControlFlow;
import com.example.optovisualtesting.Procedural.Mutable;

import static com.example.optovisualtesting.H.*;
import static com.example.optovisualtesting.JavaToHighLevel.P.*;
import static com.example.optovisualtesting.Procedural.Procedural.*;

public class SimpleExpression {
    // (20 + x) * 4
    // *(+(20, x), 4)

    NumberVariable x = new NumberVariable();
    NumberExpression simpleExpression = product(sum(number(20), x), number(4));

    record SimpleExpressionMutables(
            Mutable<Number> x,
            Mutable<Number> result,
            Mutable<Number> constant20,
            Mutable<Number> constant4
    ) {
    }

    Procedure<SimpleExpressionMutables> simpleExpressionProcedure = new Procedure<>(new ControlFlow(m ->
            doThen(copy(m.result, m.x),
                    doThen(add(m.x, m.constant20),
                            doThen(multiply(m.result, m.constant4))))
    ));

    record SimpleExpressionMachineMutables(
            Register<SizedNumber32> xAndResult,
            Register<SizedNumber32> constant20,
            Register<SizedNumber32> constant4
    ) {
    }

    MachineProcedure<SimpleExpressionMachineMutables> simpleExpressionMachineProcedure = new MachineProcedure<>(new FixedSizeOrderedCollection<Instruction>(
            I.set(m.constant20, sizedNumber32(20)),
            I.set(m.constant4, sizedNumber32(4)),
            I.add(m.x, m.constant20),
            I.multiply(m.result, m.constant4)
    ));

    emulator.execute(simpleExpressionMachineProcedure)
}
