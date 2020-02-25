package Classes;

import javafx.beans.property.SimpleStringProperty;

public class CaptionObject {

    private SimpleStringProperty caption;

    public CaptionObject(String caption)
    {
        this.caption = new SimpleStringProperty(caption);

    }

    //captions
    public String getCaption() {
        return caption.get();
    }

    public void setCaption(String caption) {
        this.caption = new SimpleStringProperty(caption);
    }

}
