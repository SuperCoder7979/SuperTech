package supercoder79.supertech112.item;

import net.minecraftforge.fml.common.registry.GameRegistry;
import supercoder79.supertech112.item.items.DebugScissors;
import supercoder79.supertech112.item.items.STCoin;

public class SuperTechItems {

    @GameRegistry.ObjectHolder("supertech112:stcoin")
    public static STCoin stcoin = new STCoin();

    @GameRegistry.ObjectHolder("supertech112:debug_scissors")
    public static DebugScissors debugScissors = new DebugScissors();

    public static void initModels() {
        stcoin.initModel();
        debugScissors.initModel();
    }
}
