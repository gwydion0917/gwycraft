/**
 * 
 */
package gwydion0917.gwycraft.enums;

import net.minecraft.util.IStringSerializable;

/**
 * @author JLB Shecky
 *
 */
public enum EnumGemType implements IStringSerializable {
	QUARTZ(0, "quartz", "quartz"),
	CITRINE(1, "citrine", "citrine"),
	TANZANITE(2, "tanzanite", "tanzanite"),
	SAPPHIRE(3, "sapphire", "sapphire"),
	TOPAZ(4, "topaz", "topaz"),
	AGATE(5, "agate", "agate"),
	GARNET(6, "garnet", "garnet"),
	MOONSTONE(7, "moonstone", "moonstone"),
	HEMATITE(8, "hematite", "hematite"),
	AQUAMARINE(9, "aquamarine", "aquamarine"),
	AMETHYST(10, "amethyst", "amethyst"),
	LAPIS_LAZULI(11, "lapis_lazuli", "lapis_lazuli"),
	TIGERSEYE(12, "tigerseye", "tigerseye"),
	EMERALD(13, "emerald", "emerald"),
	RUBY(14, "ruby", "ruby"),
	ONYX(15, "onyx", "onyx");
	
	private static final EnumGemType[] META_LOOKUP = new EnumGemType[values().length];
	
	private final int meta;
    private final String name;
    private final String unlocalizedName;

    private EnumGemType(int meta, String name, String unlocalizedName) {
    	this.meta = meta;
    	this.name = name;
    	this.unlocalizedName = unlocalizedName;
    }
    
    public int getMetadata() {
        return this.meta;
    }
    
    public String getUnlocalizedName() {
        return this.unlocalizedName;
    }
    
    public String toString() {
        return this.unlocalizedName;
    }
    
    public static EnumGemType byMetadata(int meta) {
    	if(meta < 0 || meta >= META_LOOKUP.length) {
    		meta = 0;
    	}
    	
    	return META_LOOKUP[meta];
    }
    
	@Override
	public String getName() {
		return this.name;
	}

	static {
		for(EnumGemType enumGemType: values()) {
			META_LOOKUP[enumGemType.getMetadata()] = enumGemType;
		}
	}
}
