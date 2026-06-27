package gwydion0917.gwycraft;

import gwydion0917.gwycraft.items.ItemGemShears;
import gwydion0917.gwycraft.registration.ModItems;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.RegistryObject;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;

import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Forge-bus player event handlers.
 * Replaces the 1.12 CraftingManager.REGISTRY recipe-unlock and onCreated enchant.
 */
@Mod.EventBusSubscriber(modid = Gwycraft.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class GwycraftPlayerEvents {

    /** Unlock all gwycraft recipes for a player when they log in. */
    @SubscribeEvent
    public static void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent event) {
        if (!(event.getPlayer() instanceof ServerPlayerEntity)) return;
        ServerPlayerEntity player = (ServerPlayerEntity) event.getPlayer();

        List<IRecipe<?>> gwycraftRecipes = player.getServer()
                .getRecipeManager().getRecipes().stream()
                .filter(r -> r.getId().getNamespace().equals(Gwycraft.MOD_ID))
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
            Random rng = new Random();
            EnchantmentHelper.enchantItem(rng, stack, rng.nextInt(30) + 1, true);
        }
    }
}
