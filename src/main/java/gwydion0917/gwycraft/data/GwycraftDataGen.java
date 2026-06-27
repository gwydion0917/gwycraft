package gwydion0917.gwycraft.data;

import gwydion0917.gwycraft.Gwycraft;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

/**
 * Entry point for all GwyCraft data generators.
 * Triggered by the 'data' run configuration: ./gradlew runData
 * Output is written to src/generated/resources/.
 */
public class GwycraftDataGen {

    public static void gatherData(GatherDataEvent event) {
        net.minecraftforge.common.data.ExistingFileHelper efh = event.getExistingFileHelper();

        if (event.includeServer()) {
            event.getGenerator().addProvider(new ModRecipeProvider(event.getGenerator()));
            event.getGenerator().addProvider(new ModLootTableProvider(event.getGenerator()));
            ModTagsProvider.GwycraftBlockTags blockTagsProv =
                    new ModTagsProvider.GwycraftBlockTags(event.getGenerator(), efh);
            event.getGenerator().addProvider(blockTagsProv);
            event.getGenerator().addProvider(
                    new ModTagsProvider.GwycraftItemTags(event.getGenerator(), blockTagsProv, efh));
        }

        if (event.includeClient()) {
            event.getGenerator().addProvider(new ModBlockStateProvider(event.getGenerator(), efh));
            event.getGenerator().addProvider(new ModItemModelProvider(event.getGenerator(), efh));
            event.getGenerator().addProvider(new ModLanguageProvider(event.getGenerator()));
        }
    }
}
