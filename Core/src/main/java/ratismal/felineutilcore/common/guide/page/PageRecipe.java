package ratismal.felineutilcore.common.guide.page;


import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;
import ratismal.felineutilcore.api.guide.GuidePage;
import ratismal.felineutilcore.client.hud.tablet.window.guide.IWindowGuideEntry;

import java.util.List;

/**
 * Created by Ratismal on 2015-10-09.
 */

public class PageRecipe extends GuidePage {

    int relativeMouseX, relativeMouseY;
    ItemStack toolTipStack;

    public PageRecipe(String unlocalizedName) {
        super(unlocalizedName);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void renderScreen(IWindowGuideEntry gui, int mx, int my) {

        relativeMouseX = mx;
        relativeMouseY = my;

        renderRecipe(gui, mx, my);

        int width = gui.getWidth() - 30;
        int height = gui.getHeight();
        int x = gui.getLeft() + 16;
        int y = gui.getTop() + height - 40;
        PageText.renderText(x, y, width, height, getUnlocalizedName());

        if (toolTipStack != null) {
            List<String> toolTipData = toolTipStack.getTooltip(Minecraft.getMinecraft().thePlayer, false);
            //RenderHelper.renderToolTip(mx, my, toolTipData);
        }

        toolTipStack = null;
        GL11.glDisable(GL11.GL_BLEND);

        //renderText(xPosition, yPosition, width, gui.getHeight(), getUnlocalizedName());

    }

    @SideOnly(Side.CLIENT)
    public void renderRecipe(IWindowGuideEntry gui, int mx, int my) {

    }

    @SideOnly(Side.CLIENT)
    public void renderItemAtPos(IWindowGuideEntry gui, int x, int y, ItemStack stack) {

        if (stack == null) {
            return;
        }
        stack = stack.copy();

        if(stack.getItemDamage() == Short.MAX_VALUE)
            stack.setItemDamage(0);

        int xPos = gui.getLeft() + x * 29 + 7 + (y == 0  && x == 3 ? 10 : 0);
        int yPos = gui.getTop() + y * 29 + 24 - (y == 0 ? 7 : 0);

        ItemStack stack1 = stack.copy();
        if(stack1.getItemDamage() == -1)
            stack1.setItemDamage(0);

        renderItem(gui, xPos, yPos, stack1);
    }

    @SideOnly(Side.CLIENT)
    public void renderItem(IWindowGuideEntry gui, int xPos, int yPos, ItemStack stack) {

        //RenderItem getSegments = new RenderItem();
        boolean mouseDown = Mouse.isButtonDown(0);

        GL11.glPushMatrix();
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        RenderHelper.enableGUIStandardItemLighting();
        GL11.glEnable(GL12.GL_RESCALE_NORMAL);
        GL11.glEnable(GL11.GL_DEPTH_TEST);
        GL11.glPushMatrix();
        GL11.glTranslated(xPos, yPos, 0);
        //getSegments.renderItemAndEffectIntoGUI(Minecraft.getMinecraft().fontRenderer, Minecraft.getMinecraft().getTextureManager(), stack, 0, 0);
        //getSegments.renderItemOverlayIntoGUI(Minecraft.getMinecraft().fontRenderer, Minecraft.getMinecraft().getTextureManager(), stack, 0, 0);
        GL11.glPopMatrix();
        RenderHelper.disableStandardItemLighting();
        GL11.glPopMatrix();

        if(relativeMouseX >= xPos && relativeMouseY >= yPos && relativeMouseX <= xPos + 16 && relativeMouseY <= yPos + 16) {

            //stack.getTooltip()

        }

        GL11.glDisable(GL11.GL_LIGHTING);

    }



}
