package gwydion0917.gwycraft.client;

import com.mojang.blaze3d.matrix.MatrixStack;
import gwydion0917.gwycraft.ConfigGwycraft;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.util.text.StringTextComponent;

public class ConfigScreen extends Screen {

    private final Screen parent;

    private boolean genGemsEnabled;
    private boolean genGemsNether;
    private int     genGemsVeins;
    private int     genGemsNumber;
    private boolean toolsEnabled;
    private boolean toolsHaveEnchants;
    private boolean gemsCraftingEnabled;

    private Button veinsBtn;
    private Button numberBtn;

    public ConfigScreen(Screen parent) {
        super(new StringTextComponent("GwyCraft Config"));
        this.parent = parent;
    }

    @Override
    protected void init() {
        genGemsEnabled      = ConfigGwycraft.GEN_GEMS_ENABLED.get();
        genGemsNether       = ConfigGwycraft.GEN_GEMS_NETHER.get();
        genGemsVeins        = ConfigGwycraft.GEN_GEMS_VEINS.get();
        genGemsNumber       = ConfigGwycraft.GEN_GEMS_NUMBER.get();
        toolsEnabled        = ConfigGwycraft.TOOLS_ENABLED.get();
        toolsHaveEnchants   = ConfigGwycraft.TOOLS_HAVE_ENCHANTS.get();
        gemsCraftingEnabled = ConfigGwycraft.GEMS_CRAFTING_ENABLED.get();

        int bw = 240, bh = 20, lx = width / 2 - bw / 2, y = 40, dy = 24;

        addBoolToggle(lx, y, bw, bh, "Gen Gems (Overworld)", 0); y += dy;
        addBoolToggle(lx, y, bw, bh, "Gen Gems (Nether)",    1); y += dy;
        addBoolToggle(lx, y, bw, bh, "Tools Enabled",        2); y += dy;
        addBoolToggle(lx, y, bw, bh, "Tools Enchanted on Craft", 3); y += dy;
        addBoolToggle(lx, y, bw, bh, "Gems Craftable",       4); y += dy;

        // Veins per chunk
        addButton(new Button(lx,           y, 20, bh, new StringTextComponent("-"),
                btn -> genGemsVeins = Math.max(0, genGemsVeins - 1)));
        veinsBtn = addButton(new Button(lx + 22, y, bw - 44, bh,
                new StringTextComponent(""), btn -> {}));
        veinsBtn.active = false;
        addButton(new Button(lx + bw - 20, y, 20, bh, new StringTextComponent("+"),
                btn -> genGemsVeins = Math.min(256, genGemsVeins + 1)));
        y += dy;

        // Blocks per vein
        addButton(new Button(lx,           y, 20, bh, new StringTextComponent("-"),
                btn -> genGemsNumber = Math.max(0, genGemsNumber - 1)));
        numberBtn = addButton(new Button(lx + 22, y, bw - 44, bh,
                new StringTextComponent(""), btn -> {}));
        numberBtn.active = false;
        addButton(new Button(lx + bw - 20, y, 20, bh, new StringTextComponent("+"),
                btn -> genGemsNumber = Math.min(256, genGemsNumber + 1)));

        addButton(new Button(width / 2 - 105, height - 28, 100, 20,
                new StringTextComponent("Save & Close"), btn -> { save(); onClose(); }));
        addButton(new Button(width / 2 + 5,   height - 28, 100, 20,
                new StringTextComponent("Cancel"), btn -> onClose()));
    }

    private void addBoolToggle(int x, int y, int w, int h, String label, int idx) {
        addButton(new Button(x, y, w, h,
                new StringTextComponent(label + ": " + getBool(idx)),
                btn -> {
                    setBool(idx, !getBool(idx));
                    btn.setMessage(new StringTextComponent(label + ": " + getBool(idx)));
                }));
    }

    private boolean getBool(int idx) {
        switch (idx) {
            case 0: return genGemsEnabled;
            case 1: return genGemsNether;
            case 2: return toolsEnabled;
            case 3: return toolsHaveEnchants;
            case 4: return gemsCraftingEnabled;
            default: return false;
        }
    }

    private void setBool(int idx, boolean v) {
        switch (idx) {
            case 0: genGemsEnabled = v; break;
            case 1: genGemsNether = v; break;
            case 2: toolsEnabled = v; break;
            case 3: toolsHaveEnchants = v; break;
            case 4: gemsCraftingEnabled = v; break;
        }
    }

    @Override
    public void render(MatrixStack ms, int mx, int my, float pt) {
        renderBackground(ms);
        drawCenteredString(ms, font, "GwyCraft Config", width / 2, 15, 0xFFFFFF);
        if (veinsBtn  != null) veinsBtn .setMessage(new StringTextComponent("Gem Veins/Chunk: " + genGemsVeins));
        if (numberBtn != null) numberBtn.setMessage(new StringTextComponent("Blocks/Vein: "     + genGemsNumber));
        super.render(ms, mx, my, pt);
    }

    private void save() {
        ConfigGwycraft.GEN_GEMS_ENABLED.set(genGemsEnabled);
        ConfigGwycraft.GEN_GEMS_NETHER.set(genGemsNether);
        ConfigGwycraft.GEN_GEMS_VEINS.set(genGemsVeins);
        ConfigGwycraft.GEN_GEMS_NUMBER.set(genGemsNumber);
        ConfigGwycraft.TOOLS_ENABLED.set(toolsEnabled);
        ConfigGwycraft.TOOLS_HAVE_ENCHANTS.set(toolsHaveEnchants);
        ConfigGwycraft.GEMS_CRAFTING_ENABLED.set(gemsCraftingEnabled);
    }

    @Override
    public void onClose() {
        minecraft.setScreen(parent);
    }
}
