package com.example.optovisualtesting;

import com.example.optovisualtesting.Expression.Difference;
import com.example.optovisualtesting.Expression.Expression;
import com.example.optovisualtesting.Expression.Product;
import com.example.optovisualtesting.Expression.Sum;

import java.util.function.Function;

public class H {
    public static <T> int findBest(T[] list, Function<T, Integer> evaluator, int initialBest) {
        int best = initialBest;
        for (T item : list) {
            int value = evaluator.apply(item);
            if (value < best) {
                best = value;
            }
        }
        return best;
    }

    public static <T> Function<Number, T> lerp(T a, T b) {
        return (Number t) -> sum(a, product(difference(b, a), t));
    }

    public static Expression sum(Expression... terms) {
        return new Sum(collection(terms));
    }

    public static Expression product(Expression... factors) {
        return new Product(new ArrayCollection<>(factors));
    }

    public static Expression difference(Expression minuend, Expression subtrahend) {
        return new Difference(minuend, subtrahend);
    }

    public static Collection collection() {
        return new Collection();
    }
}
