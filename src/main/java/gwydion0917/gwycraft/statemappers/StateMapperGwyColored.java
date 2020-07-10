package gwydion0917.gwycraft.statemappers;

import java.util.Map;

import com.google.common.collect.Maps;

import net.minecraft.block.Block;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.util.ResourceLocation;

public class StateMapperGwyColored extends StateMapperBase {

	public StateMapperGwyColored() { }

	@Override
	protected ModelResourceLocation getModelResourceLocation(IBlockState state) {
        Map < IProperty<?>, Comparable<? >> map = Maps. < IProperty<?>, Comparable<? >> newLinkedHashMap(state.getProperties());
        String s;

        s = ((ResourceLocation)Block.REGISTRY.getNameForObject(state.getBlock())).toString().replace("glowy_", "");
        
        return new ModelResourceLocation(s, this.getPropertyString(map));
    }
}
