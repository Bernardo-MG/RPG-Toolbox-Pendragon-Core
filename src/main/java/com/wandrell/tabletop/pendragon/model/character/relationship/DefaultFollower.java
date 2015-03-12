package com.wandrell.tabletop.pendragon.model.character.relationship;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Objects;

import com.google.common.base.MoreObjects;

public final class DefaultFollower implements Follower {

    private final String job;
    private final String name;

    public DefaultFollower(final DefaultFollower follower) {
        super();

        checkNotNull(follower, "Received a null pointer as follower");

        name = follower.name;
        job = follower.job;
    }

    public DefaultFollower(final String name, final String job) {
        super();

        checkNotNull(name, "Received a null pointer as name");
        checkNotNull(job, "Received a null pointer as job");

        this.name = name;
        this.job = job;
    }

    @Override
    public final boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DefaultFollower other = (DefaultFollower) obj;
        return Objects.equals(name, other.name);
    }

    @Override
    public final String getJob() {
        return job;
    }

    @Override
    public final String getName() {
        return name;
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this).add("name", name).toString();
    }

}
