package lilypuree.decorative_compat;


import lilypuree.decorative_blocks.blocks.types.IWoodType;
import lilypuree.decorative_blocks.blocks.types.WoodDecorativeBlockTypes;
import lilypuree.decorative_compat.core.DCBlocks;
import lilypuree.decorative_compat.core.DCItems;
import net.fabricmc.api.ModInitializer;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;

public class DecorativeCompatFabric implements ModInitializer {

    @Override
    public void onInitialize() {
        DCConstants.isBOPLoaded = true;
        registerBlocks();
        registerItems();
    }

    public void registerBlocks() {
        DCBlocks.init();
        DCBlocks.BEAMS.forEach((wood, block) -> Registry.register(Registry.BLOCK, name(wood, WoodDecorativeBlockTypes.BEAM), block));
        DCBlocks.PALISADES.forEach((wood, block) -> Registry.register(Registry.BLOCK, name(wood, WoodDecorativeBlockTypes.PALISADE), block));
        DCBlocks.SUPPORTS.forEach((wood, block) -> Registry.register(Registry.BLOCK, name(wood, WoodDecorativeBlockTypes.SUPPORT), block));
        DCBlocks.SEATS.forEach((wood, block) -> Registry.register(Registry.BLOCK, name(wood, WoodDecorativeBlockTypes.SEAT), block));
    }

    public static void registerItems() {
        DCItems.init();
        DCItems.BEAM_ITEMBLOCKS.forEach(((wood, item) -> Registry.register(Registry.ITEM, name(wood, WoodDecorativeBlockTypes.BEAM), item)));
        DCItems.PALISADE_ITEMBLOCKS.forEach(((wood, item) -> Registry.register(Registry.ITEM, name(wood, WoodDecorativeBlockTypes.PALISADE), item)));
        DCItems.SUPPORT_ITEMBLOCKS.forEach(((wood, item) -> Registry.register(Registry.ITEM, name(wood, WoodDecorativeBlockTypes.SUPPORT), item)));
        DCItems.SEAT_ITEMBLOCKS.forEach(((wood, item) -> Registry.register(Registry.ITEM, name(wood, WoodDecorativeBlockTypes.SEAT), item)));
    }

    public static ResourceLocation name(IWoodType woodType, WoodDecorativeBlockTypes type) {
        return new ResourceLocation(DCConstants.MODID, woodType + "_" + type);
    }
}
