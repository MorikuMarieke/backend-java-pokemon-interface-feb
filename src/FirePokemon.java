import java.util.Arrays;
import java.util.List;

public class FirePokemon extends Pokemon {
    private static final String TYPE = "fire";

    public FirePokemon(String name, int level, int hp, String food, String sound) {
        super(name, level, hp, food, sound, TYPE);
    }

    List<String> attacks = Arrays.asList("firelash", "pyroball", "flamethrower", "inferno");

    public void fireLash(Pokemon name, Pokemon enemy) {

    }

    public void pyroBall(Pokemon name, Pokemon enemy) {

    }

    public void flameThrower(Pokemon name, Pokemon enemy) {

    }

    public void inferno(Pokemon name, Pokemon enemy) {

    }

    @Override
    public List<String> getAttacks() {
        return attacks;
    }

    @Override
    public void setDamageMultiplier(Pokemon enemy) {
        this.damageMultiplier = switch (enemy.getType()) {
            case "water" -> 1.5;
            case "grass" -> 2.5;
            case "fire" -> 0.5;
            default -> 1.0;
        };
    }
}
