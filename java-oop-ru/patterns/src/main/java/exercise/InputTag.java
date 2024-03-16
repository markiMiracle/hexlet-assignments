package exercise;


import lombok.AllArgsConstructor;

@AllArgsConstructor
public class InputTag implements TagInterface {

    private String tag;
    private String value;

    @Override
    public String render() {
        return "<input type=" + "\"" + tag + "\"" + " value="
                + "\"" + value + "\"" + ">";
    }
}
