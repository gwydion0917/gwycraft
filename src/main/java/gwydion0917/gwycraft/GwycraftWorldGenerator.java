package gwydion0917.gwycraft;

import java.util.Random;

import com.google.common.base.Predicate;

import gwydion0917.gwycraft.blocks.BlockGemOre;
import gwydion0917.gwycraft.blocks.GwycraftBlocks;
import gwydion0917.gwycraft.enums.EnumGemType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

public class GwycraftWorldGenerator implements IWorldGenerator {
	private void generateEnd(World world, Random rand, int chunkX, int chunkZ) {}

	private void generateSurface(World world, Random rand, int chunkX, int chunkZ) {
		if (ConfigGwycraft.genGemsEnabled) {
			for (int k = 0; k < ConfigGwycraft.genGemsVeins; k++) {
				int x = chunkX + rand.nextInt(16);
				int y = rand.nextInt(64);
				int z = chunkZ + rand.nextInt(16);
				IBlockState oreState = GwycraftBlocks.blockGemOre.getDefaultState()
						.withProperty(BlockGemOre.GEMTYPE, EnumGemType.byMetadata(rand.nextInt(16)));
				new WorldGenMinable(oreState, ConfigGwycraft.genGemsNumber).generate(world, rand, new BlockPos(x, y, z));
			}
		}
	}

	private void generateNether(World world, Random rand, int chunkX, int chunkZ) {
		if (ConfigGwycraft.genGemsNether) {
			for (int k = 0; k < ConfigGwycraft.genGemsVeins; k++) {
				int x = chunkX + rand.nextInt(16);
				int y = rand.nextInt(64);
				int z = chunkZ + rand.nextInt(16);
				IBlockState oreState = GwycraftBlocks.blockGemOre.getDefaultState()
						.withProperty(BlockGemOre.GEMTYPE, EnumGemType.byMetadata(rand.nextInt(16)));
				new WorldGenMinable(oreState, ConfigGwycraft.genGemsNumber,
						new Predicate<IBlockState>() {
							public boolean apply(IBlockState state) {
								return state.getBlock() == Blocks.NETHERRACK;
							}
						}).generate(world, rand, new BlockPos(x, y, z));
			}
		}
	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
		// TODO Auto-generated method stub
		switch(world.provider.getDimension()){
		case -1:
			generateNether(world, random, chunkX * 16, chunkZ * 16);
			break;
		case 0:
			generateSurface(world, random, chunkX * 16, chunkZ * 16);
			break;
		case 1:
			generateEnd(world, random, chunkX * 16, chunkZ * 16);
			break;
		default:
			generateSurface(world, random, chunkX * 16, chunkZ * 16);
			break;
		}
	}
}