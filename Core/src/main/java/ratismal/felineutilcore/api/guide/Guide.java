package ratismal.felineutilcore.api.guide;

import ratismal.felineutilcore.common.util.LogHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ratismal on 2016-02-23.
 */

public class Guide {

    private static List<GuideCategory> categories = new ArrayList<GuideCategory>();
    private static List<GuideEntry> entries = new ArrayList<GuideEntry>();

    public static GuideCategory categoryBasic;

    public static void addCategory(GuideCategory category) {
        categories.add(category);
    }

    public static List<GuideCategory> getCategories() {
        return categories;
    }

    public static void addEntry(GuideEntry entry, GuideCategory category) {
        LogHelper.debugInfo("Adding entry " + entry.getUnlocalizedName() + " to " + category.getUnlocalizedName());
        entries.add(entry);
        category.entries.add(entry);
    }

    public static List<GuideEntry> getEntries() {
        return entries;
    }

}
