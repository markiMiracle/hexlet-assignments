package exercise;

import java.util.Map;

public class SingleTag extends Tag {

    public String tagName;
    public Map<String, String> tagAttributes;
    public SingleTag(String tagName, Map<String, String> tagAttributes) {
        super(tagName, tagAttributes);
        this.tagName = tagName;
        this.tagAttributes = tagAttributes;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
