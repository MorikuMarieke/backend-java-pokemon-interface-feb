import java.util.List;

public abstract class Pokemon {
    private String name;
    private int level;
    private final int hp;
    private String food;
    private String sound;
    private List<String> attacks;
    private final String type;

    public Pokemon(String name, int lvl, int hp, String food, String sound, String type) {
        this.name = name;
        this.level = lvl;
        this.hp = hp;
        this.food = food;
        this.sound = sound;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getHp() {
        return hp;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    List<String> getAttacks() {
        return attacks;
    }

    public String getType() {
        return type;
    }

    public void setAttacks(List<String> attacks) {
        this.attacks = attacks;
    }
}
