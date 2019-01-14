package supercoder79.supertech;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import org.apache.logging.log4j.Logger;
import supercoder79.supertech.machines.GUIHandler;
import supercoder79.supertech.api.material.Materials;
import supercoder79.supertech.api.random.SuperTechCreativeTab;
import supercoder79.supertech.block.SuperTechBlocks;
import supercoder79.supertech.proxy.CommonProxy;

@Mod(modid = SuperTech.MODID, name = SuperTech.NAME, version = SuperTech.VERSION)
public class SuperTech {
    /**
     * TODO
     * Add creative tabs
     */

    public static final String MODID = "supertech";
    public static final String NAME = "SuperTech";
    public static final String VERSION = "0.0.1";

    @Mod.Instance(MODID)
    public static SuperTech INSTANCE;

    public static Logger logger;
    public static SuperTechCreativeTab tabMain = new SuperTechCreativeTab("tabST", Item.getItemFromBlock(SuperTechBlocks.computerCube));
    public static SuperTechCreativeTab tabMaterials = new SuperTechCreativeTab("tabSTMaterials", Materials.Gold.dust);

    @SidedProxy(clientSide = "supercoder79.supertech.proxy.ClientProxy", serverSide = "supercoder79.supertech.proxy.CommonProxy")
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        NetworkRegistry.INSTANCE.registerGuiHandler(this, new GUIHandler());
        proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
        tabMain.item = Item.getItemFromBlock(SuperTechBlocks.computerCube);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }
}