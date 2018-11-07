package supercoder79.supertech.config;

import net.minecraftforge.common.config.Config;
import supercoder79.supertech.SuperTech;

@Config(modid = SuperTech.MODID)
public class SuperTechConfig {
    @Config.Comment("config test")
    public static boolean something = true;
}
