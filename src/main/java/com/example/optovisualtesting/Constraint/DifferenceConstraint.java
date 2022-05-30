package com.example.optovisualtesting.Constraint;

import com.example.optovisualtesting.Math.Verification;
import com.example.optovisualtesting.Math.IntegerO;

import static com.example.optovisualtesting.Math.Verification.toVerification;

public class DifferenceConstraint {
    public IntegerO minuend;
    public IntegerO subtrahend;
    public IntegerO difference;

    Verification proposition() {
        return toVerification(minuend.i - subtrahend.i == difference.i);
    }

//    class SetMinuendPotentialAction implements PotentialAction {
//        int minuend;
//    }

//    ProcedurePaths<java.lang.Integer> setMinuendProcedures;

//    public void setMinuend(int minuend) {
//        differenceConstraint.minuend = minuend;
//        solveConstraints();
//
//        setMinuendProcedures.run(minuend);
//    }
//
//    public PotentialAction constraintSolveActionOptions() {
//
//    }

    public void setSubtrahend() {

    }
}
