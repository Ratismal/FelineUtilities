package ratismal.felineutilcore.common.init;

import ratismal.felineutilcore.common.item.ItemCatTablet;

/**
 * Created by Ratismal on 2016-02-22.
 */

public class ModItems {

    public static ItemCatTablet itemCatTablet;

    public static void init() {
        itemCatTablet = new ItemCatTablet();
    }

    public static void initModels() {
        itemCatTablet.initModel();
    }

}
