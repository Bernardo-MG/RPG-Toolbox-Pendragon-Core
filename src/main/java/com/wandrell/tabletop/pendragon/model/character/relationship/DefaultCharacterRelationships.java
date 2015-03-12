package com.wandrell.tabletop.pendragon.model.character.relationship;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;

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
    public final void removeFollower(final Follower follower) {
        getFollowersModifiable().remove(follower);
    }

    @Override
    public final void removeWife(final Wife wife) {
        getWivesModifiable().remove(wife);
    }

    private final Collection<Follower> getFollowersModifiable() {
        return followers;
    }

    private final Collection<Wife> getWivesModifiable() {
        return wives;
    }

}
