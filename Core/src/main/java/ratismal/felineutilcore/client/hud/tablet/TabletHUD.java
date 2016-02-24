package ratismal.felineutilcore.client.hud.tablet;

import com.sun.javafx.geom.Vec2f;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import org.lwjgl.opengl.GL11;
import ratismal.felineutilcore.client.hud.tablet.ref.RefTabletHUD;
import ratismal.felineutilcore.client.hud.tablet.window.Window;
import ratismal.felineutilcore.client.hud.tablet.window.WindowIntro;
import ratismal.felineutilcore.client.hud.tablet.window.guide.WindowGuide;
import ratismal.felineutilcore.client.util.MathHelper;
import ratismal.felineutilcore.client.util.RenderHelper;
import ratismal.felineutilcore.common.util.LogHelper;

import java.util.HashMap;

/**
 * Created by Ratismal on 2016-02-22.
 */

public class TabletHUD {

    protected static HashMap<Integer, Window> segmentList = new HashMap<Integer, Window>();

    private static boolean rightMousePressed = false;
    private static boolean leftMousePressed = false;

    public static boolean isInitialized = false;
    public static int alphaFade = 0;

    public static Window currentGuide;

    public static void init(ItemStack stack, EntityPlayer player, float partialTicks) {
        LogHelper.debugInfo("Doing a fresh init");
        getSegments(stack, player, partialTicks);
        isInitialized = true;
        alphaFade = 0;
    }

    public static void clear() {
        segmentList.clear();
        if (currentGuide != null)
            currentGuide.isInitialized = false;
        isInitialized = false;
        LogHelper.debugInfo("Clearing stuff");
    }

    public static void update(ItemStack stack, EntityPlayer player, float partialTicks) {

        //  LogHelper.debugInfo(partialTicks + "");

        //renderCursor(player);

        renderSegments();

        getSegment(player).getMouseOver(MathHelper.getCoordsFromPlayer(player));

        if (rightMousePressed) {
            onMouseClick(stack, player, true);
            rightMousePressed = false;
        }

        if (leftMousePressed) {
            onMouseClick(stack, player, false);
            leftMousePressed = false;
        }
    }

    public static Window getSegment(EntityPlayer player) {
        float yaw = MathHelper.getYaw360(player.rotationYaw + 180);
        int seg = (int) ((yaw - MathHelper.getYawAngle(yaw)) / 60);
        switch (seg) {
            case 1:
                seg = 5;
                break;
            case 2:
                seg = 4;
                break;
            case 4:
                seg = 2;
                break;
            case 5:
                seg = 1;
                break;
        }
        return segmentList.get(seg);
    }


    public static void renderCursor(EntityPlayer player) {

        float yaw = MathHelper.getYaw360(player.rotationYaw + 180);
        float pitch = player.rotationPitch;

        float distance = (float) (RefTabletHUD.SEGMENT_X / (2 * Math.tan(Math.toRadians(180) / RefTabletHUD.SEGMENTS)));
        int seg = getSegment(player).getSegmentId();

        Vec2f coords = MathHelper.getCoordsFromPlayer(MathHelper.getYawAngle(yaw), pitch, distance);

        GL11.glPushMatrix();

        float rotationAngle = (seg + 0.5F) * RefTabletHUD.SEG_ANGLES + (RefTabletHUD.SEG_ANGLES / 2);

        GL11.glRotatef(rotationAngle, 0f, 1f, 0f);


        //LogHelper.debugInfo("rotation - " + rotationAngle + " pitch - " + pitch + " segment - " + seg + " xPosition - " + coords.xPosition + " yPosition - " + coords.yPosition);

        GL11.glTranslatef(distance - 0.30f, 0.5F + coords.y, -RefTabletHUD.SEGMENT_X / 2F + coords.x);

        Minecraft.getMinecraft().renderEngine.bindTexture(RefTabletHUD.RES_ICONS);
        RenderHelper.renderTessalatorUV(0.5f, 0.5f, 1.5f, 1.5f, 1, 1);

        GL11.glPopMatrix();
    }


    public static void getSegments(ItemStack stack, EntityPlayer player, float partialTicks) {
        segmentList.clear();
        for (int seg = 0; seg <= RefTabletHUD.SEGMENTS - 1; seg++) {
            switch (seg) {
                case 1:
                    if (currentGuide != null) {
                        segmentList.put(seg, currentGuide);
                    } else {
                        WindowGuide windowGuide = new WindowGuide(stack, player, partialTicks, seg);
                        segmentList.put(seg, windowGuide);
                    }
                    break;
                case 2:
                    WindowIntro windowInto = new WindowIntro(stack, player, partialTicks, seg);
                    segmentList.put(seg, windowInto);
                    break;
                default:
                    Window window = new Window(stack, player, partialTicks, seg);
                    segmentList.put(seg, window);
                    break;
            }
        }
    }

    public static void renderSegments() {
        for (Window window : segmentList.values()) {
            if (!window.isInitialized) window.init();
            window.update();
        }
    }

    public static void onMouseClick(ItemStack itemStackIn, EntityPlayer playerIn, boolean right) {
        Window window = getSegment(playerIn);
        if (window != null)
            window.onMouseClick(itemStackIn, playerIn, right);
    }

    public static void notifyMouseRightClick() {
        rightMousePressed = true;
    }

    public static void notifyMouseLeftClick() {
        leftMousePressed = true;
    }

}
