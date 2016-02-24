package ratismal.felineutilcore.client.hud.tablet.widget;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import org.lwjgl.opengl.GL11;
import ratismal.felineutilcore.api.guide.GuideCategory;
import ratismal.felineutilcore.client.hud.tablet.ref.RefTabletHUD;

/**
 * Created by Ratismal on 2016-02-23.
 */

public class TabletButtonCategory extends TabletButton {

    private static final ResourceLocation defaultTexture = RefTabletHUD.CATEGORY_BASIC;
    GuideCategory category;

    public TabletButtonCategory(int id, int xPosition, int yPosition, GuideCategory category) {
        super(id, xPosition, yPosition, 64, 64);
        this.category = category;
    }

    public GuideCategory getCategory() {
        return category;
    }

    @Override
    public void drawButton() {
        super.drawButton();

        ResourceLocation resource;
        if (category != null) {
            resource = category.getIcon();
        } else {
            resource = defaultTexture;
        }
        if (resource == null) {
            resource = defaultTexture;
        }


        if (hover) {
            GL11.glPushMatrix();
            GL11.glRotatef(90, 0, 1, 0);
            GL11.glRotatef(180, 0, 1, 0);
            GL11.glRotatef(180, 0, 0, 1);
            GL11.glTranslatef(-35, -280, -10);
            if (category != null) {
                String name = StatCollector.translateToLocal(category.getUnlocalizedName());
                Minecraft mc = Minecraft.getMinecraft();
                FontRenderer fontRender = mc.fontRendererObj;
                int stringWidth = fontRender.getStringWidth(name);
                fontRender.drawString(name, xPosition + (width / 2) - (stringWidth / 2), yPosition + 50, 0xFFFFFF);
            }
            GL11.glPopMatrix();
        }
        Minecraft.getMinecraft().renderEngine.bindTexture(resource);

        GL11.glRotatef(180f, 1f, 0f, 0f);
        GL11.glTranslatef(0f, -270f, -28f);
        drawTexturedModalRect(xPosition, yPosition, width, height);

    }
}
