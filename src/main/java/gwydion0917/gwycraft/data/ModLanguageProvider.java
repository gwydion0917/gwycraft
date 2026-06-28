package gwydion0917.gwycraft.data;

import gwydion0917.gwycraft.Gwycraft;
import gwydion0917.gwycraft.enums.EnumGemType;
import gwydion0917.gwycraft.registration.ModBlocks;
import gwydion0917.gwycraft.registration.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.DyeColor;
import net.minecraftforge.common.data.LanguageProvider;

/**
 * Generates en_us.json (replaces 1.12 lang/en_us.lang).
 * Key format: "block.gwycraft.{registry}" / "item.gwycraft.{registry}"
 */
public class ModLanguageProvider extends LanguageProvider {

    public ModLanguageProvider(PackOutput output) {
        super(output, Gwycraft.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        // Creative tab
        add("itemGroup.gwycraft", "GwyCraft");

        for (DyeColor c : DyeColor.values()) {
            String dn = displayName(c);

            // Glowy wool
            addBlock(ModBlocks.GLOWY_WOOL.get(c), dn + " Glowing Wool");

            // Stone family
            addBlock(ModBlocks.DYED_STONE.get(c), dn + " Dyed Stone");
            addBlock(ModBlocks.GLOWY_DYED_STONE.get(c), dn + " Glowing Dyed Stone");
            addBlock(ModBlocks.DYED_STONE_PAVER.get(c), dn + " Dyed Stone Paver");
            addBlock(ModBlocks.GLOWY_DYED_STONE_PAVER.get(c), dn + " Glowing Dyed Stone Paver");

            // Bookcase
            addBlock(ModBlocks.DYED_BOOKCASE.get(c), dn + " Dyed Bookcase");
            addBlock(ModBlocks.GLOWY_DYED_BOOKCASE.get(c), dn + " Glowing Dyed Bookcase");

            // Brick
            addBlock(ModBlocks.DYED_BRICK.get(c), dn + " Dyed Brick");
            addBlock(ModBlocks.GLOWY_DYED_BRICK.get(c), dn + " Glowing Dyed Brick");
            addBlock(ModBlocks.DYED_BRICK_PAVER.get(c), dn + " Dyed Brick Paver");
            addBlock(ModBlocks.GLOWY_DYED_BRICK_PAVER.get(c), dn + " Glowing Dyed Brick Paver");

            // Clay
            addBlock(ModBlocks.DYED_CLAY.get(c), dn + " Dyed Clay");
            addBlock(ModBlocks.GLOWY_DYED_CLAY.get(c), dn + " Glowing Dyed Clay");

            // Glass
            addBlock(ModBlocks.DYED_GLASS.get(c), dn + " Dyed Glass");
            addBlock(ModBlocks.GLOWY_DYED_GLASS.get(c), dn + " Glowing Dyed Glass");

            // Leaf
            addBlock(ModBlocks.DYED_LEAF.get(c), dn + " Dyed Leaves");
            addBlock(ModBlocks.GLOWY_DYED_LEAF.get(c), dn + " Glowing Dyed Leaves");

            // Mud brick
            addBlock(ModBlocks.DYED_MUD_BRICK.get(c), dn + " Dyed Mud Brick");
            addBlock(ModBlocks.GLOWY_DYED_MUD_BRICK.get(c), dn + " Glowing Dyed Mud Brick");
            addBlock(ModBlocks.DYED_MUD_BRICK_PAVER.get(c), dn + " Dyed Mud Brick Paver");
            addBlock(ModBlocks.GLOWY_DYED_MUD_BRICK_PAVER.get(c), dn + " Glowing Dyed Mud Brick Paver");

            // Log
            addBlock(ModBlocks.DYED_LOG.get(c), dn + " Dyed Log");
            addBlock(ModBlocks.GLOWY_DYED_LOG.get(c), dn + " Glowing Dyed Log");

            // Plank
            addBlock(ModBlocks.DYED_PLANK.get(c), dn + " Dyed Plank");
            addBlock(ModBlocks.GLOWY_DYED_PLANK.get(c), dn + " Glowing Dyed Plank");

            // Sand & sandstone
            addBlock(ModBlocks.DYED_SAND.get(c), dn + " Dyed Sand");
            addBlock(ModBlocks.GLOWY_DYED_SAND.get(c), dn + " Glowing Dyed Sand");
            addBlock(ModBlocks.DYED_SANDSTONE.get(c), dn + " Dyed Sandstone");
            addBlock(ModBlocks.GLOWY_DYED_SANDSTONE.get(c), dn + " Glowing Dyed Sandstone");
            addBlock(ModBlocks.DYED_SMOOTH_SANDSTONE.get(c), dn + " Smooth Dyed Sandstone");
            addBlock(ModBlocks.GLOWY_DYED_SMOOTH_SANDSTONE.get(c), dn + " Glowing Smooth Dyed Sandstone");
            addBlock(ModBlocks.DYED_CHISELED_SANDSTONE.get(c), dn + " Chiseled Dyed Sandstone");
            addBlock(ModBlocks.GLOWY_DYED_CHISELED_SANDSTONE.get(c), dn + " Glowing Chiseled Dyed Sandstone");

            // Stone brick
            addBlock(ModBlocks.DYED_STONE_BRICK.get(c), dn + " Dyed Stone Brick");
            addBlock(ModBlocks.GLOWY_DYED_STONE_BRICK.get(c), dn + " Glowing Dyed Stone Brick");
            addBlock(ModBlocks.DYED_STONE_BRICK_PAVER.get(c), dn + " Dyed Stone Brick Paver");
            addBlock(ModBlocks.GLOWY_DYED_STONE_BRICK_PAVER.get(c), dn + " Glowing Dyed Stone Brick Paver");

            // Cobblestone
            addBlock(ModBlocks.DYED_COBBLESTONE.get(c), dn + " Dyed Cobblestone");
            addBlock(ModBlocks.GLOWY_DYED_COBBLESTONE.get(c), dn + " Glowing Dyed Cobblestone");
            addBlock(ModBlocks.DYED_COBBLESTONE_PAVER.get(c), dn + " Dyed Cobblestone Paver");
            addBlock(ModBlocks.GLOWY_DYED_COBBLESTONE_PAVER.get(c), dn + " Glowing Dyed Cobblestone Paver");
            addBlock(ModBlocks.DYED_COBBLESTONE_WALL.get(c), dn + " Dyed Cobblestone Wall");
            addBlock(ModBlocks.GLOWY_DYED_COBBLESTONE_WALL.get(c), dn + " Glowing Dyed Cobblestone Wall");

            // Pillar block sets
            addBlock(ModBlocks.PLAIN_GREEK_BOTTOM.get(c), dn + " Plain Greek Bottom");
            addBlock(ModBlocks.PLAIN_GREEK_PILLAR.get(c), dn + " Plain Greek Pillar");
            addBlock(ModBlocks.PLAIN_GREEK_TOP.get(c), dn + " Plain Greek Top");
            addBlock(ModBlocks.PLAIN_PILLAR_BOTTOM.get(c), dn + " Plain Pillar Bottom");
            addBlock(ModBlocks.PLAIN_PILLAR.get(c), dn + " Plain Pillar");
            addBlock(ModBlocks.PLAIN_PILLAR_TOP.get(c), dn + " Plain Pillar Top");
            addBlock(ModBlocks.PLAIN_WIDE_PILLAR_BOTTOM.get(c), dn + " Plain Wide Pillar Bottom");
            addBlock(ModBlocks.PLAIN_WIDE_PILLAR.get(c), dn + " Plain Wide Pillar");
            addBlock(ModBlocks.PLAIN_WIDE_PILLAR_TOP.get(c), dn + " Plain Wide Pillar Top");
            addBlock(ModBlocks.GREEK_PILLAR_BOTTOM.get(c), dn + " Greek Pillar Bottom");
            addBlock(ModBlocks.GREEK_PILLAR_TOP.get(c), dn + " Greek Pillar Top");
            addBlock(ModBlocks.GREEK_WIDE_PILLAR_BOTTOM.get(c), dn + " Greek Wide Pillar Bottom");
            addBlock(ModBlocks.GREEK_WIDE_PILLAR_TOP.get(c), dn + " Greek Wide Pillar Top");
            addBlock(ModBlocks.GREEK2_PILLAR_BOTTOM.get(c), dn + " Greek 2 Pillar Bottom");
            addBlock(ModBlocks.GREEK2_PILLAR_TOP.get(c), dn + " Greek 2 Pillar Top");
            addBlock(ModBlocks.PLAIN_SLAB.get(c), dn + " Plain Slab");
            addBlock(ModBlocks.GREEK_SLAB.get(c), dn + " Greek Slab");
            addBlock(ModBlocks.FANCY_BOTTOM.get(c), dn + " Fancy Bottom");
            addBlock(ModBlocks.FANCY_TOP.get(c), dn + " Fancy Top");
            addBlock(ModBlocks.FANCY_GREEK_BOTTOM.get(c), dn + " Fancy Greek Bottom");
            addBlock(ModBlocks.FANCY_GREEK_TOP.get(c), dn + " Fancy Greek Top");
            addBlock(ModBlocks.FANCY_WIDE_BOTTOM.get(c), dn + " Fancy Wide Bottom");
            addBlock(ModBlocks.FANCY_WIDE_TOP.get(c), dn + " Fancy Wide Top");
            addBlock(ModBlocks.FANCY_SLAB.get(c), dn + " Fancy Slab");

            // Torches
            addItem(ModItems.TORCH_ITEMS.get(c), dn + " Torch");

            // Standalone items
            addItem(ModItems.CLAY_BALL.get(c), dn + " Clay Ball");
            addItem(ModItems.CLAY_BRICK.get(c), dn + " Clay Brick");
            addItem(ModItems.MUD_BALL.get(c), dn + " Mud Ball");
            addItem(ModItems.MUD_BRICK.get(c), dn + " Mud Brick");
            addItem(ModItems.DYED_STICK.get(c), dn + " Dyed Stick");
        }

        // Gem ores and compressed gems
        for (EnumGemType gem : EnumGemType.values()) {
            String gn = gemDisplayName(gem);
            addBlock(ModBlocks.GEM_ORE.get(gem), gn + " Ore");
            addBlock(ModBlocks.COMPRESSED_GEM.get(gem), gn + " Block");
            addItem(ModItems.GEM.get(gem), gn);
        }

        // Tools (addItem takes Supplier<? extends Item>, String)
        addItem(ModItems.GEM_SHEARS,  "Gem Shears");
        addItem(ModItems.GEM_HATCHET, "Gem Hatchet");
        addItem(ModItems.GEM_HOE,     "Gem Hoe");
        addItem(ModItems.GEM_PICKAXE, "Gem Pickaxe");
        addItem(ModItems.GEM_SHOVEL,  "Gem Shovel");
        addItem(ModItems.GEM_SWORD,   "Gem Sword");
    }

    private static String displayName(DyeColor c) {
        // Convert enum name to Title Case: LIGHT_BLUE → Light Blue
        String n = c.getName().replace("_", " ");
        StringBuilder sb = new StringBuilder();
        for (String word : n.split(" ")) {
            if (sb.length() > 0) sb.append(' ');
            sb.append(Character.toUpperCase(word.charAt(0)));
            sb.append(word.substring(1));
        }
        return sb.toString();
    }

    private static String gemDisplayName(EnumGemType gem) {
        String n = gem.getName().replace("_", " ");
        StringBuilder sb = new StringBuilder();
        for (String word : n.split(" ")) {
            if (sb.length() > 0) sb.append(' ');
            sb.append(Character.toUpperCase(word.charAt(0)));
            sb.append(word.substring(1));
        }
        return sb.toString();
    }
}
