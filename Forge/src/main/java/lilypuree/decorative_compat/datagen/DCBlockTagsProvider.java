package lilypuree.decorative_compat.datagen;

import lilypuree.decorative_blocks.blocks.types.IWoodType;
import lilypuree.decorative_blocks.blocks.types.VanillaWoodTypes;
import lilypuree.decorative_blocks.core.DBTags;
import lilypuree.decorative_compat.BOPWoodTypes;
import lilypuree.decorative_compat.core.DCBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

public class DCBlockTagsProvider extends BlockTagsProvider {
    public DCBlockTagsProvider(DataGenerator pGenerator, String modId, @Nullable ExistingFileHelper existingFileHelper) {
        super(pGenerator, modId, existingFileHelper);
    }

    @Override
    protected void addTags() {
        for (IWoodType woodType : BOPWoodTypes.values()) {
            tag(DBTags.Blocks.BEAMS).add(DCBlocks.BEAMS.get(woodType));
            tag(DBTags.Blocks.PALISADES).add(DCBlocks.PALISADES.get(woodType));
            tag(DBTags.Blocks.SEATS).add(DCBlocks.SEATS.get(woodType));
            tag(DBTags.Blocks.SUPPORTS).add(DCBlocks.SUPPORTS.get(woodType));
            if (!woodType.isFlammable()) {
                tag(BlockTags.NON_FLAMMABLE_WOOD).add(DCBlocks.BEAMS.get(woodType),
                        DCBlocks.PALISADES.get(woodType),
                        DCBlocks.SEATS.get(woodType),
                        DCBlocks.SUPPORTS.get(woodType));
            }
        }
    }
}
