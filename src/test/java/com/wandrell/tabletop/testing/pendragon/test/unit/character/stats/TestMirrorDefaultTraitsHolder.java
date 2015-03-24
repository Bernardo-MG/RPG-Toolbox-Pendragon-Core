package com.wandrell.tabletop.testing.pendragon.test.unit.character.stats;

import java.util.Iterator;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.wandrell.tabletop.pendragon.model.character.stats.DefaultTraitsHolder;
import com.wandrell.tabletop.pendragon.model.character.stats.TraitsHolder;
import com.wandrell.tabletop.testing.pendragon.framework.conf.factory.parameter.ValuesTestParametersFactory;

public final class TestMirrorDefaultTraitsHolder {

    private static final String DATA = "data";

    @DataProvider(name = DATA)
    public final static Iterator<Object[]> getData() throws Exception {
        return ValuesTestParametersFactory.getInstance().getValueAndMirror();
    }

    public TestMirrorDefaultTraitsHolder() {
        super();
    }

    @Test(dataProvider = DATA)
    public void test_badTrait(final Integer value, final Integer mirror) {
        final TraitsHolder holder;

        holder = new DefaultTraitsHolder();

        holder.setCowardly(value);

        Assert.assertEquals(holder.getValorous(), mirror);
        Assert.assertEquals(holder.getCowardly(), value);
    }

    @Test(dataProvider = DATA)
    public void test_goodTrait(final Integer value, final Integer mirror) {
        final TraitsHolder holder;

        holder = new DefaultTraitsHolder();

        holder.setValorous(value);

        Assert.assertEquals(holder.getValorous(), value);
        Assert.assertEquals(holder.getCowardly(), mirror);
    }

}
