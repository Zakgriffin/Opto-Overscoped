package com.example.optovisualtesting;

import com.example.optovisualtesting.Expression.Difference;
import com.example.optovisualtesting.Expression.NumberExpression;
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

    public static NumberExpression sum(NumberExpression... terms) {
        return new Sum(collection(terms));
    }

    public static NumberExpression product(NumberExpression... factors) {
        return new Product(new ArrayCollection<>(factors));
    }

    public static NumberExpression difference(NumberExpression minuend, NumberExpression subtrahend) {
        return new Difference(minuend, subtrahend);
    }

    public static Collection collection() {
        return new Collection();
    }

    public void x() {
        succesor(succesor(zero));
    }

    Zero zero = new Zero();

    public static Successor succesor(Number number) {
        return new Successor(Number number);
    }
}
