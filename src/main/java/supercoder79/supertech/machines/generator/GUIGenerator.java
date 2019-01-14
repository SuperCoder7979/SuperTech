package supercoder79.supertech.machines.generator;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;
import supercoder79.supertech.SuperTech;
import supercoder79.supertech.api.machine.gui.MachineGUI;

public class GUIGenerator extends MachineGUI {
    TileEntityGenerator generator;
    public GUIGenerator(Container container, InventoryPlayer playerInv, TileEntityGenerator tileEntity) {
        super(container, playerInv, tileEntity,  new ResourceLocation(SuperTech.MODID, "textures/machines/gui_generator.png"), "Generator");
        generator = tileEntity;

    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GlStateManager.color(1, 1, 1, 1);
        mc.getTextureManager().bindTexture(BACKGROUND);
        int x = (width - xSize) / 2;
        int y = (height - ySize) / 2;

        drawTexturedModalRect(x, y, 0, 0, xSize, ySize);

        int amt = (int)(((double)generator.getField(0)/(double)generator.maxEnergy)*25);
        if (amt > 25) amt = 25;
        drawTexturedModalRect(x + 105, y + 54 - amt, 176, 55 - amt, 8, amt);

        if (generator.getField(1) > 0) {
            if (generator.getField(0) != generator.maxEnergy) drawTexturedModalRect(x + 79, y+ 34, 176, 14, 24, 17);
            int k = (int)(((double)generator.getField(1)/(double)generator.getField(2))*12);
            this.drawTexturedModalRect(x + 56, y + 36 + 12 - k, 176, 12 - k, 14, k + 1);
        }

    }
}
