package supercoder79.supertech.loaders;

import net.minecraftforge.oredict.OreDictionary;
import supercoder79.supertech.api.material.Material;
import supercoder79.supertech.api.material.Materials;

public class OreDictLoader {
    public static void run() {
        for (Material mat: Materials.materialRegistry) {
            if (mat.dust != null) {
                OreDictionary.registerOre("dust" + mat.name.substring(0, 1).toUpperCase() + mat.name.substring(1), mat.dust);
            }
            if (mat.dustTiny != null) {
                OreDictionary.registerOre("dustTiny" + mat.name.substring(0, 1).toUpperCase() + mat.name.substring(1), mat.dustTiny);
            }
            if (mat.ingot != null) {
                OreDictionary.registerOre("ingot" + mat.name.substring(0, 1).toUpperCase() + mat.name.substring(1), mat.ingot);
            }
            if (mat.gem != null) {
                OreDictionary.registerOre("gem" + mat.name.substring(0, 1).toUpperCase() + mat.name.substring(1), mat.gem);
            }
        }
    }
}
