package exercise;


import lombok.AllArgsConstructor;

@AllArgsConstructor
public class LabelTag implements TagInterface {

    private String labelTag;
    private TagInterface subsidiaryTag;
    @Override
    public String render() {
        return "<label>" + labelTag + subsidiaryTag.render() + "</label>";
    }
}
