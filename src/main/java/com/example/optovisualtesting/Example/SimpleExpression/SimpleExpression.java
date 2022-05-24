package com.example.optovisualtesting.Example.SimpleExpression;

import com.example.optovisualtesting.Math.NumberExpression;

import static com.example.optovisualtesting.H.*;
import static com.example.optovisualtesting.JavaToHighLevel.P.*;

public class SimpleExpression {
    // (20 + x) * 4
    // *(+(20, x), 4)

    public static void doStuff() {
        NumberVariable x = new NumberVariable();
        NumberExpression simpleExpression = product(sum(number(20), x), number(4));


//        ExpressionBuilder builder = new ExpressionBuilder();
//        builder.setRoot(new Product());
//        builder.sethjygf(p, Product.FACTORS, product_X_20);
//        Product p = new Product();
//        p.
//
//
//        simpleExpression);
    }

//    Procedure<SimpleExpressionMutables> simpleExpressionProcedure = expressionToProcedure(simpleExpression);

//    record SimpleExpressionMutables(
//            Mutable<Number> x,
//            Mutable<Number> result,
//            Mutable<Number> constant20,
//            Mutable<Number> constant4
//    ) {
//    }

//    Procedure<SimpleExpressionMutables> simpleExpressionProcedureSHOULD = new Procedure<>(new ControlFlow(m ->
//            doThen(copy(m.result, m.x),
//                    doThen(add(m.result, m.constant20),
//                            doThen(multiply(m.result, m.constant4))))
//    ));
//
//    record SimpleExpressionMachineMutables(
//            Register32 xAndResult,
//            Register32 constant20,
//            Register32 constant4
//    ) {
//    }
//
//    MachineProcedure<SimpleExpressionMachineMutables> simpleExpressionMachineProcedure = new MachineProcedure<>(new FixedSizeOrderedCollection<Instruction>(
//            I.set(m.constant20, sizedNumber32(20)),
//            I.set(m.constant4, sizedNumber32(4)),
//            I.add(m.x, m.constant20),
//            I.multiply(m.result, m.constant4)
//    ));
}
