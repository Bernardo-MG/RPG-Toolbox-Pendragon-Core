package com.wandrell.tabletop.business.model.pendragon.character.background;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Objects;

import com.google.common.base.MoreObjects;

public final class DefaultDistinctiveFeature implements DistinctiveFeature {

    private String       descriptor = "";
    private final String name;

    public DefaultDistinctiveFeature(final DefaultDistinctiveFeature feature) {
        super();

        checkNotNull(feature, "Received a null pointer as feature");

        name = feature.name;
        descriptor = feature.descriptor;
    }

    public DefaultDistinctiveFeature(final String name) {
        super();

        checkNotNull(name, "Received a null pointer as name");

        this.name = name;
    }

    @Override
    public final DefaultDistinctiveFeature createNewInstance() {
        return new DefaultDistinctiveFeature(this);
    }

    @Override
    public final boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DefaultDistinctiveFeature other = (DefaultDistinctiveFeature) obj;
        return Objects.equals(name, other.name)
                && Objects.equals(descriptor, other.descriptor);
    }

    @Override
    public final String getDescriptor() {
        return descriptor;
    }

    @Override
    public final String getName() {
        return name;
    }

    @Override
    public final int hashCode() {
        return Objects.hash(name, descriptor);
    }

    public final void setDescriptor(final String descriptor) {
        checkNotNull(descriptor, "Received a null pointer as descriptor");

        this.descriptor = descriptor;
    }

    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this).add("name", name)
                .add("descriptor", descriptor).toString();
    }

}
