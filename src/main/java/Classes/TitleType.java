package Classes;

import javax.persistence.*;

@Entity
@Table(name = "DIC_TITLE_TYPE")
public class TitleType {

    @Id
    //@Column(name = "TITLE_TYPE_ID")
    long title_type_id;
    @Column(name = "TITLE_TYPE")
    String titleType;

    public TitleType() {
    }

    public long getTitleTypeID() {
        return title_type_id;
    }

    public void setTitleTypeID(long titleTypeID) {
        this.title_type_id = titleTypeID;
    }

    public String getTitleType() {
        return titleType;
    }

    public void setTitleType(String titleType) {
        this.titleType = titleType;
    }
}
