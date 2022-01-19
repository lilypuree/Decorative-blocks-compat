package lilypuree.decorative_compat.datagen;

import lilypuree.decorative_blocks.blocks.types.IWoodType;
import lilypuree.decorative_blocks.blocks.types.VanillaWoodTypes;
import lilypuree.decorative_blocks.core.DBTags;
import lilypuree.decorative_compat.BOPWoodTypes;
import lilypuree.decorative_compat.core.DCBlocks;
import lilypuree.decorative_compat.core.DCItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

public class DCItemTagsProvider extends ItemTagsProvider {
    public DCItemTagsProvider(DataGenerator pGenerator, BlockTagsProvider pBlockTagsProvider, String modId, @Nullable ExistingFileHelper existingFileHelper) {
        super(pGenerator, pBlockTagsProvider, modId, existingFileHelper);
    }

    @Override
    protected void addTags() {
        for (IWoodType woodType : BOPWoodTypes.values()) {
            tag(DBTags.Items.BEAMS).add(DCItems.BEAM_ITEMBLOCKS.get(woodType));
            tag(DBTags.Items.PALISADES).add(DCItems.PALISADE_ITEMBLOCKS.get(woodType));
            tag(DBTags.Items.SEATS).add(DCItems.SEAT_ITEMBLOCKS.get(woodType));
            tag(DBTags.Items.SUPPORTS).add(DCItems.SUPPORT_ITEMBLOCKS.get(woodType));
            if (!woodType.isFlammable()) {
                tag(ItemTags.NON_FLAMMABLE_WOOD).add(
                        DCItems.BEAM_ITEMBLOCKS.get(woodType),
                        DCItems.PALISADE_ITEMBLOCKS.get(woodType),
                        DCItems.SEAT_ITEMBLOCKS.get(woodType),
                        DCItems.SUPPORT_ITEMBLOCKS.get(woodType));
            }
        }
    }
}
