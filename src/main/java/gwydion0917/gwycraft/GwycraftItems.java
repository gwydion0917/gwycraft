package gwydion0917.gwycraft;

import java.util.ArrayList;
import java.util.List;

import gwydion0917.gwycraft.interfaces.MultiItem;
import gwydion0917.gwycraft.items.ItemDyedItem;
import gwydion0917.gwycraft.items.ItemEnchantedGems;
import gwydion0917.gwycraft.items.ItemGemHatchet;
import gwydion0917.gwycraft.items.ItemGemHoe;
import gwydion0917.gwycraft.items.ItemGemPickaxe;
import gwydion0917.gwycraft.items.ItemGemShears;
import gwydion0917.gwycraft.items.ItemGemShovel;
import gwydion0917.gwycraft.items.ItemGemSword;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.oredict.OreDictionary;

public class GwycraftItems {

	public static Item itemEnchantedGems;
	public static Item itemDyedClay;
	public static Item itemDyedClayBricks;
	public static Item itemDyedMud;
	public static Item itemDyedMudBricks;
	public static Item itemDyedSticks;
	public static Item itemGemShears;
	public static Item itemGemHatchet;
	public static Item itemGemHoe;
	public static Item itemGemPickaxe;
	public static Item itemGemShovel;
	public static Item itemGemSword;
	
	public static List <MultiItem>ItemRenderers = new ArrayList<MultiItem>();

	public static ToolMaterial GWYCRAFT_MATERIAL = EnumHelper.addToolMaterial("GWYCRAFT_MATERIAL", 2, 500, 8.0F, 2.0F, 22);

	public static void init() {
		createItems();
		registerItems();
	}

	private static void createItems() {
		ItemRenderers.add((MultiItem) (itemEnchantedGems = new ItemEnchantedGems("gem")));
		ItemRenderers.add((MultiItem) (itemDyedClay = new ItemDyedItem("clay")));
		ItemRenderers.add((MultiItem) (itemDyedClayBricks = new ItemDyedItem("claybrick")));
		ItemRenderers.add((MultiItem) (itemDyedMud = new ItemDyedItem("mud")));
		ItemRenderers.add((MultiItem) (itemDyedMudBricks = new ItemDyedItem("mudbrick")));
		ItemRenderers.add((MultiItem) (itemDyedSticks = new ItemDyedItem("stick")));
		
		itemGemShears = new ItemGemShears("gem_shears");
		itemGemHatchet = new ItemGemHatchet(GWYCRAFT_MATERIAL, "gem_hatchet");
		itemGemHoe = new ItemGemHoe(GWYCRAFT_MATERIAL, "gem_hoe");
		itemGemPickaxe = new ItemGemPickaxe(GWYCRAFT_MATERIAL, "gem_pickaxe");
		itemGemShovel = new ItemGemShovel(GWYCRAFT_MATERIAL, "gem_shovel");
		itemGemSword = new ItemGemSword(GWYCRAFT_MATERIAL, "gem_sword");
	}

	private static void registerItems() {
		// Ore Dictionary
		OreDictionary.registerOre("gemGwycraft", new ItemStack(itemEnchantedGems, 1, OreDictionary.WILDCARD_VALUE));
	}

	public static void registerRenders() {
		for(MultiItem item : ItemRenderers) {
			item.registerBlockRenders();
		}
		
		// Register the tool renders
        registerTool(itemGemShears);
        registerTool(itemGemHatchet);
        registerTool(itemGemHoe);
        registerTool(itemGemPickaxe);
        registerTool(itemGemShovel);
        registerTool(itemGemSword);
	}
	
	private static void registerTool(final Item item) {
		ModelLoader.setCustomMeshDefinition(item, new ItemMeshDefinition() {
            public ModelResourceLocation getModelLocation(ItemStack stack)
            {
                return new ModelResourceLocation(item.getRegistryName(), "inventory");
            }
        });
	}

}
