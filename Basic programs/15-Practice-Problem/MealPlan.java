interface MealPlan {}
class VegetarianMeal implements MealPlan {}
class VeganMeal implements MealPlan {}
class KetoMeal implements MealPlan {}

class Meal<T extends MealPlan> {
    T plan;
    Meal(T plan){this.plan=plan;}
}

public class Q15 {
    public static <T extends MealPlan> void generate(T plan){
        System.out.println(plan.getClass().getSimpleName());
    }

    public static void main(String[] args) {
        generate(new VegetarianMeal());
        generate(new VeganMeal());
    }
}