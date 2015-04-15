package com.wandrell.tabletop.pendragon.model.character.background;

import static com.google.common.base.Preconditions.checkNotNull;

public final class DefaultBackgroundInfo implements BackgroundInfo {

    private String   culture;
    private String   fatherClass;
    private String   homeland;
    private Boolean  knight = false;
    private String   playerName;
    private Religion religion;

    public DefaultBackgroundInfo() {
        super();
    }

    public DefaultBackgroundInfo(final DefaultBackgroundInfo background) {
        super();

        culture = background.culture;
        homeland = background.homeland;
        fatherClass = background.fatherClass;
        playerName = background.playerName;

        religion = background.religion;

        knight = background.knight;
    }

    @Override
    public final DefaultBackgroundInfo createNewInstance() {
        return new DefaultBackgroundInfo(this);
    }

    @Override
    public final String getCulture() {
        return culture;
    }

    @Override
    public final String getFatherClass() {
        return fatherClass;
    }

    @Override
    public final String getHomeland() {
        return homeland;
    }

    @Override
    public final String getPlayerName() {
        return playerName;
    }

    @Override
    public final Religion getReligion() {
        return religion;
    }

    @Override
    public final Boolean isKnight() {
        return knight;
    }

    @Override
    public final void setCulture(final String culture) {
        this.culture = culture;
    }

    @Override
    public final void setFatherClass(final String fatherClass) {
        this.fatherClass = fatherClass;
    }

    @Override
    public final void setHomeland(final String homeland) {
        this.homeland = homeland;
    }

    @Override
    public final void setKnight(final Boolean knight) {
        this.knight = knight;
    }

    @Override
    public final void setPlayerName(final String name) {
        playerName = name;
    }

    @Override
    public final void setReligion(final Religion religion) {
        checkNotNull(religion, "Received a null pointer as religion");

        this.religion = religion;
    }

}
