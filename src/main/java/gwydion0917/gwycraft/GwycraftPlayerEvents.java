package gwydion0917.gwycraft;

import gwydion0917.gwycraft.items.ItemGemShears;
import gwydion0917.gwycraft.registration.ModItems;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Game-bus player event handlers for GwyCraft 1.21.1 (NeoForge).
 * Key changes from 1.20.1:
 * - Recipes are wrapped in RecipeHolder; awardRecipes takes Collection<RecipeHolder<?>>
 * - Enchantments.* are ResourceKeys; EnchantmentHelper.enchantItem needs registry access
 */
@EventBusSubscriber(modid = Gwycraft.MOD_ID)
public class GwycraftPlayerEvents {

    /** Unlock all gwycraft recipes for a player when they log in. */
    @SubscribeEvent
    public static void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent event) {
        if (!(event.getEntity() instanceof ServerPlayer player)) return;

        var rm = player.getServer().getRecipeManager();

        List<RecipeHolder<?>> gwycraftRecipes = rm.getRecipes().stream()
                .filter(holder -> holder.id().getNamespace().equals(Gwycraft.MOD_ID))
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
        var registries = event.getEntity().level().registryAccess();

        if (item == ModItems.GEM_SHEARS.get()) {
            ItemGemShears.enchantOnCraft(stack, registries);
        } else if (item == ModItems.GEM_HATCHET.get()
                || item == ModItems.GEM_HOE.get()
                || item == ModItems.GEM_PICKAXE.get()
                || item == ModItems.GEM_SHOVEL.get()
                || item == ModItems.GEM_SWORD.get()) {
            RandomSource rng = RandomSource.create();
            EnchantmentHelper.enchantItem(rng, stack, rng.nextInt(30) + 1,
                    registries, Optional.empty());
        }
    }
}
