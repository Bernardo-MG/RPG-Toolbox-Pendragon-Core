package com.wandrell.tabletop.testing.pendragon.test.unit.inventory;

import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.wandrell.tabletop.pendragon.model.inventory.armor.ArmorPiece;
import com.wandrell.tabletop.pendragon.model.inventory.armor.DefaultEquippedArmor;
import com.wandrell.tabletop.pendragon.model.inventory.armor.EquippedArmor;

public final class TestDefaultEquippedArmor {

    public TestDefaultEquippedArmor() {
        super();
    }

    @Test
    public final void testArmorSum() {
        final EquippedArmor armor;
        ArmorPiece piece;

        armor = new DefaultEquippedArmor();

        piece = Mockito.mock(ArmorPiece.class);
        Mockito.when(piece.getArmorValue()).thenReturn(10);

        armor.addArmorPiece(piece);

        piece = Mockito.mock(ArmorPiece.class);
        Mockito.when(piece.getArmorValue()).thenReturn(5);

        armor.addArmorPiece(piece);

        piece = Mockito.mock(ArmorPiece.class);
        Mockito.when(piece.getArmorValue()).thenReturn(1);

        armor.addArmorPiece(piece);

        Assert.assertEquals(armor.getTotalArmor(), (Integer) 16);
    }

    @Test
    public final void testArmorSum_Repeats_NoSum() {
        final EquippedArmor armor;
        ArmorPiece piece;

        armor = new DefaultEquippedArmor();

        piece = Mockito.mock(ArmorPiece.class);
        Mockito.when(piece.getArmorValue()).thenReturn(10);

        armor.addArmorPiece(piece);

        piece = Mockito.mock(ArmorPiece.class);
        Mockito.when(piece.getArmorValue()).thenReturn(5);

        armor.addArmorPiece(piece);
        armor.addArmorPiece(piece);

        Assert.assertEquals(armor.getTotalArmor(), (Integer) 15);
    }
}
