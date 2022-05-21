package com.example.optovisualtesting.Constraint;

import com.example.optovisualtesting.Expression.Verification;
import com.example.optovisualtesting.Int;

import static com.example.optovisualtesting.Expression.Verification.toVerification;

public class DifferenceConstraint {
    public Int minuend;
    public Int subtrahend;
    public Int difference;

    Verification proposition() {
        return toVerification(minuend.i - subtrahend.i == difference.i);
    }

    class SetMinuendPotentialAction implements PotentialAction {
        int minuend;
    }

    ProcedurePaths<Integer> setMinuendProcedures;

    public void setMinuend(int minuend) {
        differenceConstraint.minuend = minuend;
        solveConstraints();

        setMinuendProcedures.run(minuend);
    }

    public PotentialAction constraintSolveActionOptions() {

    }

    public void setSubtrahend() {

    }
}
