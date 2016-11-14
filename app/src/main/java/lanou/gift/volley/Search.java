package lanou.gift.volley;

import com.litesuits.orm.db.annotation.PrimaryKey;
import com.litesuits.orm.db.enums.AssignType;

/**
 * Created by dllo on 16/11/12.
 */
public class Search {
    //必须有 指定自增
    @PrimaryKey(AssignType.AUTO_INCREMENT)
    private int id;

    private String things;

    public String getThings() {
        return things;
    }

    public void setThings(String things) {
        this.things = things;
    }
}
