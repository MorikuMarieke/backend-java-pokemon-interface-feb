import java.util.Arrays;
import java.util.List;

public class ElectricPokemon extends Pokemon {
    private static final String TYPE = "electric";

    public ElectricPokemon(String name, int lvl, int hp, String food, String sound) {
        super(name, lvl, hp, food, sound, TYPE);
    }

    List<String> attacks = Arrays.asList("electroball", "thunderpunch", "thunder", "volttackle");

    public void electroBall(Pokemon name, Pokemon enemy) {

    }

    public void thunderPunch(Pokemon name, Pokemon enemy) {

    }

    public void thunder(Pokemon name, Pokemon enemy) {

    }

    public void voltTackle(Pokemon name, Pokemon enemy) {

    }

    @Override
    public List<String> getAttacks() {
        return attacks;
    }

}
