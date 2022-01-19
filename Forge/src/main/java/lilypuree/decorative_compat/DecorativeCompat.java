package lilypuree.decorative_compat;

import lilypuree.decorative_compat.core.DCBlocks;
import lilypuree.decorative_compat.core.DCItems;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.IForgeRegistry;

@Mod(DCConstants.MODID)
public class DecorativeCompat {

    public DecorativeCompat() {
        DCConstants.isBOPLoaded = ModList.get().isLoaded(DCConstants.BOP_MODID);
        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();

        modBus.addGenericListener(Block.class, this::registerBlocks);
        modBus.addGenericListener(Item.class, this::registerItems);
    }

    public void registerBlocks(RegistryEvent.Register<Block> event) {
        DCBlocks.init();
        IForgeRegistry<Block> registry = event.getRegistry();
        DCBlocks.BEAMS.forEach((wood, block) -> registry.register(block.setRegistryName(wood + "_beam")));
        DCBlocks.PALISADES.forEach((wood, block) -> registry.register(block.setRegistryName(wood + "_palisade")));
        DCBlocks.SUPPORTS.forEach((wood, block) -> registry.register(block.setRegistryName(wood + "_support")));
        DCBlocks.SEATS.forEach((wood, block) -> registry.register(block.setRegistryName(wood + "_seat")));
    }

    public void registerItems(RegistryEvent.Register<Item> event) {
        DCItems.init();
        IForgeRegistry<Item> registry = event.getRegistry();
        DCItems.BEAM_ITEMBLOCKS.forEach((wood, item) -> registry.register(item.setRegistryName(wood + "_beam")));
        DCItems.PALISADE_ITEMBLOCKS.forEach((wood, item) -> registry.register(item.setRegistryName(wood + "_palisade")));
        DCItems.SUPPORT_ITEMBLOCKS.forEach((wood, item) -> registry.register(item.setRegistryName(wood + "_support")));
        DCItems.SEAT_ITEMBLOCKS.forEach((wood, item) -> registry.register(item.setRegistryName(wood + "_seat")));
    }
}
