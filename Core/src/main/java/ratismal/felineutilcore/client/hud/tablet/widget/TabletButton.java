package ratismal.felineutilcore.client.hud.tablet.widget;

import com.sun.javafx.geom.Vec2f;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import org.lwjgl.opengl.GL11;
import ratismal.felineutilcore.client.util.MathHelper;
import ratismal.felineutilcore.common.util.LogHelper;

/**
 * Created by Ratismal on 2016-02-22.
 */

public class TabletButton extends TabletWidget {

    public boolean hover;

    public TabletButton(int id, int xPosition, int yPosition, int width, int height) {
        super(id, xPosition, yPosition, width, height);
        //setEnabled(true);
    }

    int counter = 0;

    public void drawButton() {
        if (hover && counter < 10) {
            counter++;
        } else if (counter > 0) {
            counter--;
        }
        GL11.glTranslatef(counter, 0, 0);
    }


    public boolean mousePressed(int mouseX, int mouseY) {
        return this.enabled && this.visible && mouseX >= this.xPosition && mouseY >= this.yPosition && mouseX < this.xPosition + this.width && mouseY < this.yPosition + this.height;
    }

    public void onPress() {
        LogHelper.debugInfo("Button was pressed");
    }

    public void setHover(boolean hover) {
        this.hover = hover;
    }
}
