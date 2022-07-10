package contest.base.json;

import cn.hutool.json.JSONUtil;

/**
 * Json String
 *
 * @author lipeng
 */
public class JsonString {
    private final String str;

    public JsonString(String jsonString) {
        this.str = jsonString;
    }

    public JsonArray asArray() {
        return new JsonArray(JSONUtil.parseArray(str));
    }
}
