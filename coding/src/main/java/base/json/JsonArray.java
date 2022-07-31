package base.json;

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

    @Override
    public String toString() {
        return this.jsonArray.toString();
    }

    public static JsonArray readFrom(String str) {
        return new JsonArray(JSONUtil.parseArray(str));
    }
}
