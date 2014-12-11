package com.wandrell.tabletop.business.model.pendragon.character.follower;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

import com.google.common.base.MoreObjects;

public final class DefaultWife implements Wife {

    private final Collection<Child> children;
    private final String            name;
    private final Integer           yearWed;

    public DefaultWife(final DefaultWife wife) {
        super();

        checkNotNull(wife, "Received a null pointer as wife");

        children = wife.children;

        yearWed = wife.yearWed;

        name = wife.name;
    }

    public DefaultWife(final String name, final Integer yearWed,
            final Collection<Child> children) {
        super();

        checkNotNull(name, "Received a null pointer as name");
        checkNotNull(yearWed, "Received a null pointer as wedding year");
        checkNotNull(children, "Received a null pointer as children");

        this.name = name;
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
        return Objects.equals(name, other.name);
    }

    @Override
    public final Collection<Child> getChildren() {
        return Collections.unmodifiableCollection(getChildrenModifiable());
    }

    @Override
    public final String getName() {
        return name;
    }

    @Override
    public final Integer getYearWed() {
        return yearWed;
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this).add("name", name).toString();
    }

    private final Collection<Child> getChildrenModifiable() {
        return children;
    }

}
