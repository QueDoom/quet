package net.quedoom.quet.villager;

public enum VillagerLevels {
    NOVICE,
    APPRENTICE,
    JOURNEYMAN,
    EXPERT,
    MASTER;

    public int value() {
        return switch (this) {
            case NOVICE -> 1;
            case APPRENTICE -> 2;
            case JOURNEYMAN -> 3;
            case EXPERT -> 4;
            case MASTER -> 5;
        };
    }
}
