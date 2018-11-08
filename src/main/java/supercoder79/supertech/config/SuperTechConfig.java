package supercoder79.supertech.config;

import net.minecraftforge.common.config.Config;
import supercoder79.supertech.SuperTech;

@Config(modid = SuperTech.MODID)
public class SuperTechConfig {
    @Config.Comment("Set this to true if you want massive lag on worldgeneration")
    public static boolean RNGsus_Whisperer = false;

    @Config.Comment("Whether to generate or disable my ores")
    public static boolean Generate_Ores = true;

    @Config.Comment("Makes the world generator generate only one of each ore texture")
    public static boolean Disable_Mixed_Ores = false;
}
