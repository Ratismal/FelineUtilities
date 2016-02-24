package ratismal.felineutilcore.common.guide;

import ratismal.felineutilcore.api.guide.Guide;
import ratismal.felineutilcore.api.guide.GuideCategory;
import ratismal.felineutilcore.api.guide.GuideEntry;
import ratismal.felineutilcore.api.guide.GuidePage;
import ratismal.felineutilcore.common.ref.RefGuide;

/**
 * Created by Ratismal on 2016-02-23.
 */

public class EntryA extends GuideEntry {

    public EntryA(String unlocalizedName, GuideCategory category) {
        super(unlocalizedName, category);
        Guide.addEntry(this, category);
    }

    @Override
    public GuideEntry setPages(GuidePage... pages) {
        for(GuidePage page : pages) {
            page.unlocalizedName = getUnlocalizedNamePage() + page.unlocalizedName;
        }

        return super.setPages(pages);
    }

    @Override
    public String getUnlocalizedName() {
        return RefGuide.ENTRY.PREFIX + super.unlocalizedName;
    }

    public String getUnlocalizedNamePage() {
        return RefGuide.PAGE.PREFIX + super.unlocalizedName;
    }


}
