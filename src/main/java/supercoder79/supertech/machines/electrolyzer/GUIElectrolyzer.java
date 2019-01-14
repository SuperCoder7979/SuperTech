package supercoder79.supertech.machines.electrolyzer;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;
import supercoder79.supertech.SuperTech;
import supercoder79.supertech.api.machine.gui.MachineGUI;

public class GUIElectrolyzer extends MachineGUI {
    TileEntityElectrolyzer te;
    public GUIElectrolyzer(Container container, InventoryPlayer playerInv, TileEntityElectrolyzer tileEntity) {
        super(container, playerInv, tileEntity, new ResourceLocation(SuperTech.MODID, "textures/machines/gui_electrolyzer.png"), "Electrolyzer");
        te = tileEntity;
    }
    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GlStateManager.color(1, 1, 1, 1);
        mc.getTextureManager().bindTexture(BACKGROUND);
        int x = (width - xSize) / 2;
        int y = (height - ySize) / 2;

        drawTexturedModalRect(x, y, 0, 0, xSize, ySize);

        int amt = (int)(((double)te.getField(0)/(double)te.maxEnergy)*48);
        if (amt > 48) amt = 48;
        drawTexturedModalRect(x + 9, y + 66 - amt, 176, 58 - amt, 12, amt);

        if (te.getField(2) > 0) {
            int height = (int)(((double)(te.getField(2) - te.getField(1))/(double)te.getField(2))*10);
            drawTexturedModalRect(x + 73, y + 44 - height, 176, 10 - height, 30, height);
        }
    }
}
