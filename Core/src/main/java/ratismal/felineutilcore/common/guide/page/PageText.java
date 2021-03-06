package ratismal.felineutilcore.common.guide.page;

import com.google.common.base.Joiner;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.util.StatCollector;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import ratismal.felineutilcore.api.guide.GuidePage;
import ratismal.felineutilcore.client.hud.tablet.window.guide.IWindowGuideEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ratismal on 2015-09-22.
 */

public class PageText extends GuidePage {

    public PageText(String unlocalizedName) {
        super(unlocalizedName);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void renderScreen(IWindowGuideEntry gui, int mx, int my) {

        int width = gui.getWidth() - 30;
        int x = gui.getLeft() + 16;
        int y = gui.getTop() + 2;

        renderText(x, y, width, gui.getHeight(), getUnlocalizedName());

    }

    public static void renderText(int x, int y, int width, int height, String unlocalizedText) {
        renderText(x, y, width, height, 10, unlocalizedText);
    }

    @SideOnly(Side.CLIENT)
    public static void renderText(int x, int y, int width, int height, int paragraphSize, String unlocalizedText) {
        x += 2;
        y += 10;
        width -= 4;

        System.out.println(width);
        FontRenderer font = Minecraft.getMinecraft().fontRendererObj;
        boolean unicode = font.getUnicodeFlag();
        font.setUnicodeFlag(true);
        String text = StatCollector.translateToLocal(unlocalizedText).replaceAll("&", "\u00a7");
        String[] textEntries = text.split("<br>");

        List<List<String>> lines = new ArrayList();

        String controlCodes = "";

        /**
         * Process each line
         */
        for(String s : textEntries) {
            List<String> words = new ArrayList();
            String lineStr = "";
            String[] tokens = s.split(" ");
            for(String token : tokens) {
                String prev = lineStr;
                String spaced = token + " ";
                lineStr += spaced;

                controlCodes = toControlCodes(getControlCodes(prev));



                //System.out.println(font.getStringWidth(lineStr) + " > " + width);
                if(font.getStringWidth(lineStr) > width) {
                    lines.add(words);
                    lineStr = controlCodes + spaced;
                    words = new ArrayList();
                }

                words.add(controlCodes + token);
            }

            if(!lineStr.isEmpty())
                lines.add(words);
            lines.add(new ArrayList());
        }

        int i = 0;
        for(List<String> words : lines) {
            words.size();
            int xi = x;
            int spacing = 4;
            int wcount = words.size();
            int compensationSpaces = 0;
            boolean justify = wcount > 0 && lines.size() > i && !lines.get(i + 1).isEmpty();
            justify = false;
            if(justify) {
                String s = Joiner.on("").join(words);
                int swidth = font.getStringWidth(s);
                int space = width - swidth;

                spacing = wcount == 1 ? 0 : space / (wcount - 1);
                compensationSpaces = wcount == 1 ? 0 : space % (wcount - 1);
            }

            for(String s : words) {
                int extra = 0;
                if(compensationSpaces > 0) {
                    compensationSpaces--;
                    extra++;
                }
                font.drawString(s, xi, y, 0);
                xi += font.getStringWidth(s) + spacing + extra;
            }

            y += words.isEmpty() ? paragraphSize : 10;
            i++;
        }

        font.setUnicodeFlag(unicode);
    }

    public static String getControlCodes(String s) {
        String controls = s.replaceAll("(?<!\u00a7)(.)", "");
        String wiped = controls.replaceAll(".*r", "r");
        return wiped;
    }

    public static String toControlCodes(String s) {
        return s.replaceAll(".", "\u00a7$0");
    }

}
