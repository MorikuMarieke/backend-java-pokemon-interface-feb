import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class FirePokemon extends Pokemon {
    private static final String TYPE = "fire";
    private boolean flamingHot = false;

    public FirePokemon(String name, int level, int hp, String food, String sound) {
        super(name, level, hp, food, sound, TYPE);
    }

    List<String> attacks = Arrays.asList("firelash", "pyroball", "flamethrower", "inferno");

    public void fireLash(Pokemon name, Pokemon enemy) {
        System.out.println(name.getName() + " attacks with Firelash.");

        enemy.setHp((int) (enemy.getHp() - 80 * name.getDamageMultiplier()));
        if (Objects.equals(enemy.getType(), "grass")) {
            System.out.println("It's super effective!");
        }
        System.out.println(enemy.getName()+ " HP " + enemy.getHp());
    }

    public void pyroBall(Pokemon name, Pokemon enemy) {
        int baseDamage = (int) (30 * name.getDamageMultiplier());
        int totalDamage = baseDamage;
        Random random = new Random();
        boolean isBurned = random.nextInt(100) < 10;
        if (isBurned) {
            int burnDamage = (int) (baseDamage * 0.25);
            totalDamage += burnDamage;
            System.out.println(enemy.getName() + " got burn damage! Extra " + burnDamage + " damage!");
        }
        enemy.setHp(enemy.getHp() - totalDamage);
        System.out.println(name.getName() + " used FlameThrower and dealt " + totalDamage + " damage!");
        if (Objects.equals(enemy.getType(), "grass")) {
            System.out.println("It's super effective!");
        }
    }

    public void flameThrower(Pokemon name, Pokemon enemy) {
        int baseDamage = (int) (80 * name.getDamageMultiplier());
        System.out.println(name.getName() + " attacks with Flamethrower.");
        if (isFlamingHot()) {
            enemy.setHp((int) (enemy.getHp() - 1.5 * baseDamage));
            System.out.println(name.getName() + " is flaming hot! The heat is multiplied by 50%.");
        } else {
            enemy.setHp((enemy.getHp() - baseDamage));
        }
        if (Objects.equals(enemy.getType(), "grass")) {
            System.out.println("It's super effective!");
        }
        System.out.println(enemy.getName()+ " HP " + enemy.getHp());
    }

    public void inferno(Pokemon name, Pokemon enemy) {
        System.out.println(name.getName() + " attacks with Inferno.");
        enemy.setHp((int) (enemy.getHp() - 90 * name.getDamageMultiplier()));
        if (Objects.equals(enemy.getType(), "grass")) {
            System.out.println("It's super effective!");
        }
        System.out.println(enemy.getName()+ " HP " + enemy.getHp());
        setFlamingHot(true);
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

    public boolean isFlamingHot() {
        return flamingHot;
    }

    public void setFlamingHot(boolean flamingHot) {
        this.flamingHot = flamingHot;
    }
}
