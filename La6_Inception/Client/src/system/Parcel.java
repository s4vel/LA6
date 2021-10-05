package system;

import java.io.Serializable;

public class Parcel implements Serializable {
    private static final long serialVersionUID = 1L;
    private String comName;
    private Object conArgs;

    public Parcel(String comName) {
        this.comName = comName;
        this.conArgs = comName;
    }

    public Parcel(String comName, Object conArgs) {
        this.comName = comName;
        this.conArgs = conArgs;
    }

    public String getComName() {
        return comName;
    }

    public Object getConArgs() {
        return conArgs;
    }

    public void setConArgs(Object conArgs) {
        this.conArgs = conArgs;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }
}
