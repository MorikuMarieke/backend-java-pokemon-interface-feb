import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class WaterPokemon extends Pokemon {
    private static final String TYPE = "water";
    private boolean hydrated = false;

    public WaterPokemon(String name, int level, int hp, String food, String sound) {
        super(name, level, hp, food, sound, TYPE);
    }

    List<String> attacks = Arrays.asList("surf", "hydropump", "hydrocanon", "raindance");

    public void surf(Pokemon name, Pokemon enemy) {
        System.out.println(name.getName() + " attacks with Surf.");
        if (name instanceof WaterPokemon wp && wp.isHydrated()) {
            enemy.setHp((int) (enemy.getHp() - 1.1 * (name.getPower() * (30 * name.getDamageMultiplier()))));
            System.out.println("Because " + name.getName() + " is hydrated, Surf is extra effective!");
        } else {
            enemy.setHp((int) (enemy.getHp() - name.getPower() * (30 * name.getDamageMultiplier())));
            System.out.println(name.getName() + " used Surf.");
        }
        System.out.println(enemy.getName()+ " HP " + enemy.getHp());
    }


    public void hydroPump(Pokemon name, Pokemon enemy) {
        System.out.println(name.getName() + " attacks with Hydropump.");
        enemy.setHp((int) (enemy.getHp() - name.getPower() * (15 * name.getDamageMultiplier())));
        System.out.println(enemy.getName()+ " HP " + enemy.getHp());
    }

    public void hydroCanon(Pokemon name, Pokemon enemy) {
        System.out.println(name.getName() + " attacks with Hydrocanon.");
        enemy.setHp((int) (enemy.getHp() - (60 * name.getDamageMultiplier())));
        System.out.println(enemy.getName()+ " HP " + enemy.getHp());
    }

    public void rainDance(Pokemon name, Pokemon enemy) {
        System.out.println(name.getName() + " attacks with Raindance");
        name.setPower(name.getPower() * 1.5);
        if (name instanceof WaterPokemon wp) {
            wp.setHydrated(true);
            System.out.println(wp.getName() + " is now hydrated!");
        }
        if (Objects.equals(enemy.getType(), "electric")) {
            System.out.println("Raindance has no effect on " + enemy.getName());
        } else if (Objects.equals(enemy.getType(), "grass")) {
            setHp((int) (enemy.getHp() + enemy.getHp() * 0.1));
            System.out.println(enemy.getName() + "'s hp was boosted to " + enemy.getHp() + " because they are grass type.");
        } else {
            enemy.setPower(enemy.getPower() - 0.1);
        }
        System.out.println(enemy.getName()+ " HP " + enemy.getHp());
    }

    @Override
    public List<String> getAttacks() {
        return attacks;
    }

    public boolean isHydrated() {
        return hydrated;
    }

    public void setHydrated(boolean hydrated) {
        this.hydrated = hydrated;
    }

    @Override
    public void setDamageMultiplier(Pokemon enemy) {
        this.damageMultiplier = switch (enemy.getType()) {
            case "water" -> 0.5;
            case "electric" -> 1.5;
            case "fire" -> 2.5;
            default -> 1.0;
        };
    }
}
