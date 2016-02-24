package ratismal.felineutilcore.api.guide;

import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Ratismal on 2016-02-23.
 */

public class GuideEntry implements Comparable<GuideEntry> {

    public final String unlocalizedName;
    public final GuideCategory category;
    //Priority of entry (0 for key, anything else for further)
    private int priority = 1;
    //List of pages in the entry
    public List<GuidePage> pages = new ArrayList<GuidePage>();
    public ItemStack icon = null;

    public GuideEntry(String unlocalizedName, GuideCategory category) {
        this.unlocalizedName = unlocalizedName;
        this.category = category;
    }

    public ItemStack getIcon() {
        return icon;
    }

    public void setIcon(ItemStack stack) {
        icon = stack;
    }

    public GuideEntry setPages(GuidePage... page) {
        this.pages.addAll(Arrays.asList(page));
        return this;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public GuideCategory getCategory() {
        return category;
    }

    public String getUnlocalizedName() {
        return unlocalizedName;
    }

    public final String getSortingName() {
        return (priority == 0 ? 0 : 1) + StatCollector.translateToLocal(getUnlocalizedName());
    }

    @Override
    public int compareTo(GuideEntry o) {
        return getSortingName().compareTo(o.getSortingName());
    }

}