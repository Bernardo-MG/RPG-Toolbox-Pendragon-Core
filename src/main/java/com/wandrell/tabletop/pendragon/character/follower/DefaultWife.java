package com.wandrell.tabletop.pendragon.character.follower;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class DefaultWife implements Wife {

    private final List<Child> children;
    private final String      fileCharacter;
    private final Integer     yearWed;

    public DefaultWife(final DefaultWife wife) {
        super();

        children = wife.children;

        yearWed = wife.yearWed;

        fileCharacter = wife.fileCharacter;
    }

    public DefaultWife(final String fileCharacter, final Integer yearWed,
            final List<Child> children) {
        super();

        if (fileCharacter == null) {
            throw new NullPointerException();
        }

        if (yearWed == null) {
            throw new NullPointerException();
        }

        if (children == null) {
            throw new NullPointerException();
        }

        this.fileCharacter = fileCharacter;
        this.yearWed = yearWed;
        this.children = children;
    }

    @Override
    public final boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DefaultWife other = (DefaultWife) obj;
        if (fileCharacter == null) {
            if (other.fileCharacter != null)
                return false;
        } else if (!fileCharacter.equals(other.fileCharacter))
            return false;
        return true;
    }

    @Override
    public final Collection<Child> getChildren() {
        return Collections.unmodifiableCollection(_getChildren());
    }

    @Override
    public final String getFile() {
        return fileCharacter;
    }

    @Override
    public final Integer getYearWed() {
        return yearWed;
    }

    @Override
    public final int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((fileCharacter == null) ? 0 : fileCharacter.hashCode());
        return result;
    }

    @Override
    public final String toString() {
        return getFile();
    }

    protected final Collection<Child> _getChildren() {
        return children;
    }

    protected final void loadCharacter() {

    }

}
