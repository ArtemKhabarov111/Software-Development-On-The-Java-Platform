package vegetables.red;

/**
 * Клас, що представляє помідор.
 */
public class Tomato extends RedVegetables{
    public Tomato(){
        super(18, "red");
    }

    @Override
    public String toString() {
        return "Помідор";
    }
}
