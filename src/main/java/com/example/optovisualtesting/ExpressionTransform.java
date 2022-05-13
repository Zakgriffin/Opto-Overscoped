package com.example.optovisualtesting;

import com.example.optovisualtesting.Expression.NumberExpression;
import com.example.optovisualtesting.Expression.Sum;

public class ExpressionTransform {
    public void reduceNestedSum(Sum sum) {
        MutableCollection<NumberExpression> newTerms;
        for(NumberExpression expression : sum.terms) {
            if(expression instanceof Sum) {
                newTerms.add(reduceNestedSum(sum));
            } else {
                newTerms.add(expression);
            }
        }
        return new Sum(newTerms);
    }

    public void reduceNestedSumMutate(Sum sum) {
        Queue<Sum> s;
        s.add(sum);
        for(NumberExpression expression : sum.terms) {
            if(expression instanceof Sum) {
                s.add(expression);
                sum.terms.remove(expression);
            } else {
                sum.terms.add(expression);
            }
        }
    }

    public Sum reduceNestedSumCriteria(Sum sum) {
        // return a transform of sum where (A moved from oldPosition to sum.terms)
        // where A is term in nestedSumTerms(sum)

        Sum nestedSum = elementContainedBy(nestedSumTerms(sum));
        return transform(sum, moved(nestedSum, expressionsContaining(nestedSum), sum.terms));

//        return where(sum, () -> {
//            in(nestedTerms(sum), term -> if(term instanceof Sum) {move(term, existingLocation, sum.terms); });
//        });

//        return sum, where term in nestedTerms, if is sum, move term to terms
    }

    public void move(element, oldCollection, newCollection) {
        return proposition(
            notContains(oldCollection, element);
            contains(newCollection, element);
        );
    }


}
