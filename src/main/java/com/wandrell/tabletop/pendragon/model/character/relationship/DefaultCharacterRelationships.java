package com.wandrell.tabletop.pendragon.model.character.relationship;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Objects;

import com.google.common.base.MoreObjects;
import com.wandrell.tabletop.pendragon.model.character.PendragonBaseCharacter;

public final class DefaultCharacterRelationships implements
        CharacterRelationships {

    private final PendragonBaseCharacter character;
    private final Collection<Follower>   followers = new LinkedHashSet<>();
    private final Collection<Wife>       wives     = new LinkedHashSet<>();

    public DefaultCharacterRelationships(final PendragonBaseCharacter character) {
        super();

        this.character = character;
    }

    @Override
    public final void addFollower(final Follower follower) {
        getFollowersModifiable().add(follower);
    }

    @Override
    public final void addWife(final Wife wife) {
        getWivesModifiable().add(wife);
    }

    @Override
    public final void clearFollowers() {
        getFollowersModifiable().clear();
    }

    @Override
    public final void clearWives() {
        getWivesModifiable().clear();
    }

    @Override
    public final boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DefaultCharacterRelationships other = (DefaultCharacterRelationships) obj;
        return Objects.equals(character, other.character);
    }

    @Override
    public final PendragonBaseCharacter getCharacter() {
        return character;
    }

    @Override
    public final Collection<Follower> getFollowers() {
        return Collections.unmodifiableCollection(getFollowersModifiable());
    }

    @Override
    public final Collection<Wife> getWives() {
        return Collections.unmodifiableCollection(getWivesModifiable());
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(character);
    }

    @Override
    public final void removeFollower(final Follower follower) {
        getFollowersModifiable().remove(follower);
    }

    @Override
    public final void removeWife(final Wife wife) {
        getWivesModifiable().remove(wife);
    }

    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this)
                .add("character", character.getName())
                .add("followers", followers).add("wives", wives).toString();
    }

    private final Collection<Follower> getFollowersModifiable() {
        return followers;
    }

    private final Collection<Wife> getWivesModifiable() {
        return wives;
    }

}
