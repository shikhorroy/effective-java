package item61;

import java.util.Comparator;

/**
 * Item 61: Prefer primitive types to boxed primitives
 */
public class BoxedValueComparator {

    /**
     * While comparing two objects (here, two Integer objects) using '==' operator
     * is always an identity (i.e. reference values) comparison. So the value of
     * 'result' will always be '1' for same value of x and y Integer objects. If we
     * initialize x and y in a tricky manner then comparator should results correctly.
     * The tricky manner could be: Integer x = 20, y = 20;
     */
    private static void boxedValueComparison() {
        Integer x = new Integer(20);
        Integer y = new Integer(20);

        Comparator<Integer> naturalOrder = (i, j) -> (i < j) ? -1 : (i == j ? 0 : 1);
        int result = naturalOrder.compare(x, y);

        System.out.println(result);
    }

    private static void primitiveOverBoxed() {
        Integer x = new Integer(20);
        Integer y = new Integer(20);

        Comparator<Integer> naturalOrder = (i, j) -> {
            int k = i, l = j; // as values are un-boxed
            return (k < l) ? -1 : (k == l ? 0 : 1);// the == operator will compare two primitive types
//            return Integer.compare(k, l);// alternative solutions of above return statement
        };
        int result = naturalOrder.compare(x, y); // and the result will be 0

        System.out.println(result);
    }

    public static void main(String[] args) {
        boxedValueComparison();
        primitiveOverBoxed();
    }
}
