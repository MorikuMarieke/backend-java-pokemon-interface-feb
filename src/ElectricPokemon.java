import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ElectricPokemon extends Pokemon {
    private static final String TYPE = "electric";
    private boolean charged = false;

    public ElectricPokemon(String name, int level, int hp, String food, String sound) {
        super(name, level, hp, food, sound, TYPE);
    }

    List<String> attacks = Arrays.asList("electroball", "thunderpunch", "thunder", "volttackle");

    public void electroBall(Pokemon name, Pokemon enemy) {
        System.out.println("Multiplier: " + name.getDamageMultiplier());
        if (name instanceof ElectricPokemon ep && ep.isCharged()) {
            enemy.setHp((int) (enemy.getHp() - 80 * name.getDamageMultiplier()));
            ep.setCharged(false);
            if (Objects.equals(enemy.getType(), "water")) {
                System.out.println(name.getName() + " was charged. It's super duper effective!");
            }
        } else {

            enemy.setHp((int) (enemy.getHp() - 40 * name.getDamageMultiplier()));
            if (Objects.equals(enemy.getType(), "water")) {
                System.out.println("It's super effective!");
            }
        }
        System.out.println(enemy.getName()+ " HP " + enemy.getHp());
    }

    public void thunderPunch(Pokemon name, Pokemon enemy) {
        System.out.println("Multiplier: " + name.getDamageMultiplier());
        enemy.setHp((int) (enemy.getHp() - 70 * name.getDamageMultiplier()));
        if (Objects.equals(enemy.getType(), "water")) {
            System.out.println("It's super effective!");
        }
        System.out.println(enemy.getName()+ " HP " + enemy.getHp());
    }

    public void thunder(Pokemon name, Pokemon enemy) {
        System.out.println("Multiplier: " + name.getDamageMultiplier());

        System.out.println(name.getName() + " attacks with Thunder");
        if (enemy instanceof ElectricPokemon wp) {
            wp.setCharged(true);
            System.out.println(wp.getName() + " is now charged!");
        } else {
            enemy.setHp((int) (enemy.getHp() - 50 * name.getDamageMultiplier()));
        }
        System.out.println(enemy.getName()+ " HP " + enemy.getHp());
    }

    public void voltTackle(Pokemon name, Pokemon enemy) {
        System.out.println("Multiplier: " + name.getDamageMultiplier());

        enemy.setHp((int) (enemy.getHp() - 40 * name.getDamageMultiplier()));
        if (Objects.equals(enemy.getType(), "water")) {
            System.out.println("It's super effective!");
        }
        System.out.println(enemy.getName()+ " HP " + enemy.getHp());
    }

    @Override
    public List<String> getAttacks() {
        return attacks;
    }

    public boolean isCharged() {
        return charged;
    }

    public void setCharged(boolean charged) {
        this.charged = charged;
    }

    @Override
    public void setDamageMultiplier(Pokemon enemy) {
        this.damageMultiplier = switch (enemy.getType()) {
            case "water" -> 2.5;
            case "electric" -> 0.5;
            case "grass" -> 1.5;
            default -> 1.0;
        };
    }
}
