package ratismal.felineutilcore.client.util;

import com.sun.javafx.geom.Vec2f;
import net.minecraft.entity.player.EntityPlayer;
import ratismal.felineutilcore.client.hud.tablet.ref.RefTabletHUD;

/**
 * Created by Ratismal on 2016-02-22.
 */

public class MathHelper {


    public static float getYaw360(float yaw) {
        while (yaw < 0) {
            yaw += 360;
        }
        while (yaw > 360) {
            yaw -= 360;
        }
        return yaw;
    }

    public static float getYawAngle(float yaw) {
        while (yaw < 0) {
            yaw += RefTabletHUD.SEG_ANGLES;
        }
        while (yaw > RefTabletHUD.SEG_ANGLES) {
            yaw -= RefTabletHUD.SEG_ANGLES;
        }
        return yaw;
    }

    public static Vec2f getCoordsFromPlayer(float yaw, float pitch, float distance) {

        float x = (float) Math.tan(Math.toRadians(yaw - RefTabletHUD.SEG_ANGLES/2)) * distance;
        float y = (float) Math.tan(Math.toRadians(pitch)) * distance;

        return new Vec2f(x, -y);
    }

    public static Vec2f getCoordsFromPlayer(EntityPlayer player) {
        float distance = (float) (RefTabletHUD.SEGMENT_X / (2 * Math.tan(Math.toRadians(180)/RefTabletHUD.SEGMENTS)));

        float x = (float) Math.tan(Math.toRadians(getYawAngle(player.rotationYaw) - RefTabletHUD.SEG_ANGLES/2)) * distance;
        float y = (float) Math.tan(Math.toRadians(player.rotationPitch)) * distance;

        return new Vec2f(((x + 1) * 128) - 10, 256 - (-y + 1) * 128);
    }
}
