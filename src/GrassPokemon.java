import java.util.Arrays;
import java.util.List;

public class GrassPokemon extends Pokemon {
    private static final String TYPE = "grass";

    public GrassPokemon(String name, int level, int hp, String food, String sound) {
        super(name, level, hp, food, sound, TYPE);
    }

    List<String> attacks = Arrays.asList("solarbeam", "leafstorm", "leechseed", "leaveblade");

    public void solarBeam(Pokemon name, Pokemon enemy) {

    }

    public void leafStorm(Pokemon name, Pokemon enemy) {

    }

    public void leechSeed(Pokemon name, Pokemon enemy) {

    }

    public void leaveBlade(Pokemon name, Pokemon enemy) {

    }

    @Override
    public List<String> getAttacks() {
        return attacks;
    }
}
