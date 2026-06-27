package gwydion0917.gwycraft.items;

import gwydion0917.gwycraft.data.ModTags;
import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;

/**
 * Tool tier for GwyCraft gem tools.
 * Equivalent to the old EnumHelper.addToolMaterial("GWYCRAFT_MATERIAL", 2, 500, 8.0F, 2.0F, 22).
 * Repair ingredient: any item in the gwycraft:gems tag.
 */
public enum GwyItemTier implements IItemTier {
    INSTANCE;

    @Override public int getUses()              { return 500; }
    @Override public float getSpeed()           { return 8.0F; }
    @Override public float getAttackDamageBonus() { return 2.0F; }
    @Override public int getLevel()             { return 2; }
    @Override public int getEnchantmentValue() { return 22; }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.of(ModTags.Items.GEMS);
    }
}
