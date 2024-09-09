package CO1_Project_1;

public abstract class Coffee {
    String name;
    String ingredients;

    public String getName() {
        return name;
    }

    public String getIngredients() {
        return ingredients;
    }

    @Override
    public String toString() {
        return name + " [Ingredients: " + ingredients + "]";
    }
}

