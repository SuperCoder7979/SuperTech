package supercoder79.supertech.api.material;

import supercoder79.supertech.block.SuperTechBlocks;
import supercoder79.supertech.block.blocks.Ore;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;

public class MaterialModelGenerator {

    //Model generator code adapted from Archengius and Exidex.
    public static final String MATERIALITEM =
            "{\n" +
                    "    \"parent\": \"item/generated\",\n" +
                    "    \"textures\": {\n" +
                    "        \"layer0\": \"$NAME$\"\n" +
                    "    }\n" +
                    "}";
    public static final String BLOCKMODEL_ORE =
            "{\n" +
                "  \"parent\": \"block/cube_all\",\n" +
                "  \"textures\": {\n" +
                "    \"all\": \"$NAME$\"\n" +
                "  }\n" +
                "}";
    public static final String BLOCKSTATE_ORE =
            "{\n" +
            "  \"forge_marker\": 1,\n" +
            "  \"defaults\": {\n" +
            "    \"model\": \"$NAME$\"\n" +
            "  },\n" +
            "  \"variants\": {\n" +
            "    \"normal\": [{}],\n" +
            "    \"inventory\": [{}]\n" +
            "  }\n" +
            "}";

    public static final String TEX_NAME = "supertech:items/materials/";
    public static final String BLOCK_NAME = "supertech:blocks/ores/";

    public static final String LOC_NAME = "item.supertech.";
    public static final String BLOCK_LOC_NAME = "item.supertech.";
    public static ArrayList<String> locs = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        File assets = new File("src/main/resources/assets/supertech");
        File materials = new File(assets, "models/item/materials");
        File blockmodels = new File(assets, "models/block/ores");
        File blockstates = new File(assets, "blockstates");
        String data;
        File json;
        for (Material mat : Materials.materialRegistry) {
            System.out.println(mat);

            switch (mat.getFlags()) {
                case 0:
                    break;
                case 1:
                    data = MATERIALITEM;
                    data = data.replace("$NAME$", TEX_NAME + "dust_"+mat.getName());
                    json = new File(materials, "dust_"+mat.getName()+".json");
                    System.out.println(data);
                    Files.write(json.toPath(), Arrays.asList(data.split("\n")));
                    locs.add(LOC_NAME+"dust_"+mat.getName()+".name=" + mat.getName().substring(0, 1).toUpperCase() + mat.getName().substring(1) + " Dust");
                    data = MATERIALITEM;
                    data = data.replace("$NAME$", TEX_NAME + "dust_tiny_"+mat.getName());
                    json = new File(materials, "dust_tiny_"+mat.getName()+".json");
                    locs.add(LOC_NAME+"dust_tiny_"+mat.getName()+".name=" + mat.getName().substring(0, 1).toUpperCase() + mat.getName().substring(1) + " Tiny Dust");
                    System.out.println(data);
                    Files.write(json.toPath(), Arrays.asList(data.split("\n")));
                    break;
                case 2:
                    data = MATERIALITEM;
                    data = data.replace("$NAME$", TEX_NAME + "dust_tiny_"+mat.getName());
                    json = new File(materials, "dust_tiny_"+mat.getName()+".json");
                    locs.add(LOC_NAME+"dust_tiny_"+mat.getName()+".name=" + mat.getName().substring(0, 1).toUpperCase() + mat.getName().substring(1) + " Tiny Dust");
                    System.out.println(data);
                    Files.write(json.toPath(), Arrays.asList(data.split("\n")));
                    break;
                case 3:
                    data = MATERIALITEM;
                    data = data.replace("$NAME$", TEX_NAME + "dust_"+mat.getName());
                    json = new File(materials, "dust_"+mat.getName()+".json");
                    locs.add(LOC_NAME+"dust_"+mat.getName()+".name=" + mat.getName().substring(0, 1).toUpperCase() + mat.getName().substring(1) + " Dust");
                    System.out.println(data);
                    Files.write(json.toPath(), Arrays.asList(data.split("\n")));
                    data = MATERIALITEM;
                    data = data.replace("$NAME$", TEX_NAME + "dust_tiny_"+mat.getName());
                    locs.add(LOC_NAME+"dust_tiny_"+mat.getName()+".name=" + mat.getName().substring(0, 1).toUpperCase() + mat.getName().substring(1) + " Tiny Dust");
                    json = new File(materials, "dust_tiny_"+mat.getName()+".json");
                    System.out.println(data);
                    Files.write(json.toPath(), Arrays.asList(data.split("\n")));
                    data = MATERIALITEM;
                    data = data.replace("$NAME$", TEX_NAME + "ingot_"+mat.getName());
                    json = new File(materials, "ingot_"+mat.getName()+".json");
                    locs.add(LOC_NAME+"ingot_"+mat.getName()+".name=" + mat.getName().substring(0, 1).toUpperCase() + mat.getName().substring(1) + " Ingot");
                    System.out.println(data);
                    Files.write(json.toPath(), Arrays.asList(data.split("\n")));
                    break;
            }

        }
        for (String o: new String[] {"ore_lead"}) {
            data = BLOCKSTATE_ORE;
            data = data.replace("$NAME$", "supertech:" + o);
            json = new File(blockstates, o + ".json");
            Files.write(json.toPath(), Arrays.asList(data.split("\n")));
            data = BLOCKMODEL_ORE;
            data = data.replace("$NAME$", BLOCK_NAME + o);
            json = new File(blockmodels, o + ".json");
            Files.write(json.toPath(), Arrays.asList(data.split("\n")));

            String[] names = o.split("_");
            String orename = names[1].substring(0, 1).toUpperCase() + names[1].substring(1) + " Ore";
            locs.add(BLOCK_LOC_NAME + orename);
        }


        System.out.println("Localizations:");
        for (String s: locs) {
            System.out.println(s);
        }
    }
}
