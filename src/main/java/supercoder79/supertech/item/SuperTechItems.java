package supercoder79.supertech.item;

import net.minecraftforge.fml.common.registry.GameRegistry;
import supercoder79.supertech.item.items.STCoin;

public class SuperTechItems {

    @GameRegistry.ObjectHolder("supertech:stcoin")
    public static STCoin stcoin = new STCoin();

    public static void initModels() {
        stcoin.initModel();
    }
}
