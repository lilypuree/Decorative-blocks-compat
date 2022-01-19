package lilypuree.decorative_compat.core;

import lilypuree.decorative_blocks.Constants;
import lilypuree.decorative_blocks.blocks.types.IWoodType;
import lilypuree.decorative_blocks.core.DBBlocks;
import lilypuree.decorative_blocks.items.SeatItem;
import lilypuree.decorative_blocks.items.SupportItem;
import lilypuree.decorative_compat.BOPWoodTypes;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;

import java.util.HashMap;
import java.util.Map;


public class DCItems {

    public static Map<IWoodType, Item> BEAM_ITEMBLOCKS = new HashMap<>();
    public static Map<IWoodType, Item> SEAT_ITEMBLOCKS = new HashMap<>();
    public static Map<IWoodType, Item> SUPPORT_ITEMBLOCKS = new HashMap<>();
    public static Map<IWoodType, Item> PALISADE_ITEMBLOCKS = new HashMap<>();

    public static void init() {
        Item.Properties dummy = new Item.Properties();
        Item.Properties modItemProperties = new Item.Properties().tab(Constants.ITEM_GROUP);
        for (IWoodType wood : BOPWoodTypes.values()) {
            Item.Properties properties = wood.isAvailable() ? modItemProperties : dummy;
            BEAM_ITEMBLOCKS.put(wood, new BlockItem(DCBlocks.BEAMS.get(wood), properties));
            SEAT_ITEMBLOCKS.put(wood, new SeatItem(DCBlocks.SEATS.get(wood), properties));
            SUPPORT_ITEMBLOCKS.put(wood, new SupportItem(DCBlocks.SUPPORTS.get(wood), properties));
            PALISADE_ITEMBLOCKS.put(wood, new BlockItem(DCBlocks.PALISADES.get(wood), properties));
        }
    }
}
