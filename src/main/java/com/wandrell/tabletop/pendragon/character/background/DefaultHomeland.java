package com.wandrell.tabletop.pendragon.character.background;

public final class DefaultHomeland implements Homeland {

    private final String name;

    public DefaultHomeland(final DefaultHomeland homeland) {
        super();

        name = homeland.name;
    }

    public DefaultHomeland(final String name) {
        super();

        if (name == null) {
            throw new NullPointerException();
        }

        this.name = name;
    }

    @Override
    public final boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DefaultHomeland other = (DefaultHomeland) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    @Override
    public final String getName() {
        return name;
    }

    @Override
    public final int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public final String toString() {
        return getName();
    }

}
