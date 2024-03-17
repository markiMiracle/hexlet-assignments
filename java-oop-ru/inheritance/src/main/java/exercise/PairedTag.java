package exercise;

import java.util.Map;
import java.util.List;

public class PairedTag extends Tag {
    private String tagBody;
    private List<Tag> children;

    public PairedTag(String tagName, Map<String, String> tagAttributes, String tagBody, List<Tag> children) {
        super(tagName, tagAttributes);
        this.tagBody = tagBody;
        this.children = children;
    }

    @Override
    public String toString() {
        var base = "";
        for (var child: children) {
            base += child.toString();
        }
        var html = super.toString() + tagBody
                + base + "</" + tagName + ">";
        return html;
    }
}
