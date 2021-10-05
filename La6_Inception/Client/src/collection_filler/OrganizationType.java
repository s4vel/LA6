package collection_filler;

import java.io.Serializable;

/**
 * Enumeration with OrganizationType category constants.
 */
public enum OrganizationType implements Serializable {
    COMMERCIAL,
    PUBLIC,
    GOVERNMENT,
    TRUST;

    private static final long serialVersionUID = 1L;

    public static String getString() {
        String str = "";
        for (OrganizationType organizationType : values()) {
            str += organizationType + "; ";
        }

        return str;
    }
}
