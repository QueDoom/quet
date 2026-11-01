package net.quedoom.quet.api.prickle;

public abstract class QTConfigs {
    @Override
    public String toString() {
        return getName();
    }
    protected abstract String getName();
}
