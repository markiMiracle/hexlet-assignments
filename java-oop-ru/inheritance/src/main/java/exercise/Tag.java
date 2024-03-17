package exercise;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
public class Tag {
    public String tagName;
    public Map<String, String> tagAttributes;

    public Tag(String tagName, Map<String, String> tagAttributes) {
        this.tagName = tagName;
        this.tagAttributes = tagAttributes;
    }

    public String toString() {
        var map = new LinkedHashMap<>(tagAttributes);
        var list = new ArrayList<String>();
        for (var elem: map.entrySet()) {
            list.add(elem.getKey());
        }
        var html = "";
        for (var i = 0; i < list.size(); i++) {
            html += " " + list.get(i) + "=" + "\"" + tagAttributes.get(list.get(i)) + "\"";
        }
        html = "<" + tagName + html + ">";
        return html;
    }
}
