package gwydion0917.gwycraft;

import gwydion0917.gwycraft.enums.EnumGemType;
import gwydion0917.gwycraft.registration.ModBlocks;
import gwydion0917.gwycraft.registration.ModItems;
import net.minecraft.item.DyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.RegistryObject;

/**
 * Inter-Mod Communication for GwyCraft 1.16.5.
 * Replaces the 1.12 FMLInterModComms.sendMessage pattern.
 *
 * Note: Forestry and ForgeMicroblock do not have 1.16.5 releases.
 * The code is preserved for when/if compatible versions are released.
 * All sendTo calls safely no-op when the target mod is absent.
 */
public class InterModCommunication {

    public static void sendMessages() {
        if (ModList.get().isLoaded("forestry")) {
            sendForestryMessages();
        }
        if (ModList.get().isLoaded("forgemicroblock")) {
            sendFMPMessages();
        }
    }

    private static void sendForestryMessages() {
        // Digger backpack
        sendBackpackMsg("digger", ModBlocks.DYED_COBBLESTONE);
        sendBackpackMsg("digger", ModBlocks.GLOWY_DYED_COBBLESTONE);
        sendBackpackMsg("digger", ModBlocks.DYED_SAND);
        sendBackpackMsg("digper", ModBlocks.GLOWY_DYED_SAND);
        for (DyeColor c : DyeColor.values()) {
            sendItemBackpackMsg("digger", ModItems.CLAY_BALL.get(c));
            sendItemBackpackMsg("digger", ModItems.CLAY_BRICK.get(c));
            sendItemBackpackMsg("digger", ModItems.MUD_BALL.get(c));
            sendItemBackpackMsg("digger", ModItems.MUD_BRICK.get(c));
        }
        // Builder backpack
        sendBackpackMsg("builder", ModBlocks.GLOWY_WOOL);
        sendBackpackMsg("builder", ModBlocks.DYED_STONE);
        sendBackpackMsg("builder", ModBlocks.GLOWY_DYED_STONE);
        sendBackpackMsg("builder", ModBlocks.DYED_BRICK);
        sendBackpackMsg("builder", ModBlocks.GLOWY_DYED_BRICK);
        sendBackpackMsg("builder", ModBlocks.DYED_CLAY);
        sendBackpackMsg("builder", ModBlocks.GLOWY_DYED_CLAY);
        sendBackpackMsg("builder", ModBlocks.DYED_GLASS);
        sendBackpackMsg("builder", ModBlocks.GLOWY_DYED_GLASS);
        sendBackpackMsg("builder", ModBlocks.DYED_MUD_BRICK);
        sendBackpackMsg("builder", ModBlocks.GLOWY_DYED_MUD_BRICK);
        sendBackpackMsg("builder", ModBlocks.DYED_STONE_BRICK);
        sendBackpackMsg("builder", ModBlocks.GLOWY_DYED_STONE_BRICK);
        sendBackpackMsg("builder", ModBlocks.DYED_SANDSTONE);
        sendBackpackMsg("builder", ModBlocks.GLOWY_DYED_SANDSTONE);
        sendBackpackMsg("builder", ModBlocks.DYED_COBBLESTONE_WALL);
        sendBackpackMsg("builder", ModBlocks.GLOWY_DYED_COBBLESTONE_WALL);
        for (DyeColor c : DyeColor.values()) {
            sendItemBackpackMsg("builder", ModItems.DYED_STICK.get(c));
        }
        // Forester backpack
        sendBackpackMsg("forester", ModBlocks.DYED_LEAF);
        sendBackpackMsg("forester", ModBlocks.GLOWY_DYED_LEAF);
        // Miner backpack
        for (EnumGemType gem : EnumGemType.values()) {
            RegistryObject<net.minecraft.item.Item> gemItem = ModItems.GEM.get(gem);
            sendItemBackpackMsg("miner", gemItem);
        }
    }

    private static void sendFMPMessages() {
        // ForgeMicroblock micro-material support
        for (DyeColor c : DyeColor.values()) {
            sendMicroMaterial(ModBlocks.GLOWY_WOOL.get(c));
            sendMicroMaterial(ModBlocks.DYED_STONE.get(c));
            sendMicroMaterial(ModBlocks.GLOWY_DYED_STONE.get(c));
            sendMicroMaterial(ModBlocks.DYED_BOOKCASE.get(c));
            sendMicroMaterial(ModBlocks.GLOWY_DYED_BOOKCASE.get(c));
            sendMicroMaterial(ModBlocks.DYED_PLANK.get(c));
            sendMicroMaterial(ModBlocks.GLOWY_DYED_PLANK.get(c));
            sendMicroMaterial(ModBlocks.DYED_BRICK.get(c));
            sendMicroMaterial(ModBlocks.GLOWY_DYED_BRICK.get(c));
            sendMicroMaterial(ModBlocks.DYED_CLAY.get(c));
            sendMicroMaterial(ModBlocks.GLOWY_DYED_CLAY.get(c));
            sendMicroMaterial(ModBlocks.DYED_GLASS.get(c));
            sendMicroMaterial(ModBlocks.GLOWY_DYED_GLASS.get(c));
            sendMicroMaterial(ModBlocks.DYED_LEAF.get(c));
            sendMicroMaterial(ModBlocks.GLOWY_DYED_LEAF.get(c));
            sendMicroMaterial(ModBlocks.DYED_MUD_BRICK.get(c));
            sendMicroMaterial(ModBlocks.GLOWY_DYED_MUD_BRICK.get(c));
            sendMicroMaterial(ModBlocks.DYED_SAND.get(c));
            sendMicroMaterial(ModBlocks.GLOWY_DYED_SAND.get(c));
            sendMicroMaterial(ModBlocks.DYED_SANDSTONE.get(c));
            sendMicroMaterial(ModBlocks.GLOWY_DYED_SANDSTONE.get(c));
            sendMicroMaterial(ModBlocks.DYED_STONE_BRICK.get(c));
            sendMicroMaterial(ModBlocks.GLOWY_DYED_STONE_BRICK.get(c));
            sendMicroMaterial(ModBlocks.DYED_COBBLESTONE.get(c));
            sendMicroMaterial(ModBlocks.GLOWY_DYED_COBBLESTONE.get(c));
        }
        for (EnumGemType gem : EnumGemType.values()) {
            sendMicroMaterial(ModBlocks.GEM_ORE.get(gem));
            sendMicroMaterial(ModBlocks.COMPRESSED_GEM.get(gem));
        }
    }

    // ── Helpers ──────────────────────────────────────────────────────────────

    private static void sendBackpackMsg(String category,
            java.util.Map<DyeColor, RegistryObject<net.minecraft.block.Block>> family) {
        for (DyeColor c : DyeColor.values()) {
            RegistryObject<net.minecraft.block.Block> ro = family.get(c);
            if (ro != null) {
                ItemStack stack = new ItemStack(ro.get());
                InterModComms.sendTo("forestry", "add-backpack-items",
                        () -> category + "@" + stack.getItem().getRegistryName() + ":*");
            }
        }
    }

    private static void sendItemBackpackMsg(String category, RegistryObject<Item> itemRO) {
        if (itemRO == null) return;
        InterModComms.sendTo("forestry", "add-backpack-items",
                () -> category + "@" + itemRO.get().getRegistryName() + ":*");
    }

    private static void sendMicroMaterial(RegistryObject<net.minecraft.block.Block> ro) {
        if (ro == null) return;
        InterModComms.sendTo("forgemicroblock", "microMaterial",
                () -> new ItemStack(ro.get()));
    }
}
