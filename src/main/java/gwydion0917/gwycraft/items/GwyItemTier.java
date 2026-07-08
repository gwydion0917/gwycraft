package gwydion0917.gwycraft.items;

import gwydion0917.gwycraft.data.ModTags;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;

/**
 * Tool tier for GwyCraft gem tools.
 * 1.20.5+ replaced the numeric mining level (getLevel) with a tag of blocks the
 * tier CANNOT drop: getIncorrectBlocksForDrops. Level 2 == iron tier.
 * Repair ingredient: any item in the gwycraft:gems tag.
 */
public enum GwyItemTier implements Tier {
    INSTANCE;

    @Override public int getUses()                { return 500; }
    @Override public float getSpeed()             { return 8.0F; }
    @Override public float getAttackDamageBonus() { return 2.0F; }
    @Override public int getEnchantmentValue()    { return 22; }

    @Override
    public TagKey<Block> getIncorrectBlocksForDrops() {
        return BlockTags.INCORRECT_FOR_IRON_TOOL;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.of(ModTags.Items.GEMS);
    }
}
