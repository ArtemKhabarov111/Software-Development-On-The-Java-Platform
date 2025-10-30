package vegetables.green;

/**
 * Клас, що представляє огірок.
 */
public class Cucumber extends GreenVegetables{
    public Cucumber(){
        super(16, "green");
    }

    @Override
    public String toString() {
        return "Огірок";
    }
}
