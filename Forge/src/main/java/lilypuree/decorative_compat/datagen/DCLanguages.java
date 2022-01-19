package lilypuree.decorative_compat.datagen;

import lilypuree.decorative_blocks.Constants;
import lilypuree.decorative_blocks.blocks.types.IWoodType;
import lilypuree.decorative_compat.BOPWoodTypes;
import lilypuree.decorative_compat.DCConstants;
import lilypuree.decorative_compat.core.DCBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.util.StringUtil;
import net.minecraftforge.common.data.LanguageProvider;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

public class DCLanguages extends LanguageProvider {

    public DCLanguages(DataGenerator gen, String locale) {
        super(gen, DCConstants.MODID, locale);
    }

    @Override
    protected void addTranslations() {
        for (IWoodType woodType : BOPWoodTypes.values()){
            String name = capitalize(woodType.toString());
            add(DCBlocks.BEAMS.get(woodType), name + " Beam");
            add(DCBlocks.PALISADES.get(woodType), name + " Palisade");
            add(DCBlocks.SEATS.get(woodType), name + " Seat");
            add(DCBlocks.SUPPORTS.get(woodType), name + " Support");
        }
    }

    protected String capitalize(String other) {
        return Arrays.stream(other.split("_")).map(StringUtils::capitalize).reduce((s1, s2) -> (s1 + " " + s2)).get();
    }
}
