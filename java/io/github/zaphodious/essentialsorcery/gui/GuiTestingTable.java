package io.github.zaphodious.essentialsorcery.gui;

import org.lwjgl.opengl.GL11;

import io.github.zaphodious.essentialsorcery.container.ContainerTestingTable;
import io.github.zaphodious.essentialsorcery.core.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class GuiTestingTable extends GuiContainer {
	
	private ResourceLocation texture = new ResourceLocation(Reference.MODID + ":" + "textures/client/gui/WorkSurfaceQ.png");

	public GuiTestingTable(InventoryPlayer invPlayer, World worldIn, BlockPos pos) {
		super(new ContainerTestingTable(invPlayer, worldIn, pos));
		// TODO Auto-generated constructor stub
		this.xSize = 176;
		this.ySize = 166;
	}
	
	public void onGuiClosed() {
		super.onGuiClosed();
	}
	
	protected void drawGuiContainerForegroundLayer(int i, int j) {
		
		this.fontRendererObj.drawString(StatCollector.translateToLocal("Testing Table"), 100, 5, 0x000000);
		
		
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks,
			int mouseX, int mouseY) {
		
		GL11.glColor4f(1f, 1f, 1f, 1f);
		
		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
		
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
	}

}
