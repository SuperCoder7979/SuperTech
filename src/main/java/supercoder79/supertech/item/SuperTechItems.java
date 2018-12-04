package supercoder79.supertech.item;

import net.minecraftforge.fml.common.registry.GameRegistry;
import supercoder79.supertech.item.items.DebugScissors;
import supercoder79.supertech.item.items.STCoin;

public class SuperTechItems {

    @GameRegistry.ObjectHolder("supertech:stcoin")
    public static STCoin stcoin = new STCoin();

    @GameRegistry.ObjectHolder("supertech:debug_scissors")
    public static DebugScissors debugScissors = new DebugScissors();

    public static void initModels() {
        stcoin.initModel();
        debugScissors.initModel();
    }
}
