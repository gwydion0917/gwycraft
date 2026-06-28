package gwydion0917.gwycraft.client;

import gwydion0917.gwycraft.ConfigGwycraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

/**
 * In-game mod config screen for GwyCraft (1.20.1 GUI API).
 * Key changes from 1.16.5:
 * - Screen extends net.minecraft.client.gui.screens.Screen (moved package)
 * - StringTextComponent → Component.literal / Component.translatable
 * - MatrixStack render param → GuiGraphics
 * - drawCenteredString → guiGraphics.drawCenteredString(font, text, x, y, color)
 * - renderBackground(matrixStack) → renderBackground(guiGraphics)
 * - addButton(new Button(...)) → addRenderableWidget(Button.builder(...).bounds(...).build())
 * - GEN_GEMS_VEINS/NUMBER kept in screen for display but note: they are now baked into
 *   datagen PlacedFeatures. The sliders still read/write the config values (they're
 *   harmless as documentation); a note in the UI explains they require a world restart.
 */
public class ConfigScreen extends Screen {

    private final Screen parent;

    // Local state — written to config on Save
    private boolean genGemsEnabled;
    private boolean genGemsNether;
    private int     genGemsVeins;
    private int     genGemsNumber;
    private boolean toolsEnabled;
    private boolean toolsHaveEnchants;
    private boolean gemsCraftingEnabled;

    // Displays (inactive buttons showing numeric values)
    private Button veinsLabel;
    private Button numberLabel;

    public ConfigScreen(Screen parent) {
        super(Component.literal("GwyCraft Config"));
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

        // Veins per chunk (visual only — baked into datagen in 1.20.1)
        addRenderableWidget(Button.builder(Component.literal("-"),
                btn -> { genGemsVeins = Math.max(0, genGemsVeins - 1); updateLabels(); })
                .bounds(lx, y, 20, bh).build());
        veinsLabel = addRenderableWidget(Button.builder(Component.literal(""),
                btn -> {})
                .bounds(lx + 22, y, bw - 44, bh).build());
        veinsLabel.active = false;
        addRenderableWidget(Button.builder(Component.literal("+"),
                btn -> { genGemsVeins = Math.min(256, genGemsVeins + 1); updateLabels(); })
                .bounds(lx + bw - 20, y, 20, bh).build());
        y += dy;

        // Blocks per vein (visual only — baked into datagen in 1.20.1)
        addRenderableWidget(Button.builder(Component.literal("-"),
                btn -> { genGemsNumber = Math.max(0, genGemsNumber - 1); updateLabels(); })
                .bounds(lx, y, 20, bh).build());
        numberLabel = addRenderableWidget(Button.builder(Component.literal(""),
                btn -> {})
                .bounds(lx + 22, y, bw - 44, bh).build());
        numberLabel.active = false;
        addRenderableWidget(Button.builder(Component.literal("+"),
                btn -> { genGemsNumber = Math.min(256, genGemsNumber + 1); updateLabels(); })
                .bounds(lx + bw - 20, y, 20, bh).build());

        // Save / Cancel
        addRenderableWidget(Button.builder(Component.literal("Save & Close"),
                btn -> { save(); onClose(); })
                .bounds(width / 2 - 105, height - 28, 100, 20).build());
        addRenderableWidget(Button.builder(Component.literal("Cancel"),
                btn -> onClose())
                .bounds(width / 2 + 5, height - 28, 100, 20).build());

        updateLabels();
    }

    private void addBoolToggle(int x, int y, int w, int h, String label, int idx) {
        final String[] l = {label};  // effectively final for lambda capture
        addRenderableWidget(Button.builder(
                Component.literal(label + ": " + getBool(idx)),
                btn -> {
                    setBool(idx, !getBool(idx));
                    btn.setMessage(Component.literal(l[0] + ": " + getBool(idx)));
                }).bounds(x, y, w, h).build());
    }

    private void updateLabels() {
        if (veinsLabel  != null) veinsLabel .setMessage(Component.literal("Gem Veins/Chunk: " + genGemsVeins + " (stored)"));
        if (numberLabel != null) numberLabel.setMessage(Component.literal("Blocks/Vein: "     + genGemsNumber + " (stored)"));
    }

    private boolean getBool(int idx) {
        return switch (idx) {
            case 0 -> genGemsEnabled;
            case 1 -> genGemsNether;
            case 2 -> toolsEnabled;
            case 3 -> toolsHaveEnchants;
            case 4 -> gemsCraftingEnabled;
            default -> false;
        };
    }

    private void setBool(int idx, boolean v) {
        switch (idx) {
            case 0 -> genGemsEnabled = v;
            case 1 -> genGemsNether = v;
            case 2 -> toolsEnabled = v;
            case 3 -> toolsHaveEnchants = v;
            case 4 -> gemsCraftingEnabled = v;
        }
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mx, int my, float pt) {
        renderBackground(guiGraphics);
        guiGraphics.drawCenteredString(font, "GwyCraft Config", width / 2, 15, 0xFFFFFF);
        guiGraphics.drawCenteredString(font,
                "§7(Veins/Blocks sliders are stored only; generation is baked into datagen)",
                width / 2, height - 44, 0xFFFFFF);
        super.render(guiGraphics, mx, my, pt);
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
