package lilypuree.decorative_compat.datagen;

import lilypuree.decorative_blocks.blocks.types.IWoodType;
import lilypuree.decorative_blocks.datagen.DBItemModels;
import lilypuree.decorative_compat.BOPWoodTypes;
import lilypuree.decorative_compat.DCConstants;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

public class DCItemModels extends ItemModelProvider {
    public DCItemModels(DataGenerator generator, String modid, ExistingFileHelper existingFileHelper) {
        super(generator, modid, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        DBItemModels.ItemGenerationHelper generationHelper = new DBItemModels.ItemGenerationHelper(DCConstants.MODID, this);
        for (IWoodType wood : BOPWoodTypes.values()) {
            getBuilder(wood + "_beam").parent(new ModelFile.UncheckedModelFile(modLoc("block/" + wood + "_beam_y")));
            getBuilder(wood + "_palisade").parent(new ModelFile.UncheckedModelFile(modLoc("block/" + wood + "_palisade_inventory")));
            generationHelper.seatModel(wood);
            generationHelper.supportModel(wood);
        }
    }
}
