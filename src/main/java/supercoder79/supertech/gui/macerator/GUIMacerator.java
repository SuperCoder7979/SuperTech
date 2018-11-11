package supercoder79.supertech.gui.macerator;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;
import supercoder79.supertech.SuperTech;
import supercoder79.supertech.api.machine.gui.MachineGUI;
import supercoder79.supertech.api.machine.tileentity.TileEntityMachine;

public class GUIMacerator extends MachineGUI {
    TileEntityMacerator te;
    public GUIMacerator(Container container, InventoryPlayer playerInv, TileEntityMacerator tileEntity) {
        super(container, playerInv, tileEntity, new ResourceLocation(SuperTech.MODID, "textures/gui/gui_macerator.png"), "Macerator");
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
        drawTexturedModalRect(x + 9, y + 65 - amt, 176, 65 - amt, 12, amt);

        if (te.getField(2) > 0) {
            int length = (int)(((double)te.getField(1)/(double)te.getField(2))*20);
            drawTexturedModalRect(x + 69, y + 24, 176, 0, 20 - length, 18);
        }

    }
}
