package supercoder79.supertech112;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.Logger;
import supercoder79.supertech112.api.material.Materials;
import supercoder79.supertech112.api.random.SuperTechCreativeTab;
import supercoder79.supertech112.block.SuperTechBlocks;

@Mod(SuperTech.MODID)
public class SuperTech {
    /**
     * TODO
     * Add creative tabs
     */

    public static final String MODID = "supertech112";
    public static final String NAME = "SuperTech";
    public static final String VERSION = "0.0.1";

    //@Mod.Instance(MODID)
    public static SuperTech INSTANCE;

    public static Logger logger;
    public static SuperTechCreativeTab tabMain = new SuperTechCreativeTab("tabST", Item.getItemFromBlock(SuperTechBlocks.computerCube));
    public static SuperTechCreativeTab tabMaterials = new SuperTechCreativeTab("tabSTMaterials", Materials.Gold.dust);

    SuperTech() {
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::preInit);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    public void preInit(FMLCommonSetupEvent event) {
        //logger = event.getModLog();
        //NetworkRegistry.registerGuiHandler(this, new GUIHandler());
        proxy.preInit(event);

        //from old init
        tabMain.item = Item.getItemFromBlock(SuperTechBlocks.computerCube);
    }

    public void clientSetup(FMLClientSetupEvent event) {

    }
}