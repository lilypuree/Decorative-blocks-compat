package lilypuree.decorative_compat.core;

import lilypuree.decorative_blocks.blocks.BeamBlock;
import lilypuree.decorative_blocks.blocks.PalisadeBlock;
import lilypuree.decorative_blocks.blocks.SeatBlock;
import lilypuree.decorative_blocks.blocks.SupportBlock;
import lilypuree.decorative_blocks.blocks.types.IWoodType;
import lilypuree.decorative_blocks.blocks.types.WoodDecorativeBlockTypes;
import lilypuree.decorative_blocks.core.factory.BlockSuppliers;
import lilypuree.decorative_compat.BOPWoodTypes;

import java.util.HashMap;
import java.util.Map;

public class DCBlocks {


    public static Map<IWoodType, BeamBlock> BEAMS = new HashMap<>();
    public static Map<IWoodType, PalisadeBlock> PALISADES = new HashMap<>();
    public static Map<IWoodType, SupportBlock> SUPPORTS = new HashMap<>();
    public static Map<IWoodType, SeatBlock> SEATS = new HashMap<>();


    public static void init() {
        for (IWoodType woodType : BOPWoodTypes.values()) {
            BEAMS.put(woodType, (BeamBlock) BlockSuppliers.createDecorativeBlock(woodType, WoodDecorativeBlockTypes.BEAM));
            PALISADES.put(woodType, (PalisadeBlock) BlockSuppliers.createDecorativeBlock(woodType, WoodDecorativeBlockTypes.PALISADE));
            SUPPORTS.put(woodType, (SupportBlock) BlockSuppliers.createDecorativeBlock(woodType, WoodDecorativeBlockTypes.SUPPORT));
            SEATS.put(woodType, (SeatBlock) BlockSuppliers.createDecorativeBlock(woodType, WoodDecorativeBlockTypes.SEAT));
        }
    }

}
