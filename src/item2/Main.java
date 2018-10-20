package item2;

/**
 * Item 2: Consider a builder when faced with many constructor parameters
 */
public class Main {
    public static void main(String[] args) {
        NutritionFacts cocaCola = new NutritionFacts.Builder(240, 80)
                .calories(100).sodium(35).carbohydrate(27).build();

        System.out.println(cocaCola);
    }
}
