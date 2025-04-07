import java.util.Arrays;
import java.util.List;

public class WaterPokemon extends Pokemon {
    private static final String TYPE = "water";

    public WaterPokemon(String name, int lvl, int hp, String food, String sound) {
        super(name, lvl, hp, food, sound, TYPE);
    }

    List<String> attacks = Arrays.asList("surf", "hydropump", "hydrocanon", "raindance");

    public void surf(Pokemon name, Pokemon enemy) {

    }

    public void hydroPump(Pokemon name, Pokemon enemy) {

    }

    public void hydroCanon(Pokemon name, Pokemon enemy) {

    }

    public void rainDance(Pokemon name, Pokemon enemy) {

    }

    @Override
    public List<String> getAttacks() {
        return attacks;
    }


}
