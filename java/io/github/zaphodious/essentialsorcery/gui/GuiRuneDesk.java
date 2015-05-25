package io.github.zaphodious.essentialsorcery.gui;

import io.github.zaphodious.essentialsorcery.container.ContainerRuneTable;
import io.github.zaphodious.essentialsorcery.core.Reference;
import io.github.zaphodious.essentialsorcery.tileentities.TileEntityRuneTable;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;



@SideOnly(Side.CLIENT)
public class GuiRuneDesk  extends GuiContainer
{
    private static final ResourceLocation runeDeskGuiTextures = 
         new ResourceLocation(Reference.MODID
               +":textures/client/gui/rune_table.png");
    private final InventoryPlayer inventoryPlayer;
    private final IInventory tileRuneDesk;
    /** The X size of the inventory window in pixels. */
    protected int xSize = 176;
    /** The Y size of the inventory window in pixels. */
    protected int ySize = 132;

    public GuiRuneDesk(InventoryPlayer parInventoryPlayer, 
          TileEntityRuneTable parInventoryRuneTable)
    {
        super(new ContainerRuneTable(parInventoryPlayer, 
              parInventoryRuneTable));
        inventoryPlayer = parInventoryPlayer;
        tileRuneDesk = parInventoryRuneTable;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
    {
        String s = tileRuneDesk.getDisplayName().getUnformattedText();
        fontRendererObj.drawString(s, 6, 24, 4210752);
        fontRendererObj.drawString(inventoryPlayer.getDisplayName()
              .getUnformattedText(), 6, 52 + 2, 4210752);
    }

    /**
     * Args : renderPartialTicks, mouseX, mouseY
     */
    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, 
          int mouseX, int mouseY)
    {
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        mc.getTextureManager().bindTexture(runeDeskGuiTextures);
        int marginHorizontal = (width - this.xSize) / 2;
        int marginVertical = (height - this.ySize) / 2;
        drawTexturedModalRect(marginHorizontal, marginVertical, 0, 0, 
               176, 132);

        // Draw progress indicator
        int progressLevel = getProgressLevel(24);
        drawTexturedModalRect(marginHorizontal + 79, marginVertical + 34, 
              176, 14, progressLevel + 1, 16);
    }

    private int getProgressLevel(int progressIndicatorPixelWidth)
    {
        int ticksGrindingItemSoFar = tileRuneDesk.getField(2); 
        int ticksPerItem = tileRuneDesk.getField(3);
        return ticksPerItem != 0 && ticksGrindingItemSoFar != 0 ? 
              ticksGrindingItemSoFar*progressIndicatorPixelWidth/ticksPerItem 
              : 0;
    }
 }