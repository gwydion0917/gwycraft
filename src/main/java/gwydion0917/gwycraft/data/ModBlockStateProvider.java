package gwydion0917.gwycraft.data;

import gwydion0917.gwycraft.Gwycraft;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

/**
 * BlockState provider for GwyCraft.
 * All blockstate JSON files are already written directly to src/main/resources/assets/gwycraft/blockstates/
 * during the asset migration phase (one JSON per block, per color).
 * This provider is present as a hook — it currently does nothing because all blockstates
 * were written by the Python migration script.  If you need to regenerate blockstates
 * (e.g. after adding new block families), do it via the Python script or add builders here.
 */
public class ModBlockStateProvider extends BlockStateProvider {

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper efh) {
        super(output, Gwycraft.MOD_ID, efh);
    }

    @Override
    protected void registerStatesAndModels() {
        // Intentionally empty — blockstates are hand-authored in src/main/resources.
        // The asset migration script wrote per-color JSON files for every block family.
    }
}
