package ratismal.felineutilcore.api.guide;

import net.minecraft.util.ResourceLocation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ratismal on 2016-02-23.
 */

public class GuideCategory implements Comparable<GuideCategory> {

    //Number of categories initialized
    private static int count = 0;
    //The category id (based on count)
    private final int id;
    //The priority of the category
    private int priority;
    //Category icon
    private ResourceLocation icon;
    //List of entries the category contains
    public final List<GuideEntry> entries = new ArrayList<GuideEntry>();

    private final String unlocalizedName;

    public GuideCategory(String unlocalizedName) {
        id = count;
        count++;
        this.unlocalizedName = unlocalizedName;
    }

    public ResourceLocation getIcon() { return icon; }

    public GuideCategory setIcon(ResourceLocation icon) {
        this.icon = icon;
        return this;
    }

    public String getUnlocalizedName() {
        return unlocalizedName;
    }

    public GuideCategory setPriority(int priority) {
        this.priority = priority;
        return this;
    }


    @Override
    public int compareTo(GuideCategory category) {
        return priority == category.priority ? id - category.id : category.priority - priority;
    }

}
