package gwydion0917.gwycraft.data;

import gwydion0917.gwycraft.Gwycraft;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

/**
 * Item model provider for GwyCraft.
 * Like ModBlockStateProvider, all item model JSON files are already written
 * to src/main/resources/assets/gwycraft/models/item/ — both the original
 * per-color models from the 1.12 port AND the new registry-name-aliased models
 * written by the Python migration script.
 * This provider is present as a hook for future generated item models.
 */
public class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(PackOutput output, ExistingFileHelper efh) {
        super(output, Gwycraft.MOD_ID, efh);
    }

    @Override
    protected void registerModels() {
        // Intentionally empty — models are hand-authored in src/main/resources.
    }
}
