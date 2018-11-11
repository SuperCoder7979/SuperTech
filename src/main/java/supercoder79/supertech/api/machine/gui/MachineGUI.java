package supercoder79.supertech.api.machine.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import supercoder79.supertech.SuperTech;
import supercoder79.supertech.api.machine.tileentity.TileEntityMachine;

public class MachineGUI extends GuiContainer {
    protected static ResourceLocation BACKGROUND;

    protected InventoryPlayer playerInv;
    protected TileEntityMachine tile;

    protected String name = "SuperTech Machine";

    public MachineGUI(Container container, InventoryPlayer playerInv, TileEntityMachine tileEntity, ResourceLocation resourceLocation, String name) {
        super(container);
        BACKGROUND = resourceLocation;
        this.playerInv = playerInv;
        this.tile = tileEntity;
        this.name = name;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GlStateManager.color(1, 1, 1, 1);
        mc.getTextureManager().bindTexture(BACKGROUND);
        int x = (width - xSize) / 2;
        int y = (height - ySize) / 2;

        drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
        }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        this.drawDefaultBackground();
        super.drawScreen(mouseX, mouseY, partialTicks);
        this.renderHoveredToolTip(mouseX, mouseY);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {

        fontRenderer.drawString(name, xSize / 2 - fontRenderer.getStringWidth(name) / 2, 6, 0x404040);
        fontRenderer.drawString(playerInv.getDisplayName().getUnformattedText(), 8, ySize - 94, 0x404040);
    }

    @Override
    public void updateScreen() {

    }
}
