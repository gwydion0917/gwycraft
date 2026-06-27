package gwydion0917.gwycraft.enums;

/**
 * The 16 enchanted gem types used for items, ore blocks, and compressed blocks.
 * Metadata-based identity was removed in the 1.13 flattening; this enum is now
 * used purely for naming and iteration — each gem type maps to separate blocks/items.
 */
public enum EnumGemType {
    QUARTZ(0, "quartz"),
    CITRINE(1, "citrine"),
    TANZANITE(2, "tanzanite"),
    SAPPHIRE(3, "sapphire"),
    TOPAZ(4, "topaz"),
    AGATE(5, "agate"),
    GARNET(6, "garnet"),
    MOONSTONE(7, "moonstone"),
    HEMATITE(8, "hematite"),
    AQUAMARINE(9, "aquamarine"),
    AMETHYST(10, "amethyst"),
    LAPIS_LAZULI(11, "lapis_lazuli"),
    TIGERSEYE(12, "tigerseye"),
    EMERALD(13, "emerald"),
    RUBY(14, "ruby"),
    ONYX(15, "onyx");

    private static final EnumGemType[] BY_INDEX = values();

    private final int index;
    private final String name;

    EnumGemType(int index, String name) {
        this.index = index;
        this.name = name;
    }

    public int getIndex() { return index; }

    public String getName() { return name; }

    @Override
    public String toString() { return name; }

    /** Safe lookup by ordinal / old metadata value (clamped to valid range). */
    public static EnumGemType byIndex(int idx) {
        if (idx < 0 || idx >= BY_INDEX.length) idx = 0;
        return BY_INDEX[idx];
    }
}
