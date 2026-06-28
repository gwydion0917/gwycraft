package gwydion0917.gwycraft;

import gwydion0917.gwycraft.items.ItemGemShears;
import gwydion0917.gwycraft.registration.ModItems;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Forge-bus player event handlers for GwyCraft 1.20.1.
 * Key changes from 1.16.5:
 * - ServerPlayerEntity → ServerPlayer
 * - getPlayer() → getEntity()
 * - RecipeHolder does NOT exist in MC 1.20.1; use RecipeManager.getRecipeIds() +
 *   byKey() to get Recipe<?> by namespace, then awardRecipes(Collection<Recipe<?>>).
 * - IRecipe → Recipe
 * - Random → RandomSource
 * - EnchantmentHelper.enchantItem still takes (RandomSource, ItemStack, int, boolean)
 */
@Mod.EventBusSubscriber(modid = Gwycraft.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class GwycraftPlayerEvents {

    /** Unlock all gwycraft recipes for a player when they log in. */
    @SubscribeEvent
    public static void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent event) {
        if (!(event.getEntity() instanceof ServerPlayer player)) return;

        var rm = player.getServer().getRecipeManager();

        // In MC 1.20.1, RecipeManager.getRecipeIds() returns Stream<ResourceLocation>.
        // Filter by our modid namespace, then resolve each recipe via byKey().
        List<Recipe<?>> gwycraftRecipes = rm.getRecipeIds()
                .filter(id -> id.getNamespace().equals(Gwycraft.MOD_ID))
                .map(rm::byKey)
                .filter(opt -> opt.isPresent())
                .map(opt -> opt.get())
                .collect(Collectors.toList());

        if (!gwycraftRecipes.isEmpty()) {
            player.awardRecipes(gwycraftRecipes);
        }
    }

    /** Add random enchantments to gem tools on craft (if config enabled). */
    @SubscribeEvent
    public static void onItemCrafted(PlayerEvent.ItemCraftedEvent event) {
        if (!ConfigGwycraft.TOOLS_HAVE_ENCHANTS.get()) return;
        ItemStack stack = event.getCrafting();
        Item item = stack.getItem();

        if (item == ModItems.GEM_SHEARS.get()) {
            ItemGemShears.enchantOnCraft(stack);
        } else if (item == ModItems.GEM_HATCHET.get()
                || item == ModItems.GEM_HOE.get()
                || item == ModItems.GEM_PICKAXE.get()
                || item == ModItems.GEM_SHOVEL.get()
                || item == ModItems.GEM_SWORD.get()) {
            RandomSource rng = RandomSource.create();
            EnchantmentHelper.enchantItem(rng, stack, rng.nextInt(30) + 1, true);
        }
    }
}
