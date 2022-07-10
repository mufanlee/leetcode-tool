package contest.base.json;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONUtil;

/**
 * Json Array
 *
 * @author lipeng
 */
public class JsonArray extends JSONArray {
    private final JSONArray jsonArray;

    public JsonArray(JSONArray jsonArray) {
        this.jsonArray = jsonArray;
    }

    @Override
    public int size() {
        return this.jsonArray.size();
    }

    @Override
    public JsonString get(int index) {
        return new JsonString(jsonArray.getStr(index));
    }

    public static JsonArray readFrom(String str) {
        return new JsonArray(JSONUtil.parseArray(str));
    }
}
