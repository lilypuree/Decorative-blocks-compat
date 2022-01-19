package lilypuree.decorative_compat.datagen;

import lilypuree.decorative_blocks.datagen.BlockStateGenerationHelper;
import lilypuree.decorative_compat.DCConstants;
import lilypuree.decorative_compat.core.DCBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class DCBlockStates extends BlockStateProvider {
    public DCBlockStates(DataGenerator gen, String modid, ExistingFileHelper exFileHelper) {
        super(gen, modid, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        BlockStateGenerationHelper generationHelper = new BlockStateGenerationHelper(DCConstants.MODID, this);
        DCBlocks.BEAMS.values().forEach(generationHelper::beamBlock);
        DCBlocks.PALISADES.values().forEach(generationHelper::palisadeBlock);
        DCBlocks.SEATS.values().forEach(generationHelper::seatBlock);
        DCBlocks.SUPPORTS.values().forEach(generationHelper::supportBlock);
    }
}
