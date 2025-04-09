import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class GrassPokemon extends Pokemon {
    private static final String TYPE = "grass";
    private boolean solarBeamCharged = false;
    private double SpecialAttackModifier = 1.0;

    public GrassPokemon(String name, int level, int hp, String food, String sound) {
        super(name, level, hp, food, sound, TYPE);
    }

    List<String> attacks = Arrays.asList("solarbeam", "leafstorm", "leechseed", "leafblade");

    public void solarBeam(Pokemon name, Pokemon enemy) {
        System.out.println(name.getName() + " uses Solarbeam.");

        if (name instanceof GrassPokemon gp && !gp.isSolarBeamCharged()) {
            gp.setSolarBeamCharged(true);
            System.out.println("Solar beam charged! It can now be used next round!");
        } else if (name instanceof GrassPokemon gp) {
            enemy.setHp((int) ((enemy.getHp() - 200) * name.getDamageMultiplier()));
            System.out.println("Solar beam unleashed!");
            if (Objects.equals(enemy.getType(), "electric")) {
                System.out.println("It's super effective!");
            }
            gp.setSolarBeamCharged(false);
        }
        System.out.println(enemy.getName() + " HP: " + enemy.getHp());
    }

    public void leafStorm(Pokemon name, Pokemon enemy) {
        System.out.println(name.getName() + " attacks with Leafstorm.");
        if (name instanceof GrassPokemon gp) {
            if (gp.getSpecialAttackModifier() <= 0) {
                System.out.println(name.getName() + " can't perform Leafstorm anymore, the leaves are gone.");
            } else {
                int damage = (int) (100 * gp.getSpecialAttackModifier());
                enemy.setHp(enemy.getHp() - damage);
                System.out.println(name.getName() + " attacked with Leaf Storm and dealt " + damage + " damage!");
                gp.setSpecialAttackModifier(gp.getSpecialAttackModifier() - 0.1);
            }
        }
        System.out.println(enemy.getName()+ " HP " + enemy.getHp());
    }

    public void leechSeed(Pokemon name, Pokemon enemy) {
        System.out.println(name.getName() + " attacks with Leechseed.");
        double leechPoints = (int) (30 * name.getDamageMultiplier());
        enemy.setHp((int) (enemy.getHp() - leechPoints));
        name.setHp((int) (name.getHp() + leechPoints));
        System.out.println(name.getName() + " leeched " + leechPoints + " from " + enemy.getName());
        System.out.println(enemy.getName()+ " HP " + enemy.getHp());
        System.out.println(name.getName()+ " HP " + name.getHp());
    }

    public void leafBlade(Pokemon name, Pokemon enemy) {
        double criticalMultiplier = 1.0 + (Math.random() * 0.5);
        int baseDamage = 70;
        enemy.setHp((int) (enemy.getHp() - criticalMultiplier * (baseDamage * name.getDamageMultiplier())));
        if (criticalMultiplier > 1.4) {
            System.out.println("It's a critical hit!");
        }
        if (Objects.equals(enemy.getType(), "electric")) {
            System.out.println("It's super effective!");
        }
        System.out.println(enemy.getName()+ " HP " + enemy.getHp());

    }

    @Override
    public List<String> getAttacks() {
        return attacks;
    }

    @Override
    public void setDamageMultiplier(Pokemon enemy) {
        this.damageMultiplier = switch (enemy.getType()) {
            case "fire" -> 1.5;
            case "electric" -> 2.5;
            case "grass" -> 0.5;
            default -> 1.0;
        };
    }

    public boolean isSolarBeamCharged() {
        return solarBeamCharged;
    }

    public void setSolarBeamCharged(boolean solarBeamCharged) {
        this.solarBeamCharged = solarBeamCharged;
    }

    public double getSpecialAttackModifier() {
        return SpecialAttackModifier;
    }

    public void setSpecialAttackModifier(double specialAttackModifier) {
        SpecialAttackModifier = specialAttackModifier;
    }
}
