package gwydion0917.gwycraft;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = "gwycraft", name = "GwyCraft", version = "0.1.9a", guiFactory = "gwydion0917.gwycraft.client.GwyCraftGuiFactory")
public class Gwycraft {

    public static final String[] gwyColorNames = {"White", "Orange", "Magenta", "Light Blue", "Yellow", "Light Green", "Pink", "Dark Grey", "Light Grey", "Cyan", "Purple", "Blue", "Brown", "Green", "Red", "Black"};
    public static final String[] gwyColorLog1Names = {"White", "Orange", "Magenta", "Light Blue"};
    public static final String[] gwyColorLog2Names = {"Yellow", "Light Green", "Pink", "Dark Grey"};
    public static final String[] gwyColorLog3Names = {"Light Grey", "Cyan", "Purple", "Blue"};
    public static final String[] gwyColorLog4Names = {"Brown", "Green", "Red", "Black"};
    public static final String[] gwyColorSlab1Names = {"White", "Orange", "Magenta", "Light Blue", "Yellow", "Light Green", "Pink", "Dark Grey"};
    public static final String[] gwyColorSlab2Names = {"Light Grey", "Cyan", "Purple", "Blue", "Brown", "Green", "Red", "Black"};
    public static final String[] gwyGemNames = {"Enchanted Quartz", "Enchanted Citrine", "Enchanted Tanzanite", "Enchanted Sapphire", "Enchanted Topaz", "Enchanted Agate", "Enchanted Garnet", "Enchanted Moonstone", "Enchanted Hematite", "Enchanted Aquamarine", "Enchanted Amethyst", "Enchanted Lapis Lazuli", "Enchanted Tigerseye", "Enchanted Emerald", "Enchanted Ruby", "Enchanted Onyx"};

    public static GwycraftWorldGenerator worldGen = new GwycraftWorldGenerator();
    public static GwycraftTab tabs = new GwycraftTab("GwyCraft");

    @Instance("Gwycraft")
    public static Gwycraft instance;

    @SidedProxy(clientSide = "gwydion0917.gwycraft.client.ClientProxy", serverSide = "gwydion0917.gwycraft.CommonProxy")
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        LogHelper.trace("Starting Pre-Init");
        FMLCommonHandler.instance().bus().register(new ConfigGwycraft());
        ConfigGwycraft.initConfig(event);

        GwycraftBlocks.init();
        GwycraftItems.init();

        proxy.registerRenderers();

        GwycraftRecipes.init();
       
        LogHelper.trace("Pre-Init Complete");
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        LogHelper.trace("Starting Init");
        GameRegistry.registerWorldGenerator(worldGen, 0);
        LogHelper.trace("Doing IMC");
        InterModCommunication.initIMC();
        LogHelper.trace("Init Complete");
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        // Stub Method
        LogHelper.trace("Starting Post-Init");
        LogHelper.trace("Post-Init Complete");
    }


}