package ie.main.object.entity.item;

import ie.main.manager.OptionManager;
import ie.main.object.entity.player.Player;

public class ItemConfig {
    private final int value;
    private final int life;
    private final OptionManager optionManager;
    private final Player player;

    public int getValue() {
        return value;
    }

    public int getLife() {
        return life;
    }

    public OptionManager getOptionManager() {
        return optionManager;
    }

    public Player getPlayer() {
        return player;
    }

    public ItemConfig(int value, int life, OptionManager optionManager, Player player) {
        this.value = value;
        this.life = life;
        this.optionManager = optionManager;
        this.player = player;
    }
}
