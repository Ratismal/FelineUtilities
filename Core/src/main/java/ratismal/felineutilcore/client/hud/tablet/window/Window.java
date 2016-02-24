package ratismal.felineutilcore.client.hud.tablet.window;

import com.sun.javafx.geom.Vec2f;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import org.lwjgl.opengl.GL11;
import ratismal.felineutilcore.client.hud.tablet.TabletHUD;
import ratismal.felineutilcore.client.hud.tablet.widget.TabletButton;
import ratismal.felineutilcore.client.hud.tablet.ref.RefTabletHUD;
import ratismal.felineutilcore.client.hud.tablet.widget.TabletLabel;
import ratismal.felineutilcore.client.util.MathHelper;
import ratismal.felineutilcore.client.util.RenderHelper;
import ratismal.felineutilcore.common.util.LogHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ratismal on 2016-02-22.
 */

public class Window {

    public Minecraft mc = Minecraft.getMinecraft();
    public ItemStack stack;
    public EntityPlayer player;
    public float partialTicks;
    protected int segment;
    public boolean isInitialized = false;

    public List<TabletButton> buttonList = new ArrayList<TabletButton>();
    public List<TabletLabel> labelList = new ArrayList<TabletLabel>();

    public Window(ItemStack stack, EntityPlayer player, float partialTicks, int segment) {
        this.stack = stack;
        this.player = player;
        this.partialTicks = partialTicks;
        this.segment = segment;
    }

    public void init() {
        buttonList.clear();
        labelList.clear();
        isInitialized = true;
        //LogHelper.debugInfo("Doing clear");
    }

    public void update() {
        GL11.glPushMatrix();

        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);

        GL11.glColor4f(1f, 1f, 1f, 1f);

        //GL11.glDisable(GL11.GL_BLEND);


        float rotationAngle = (segment + 0.5F) * RefTabletHUD.SEG_ANGLES + (RefTabletHUD.SEG_ANGLES / 2);
        GL11.glRotatef(rotationAngle, 0f, 1f, 0f);
        float distance = (float) (RefTabletHUD.SEGMENT_X / (2 * Math.tan(Math.toRadians(180) / RefTabletHUD.SEGMENTS)));
        GL11.glTranslatef(distance, 0.5F, -RefTabletHUD.SEGMENT_X / 2F);

        GL11.glPushMatrix();
        renderText();
        GL11.glPopMatrix();

        GL11.glPushMatrix();
        renderButtons();
        GL11.glPopMatrix();


        GL11.glPushMatrix();
        render();
        GL11.glPopMatrix();


        GL11.glColor4f(1f, 1f, 1f, 0.5f);

        renderBackground();

        GL11.glDisable(GL11.GL_BLEND);
        GL11.glPopMatrix();
    }

    public void render() {
        GL11.glTranslatef(-0.1f, 0f, 0f);
    }

    public void renderText() {

        GL11.glRotatef(-90f, 0f, 1f, 0f);
        GL11.glScalef(0.01f, -0.01f, -0.01f);
        GL11.glTranslatef(12f, -184f, -15f);

        for (TabletLabel label : labelList) {

            label.render();
        }
    }


    public void renderButtons() {

        //GL11.glEnable(GL11.GL_BLEND);
        GL11.glRotatef(180f, 0f, 1f, 0f);
        GL11.glScalef(0.0078125f, 0.0078125f, 0.0078125f);
        GL11.glTranslatef(10f, 0f, -45f);

        for (TabletButton button : buttonList) {
            GL11.glPushMatrix();
            button.drawButton();
            GL11.glPopMatrix();
        }
    }

    public void renderBackground() {
        //GL11.glEnable(GL11.GL_BLEND);
        //GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        mc.renderEngine.bindTexture(RefTabletHUD.RES_BACKGROUND);
        RenderHelper.renderTessalatorUV(RefTabletHUD.SEGMENT_X, RefTabletHUD.SEGMENT_Y, 1, 1);
        //GL11.glDisable(GL11.GL_BLEND);
    }

    public int getSegmentId() {
        return segment;
    }

    public void onMouseClick(ItemStack itemStackIn, EntityPlayer playerIn, boolean right) {
        Vec2f coords = MathHelper.getCoordsFromPlayer(playerIn);
        LogHelper.debugInfo("X: " + (int) (coords.x) + " Y: " + (int) ((coords.y)));

        for (TabletButton button : buttonList) {
            LogHelper.debugInfo(button.id + " X: " + (int) (coords.x) + " Y: " + (int) ((coords.y)) + " - " + button.xPosition + "-" + (button.xPosition + button.width)
            + " " + button.yPosition + "-" + (button.yPosition + button.height));

            if (button.mousePressed((int) coords.x, (int) (coords.y))) {
                if (button.isEnabled()) {
                    //button.onPress();
                    actionPerformed(button);
                    break;
                }
            }
        }
    }

    public void actionPerformed(TabletButton button) {
        //NO-OP
    }

    public void getMouseOver(Vec2f coords) {
        //LogHelper.debugInfo("Getting mouse over in segment " + segment);

        for (TabletButton button : buttonList) {
            //LogHelper.debugInfo(coords.x + ":" + coords.y + " - X: " + button.xPosition + "-" + (button.xPosition + button.width) +
            //" Y: " + button.yPosition + "-" + (button.yPosition + button.height));

            if (coords.x >= button.xPosition && coords.x <= button.xPosition + button.width &&
                    coords.y >= button.yPosition && coords.y <= button.yPosition + button.height) {
                //LogHelper.debugInfo("IT MATCHES!");
                button.setHover(true);
            } else {
                button.setHover(false);
            }
        }

    }

}
