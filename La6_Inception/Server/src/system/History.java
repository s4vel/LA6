package system;

import exeptions.HistoryIsEmptyExeption;

/**
 * Stores and operate history of command.
 */
public class History {
    private String story[] = new String[8];
    private int start = -1;
    private int cur = 0;
    private int size = 0;

    /**
     * Adds command to history.
     *
     * @param str string name of command.
     */
    public void add(String str) {
        story[cur] = str;
        if (cur == 0) {
            start = (start + 1) % 8;
        }
        cur = (cur + 1) % 8;
        size++;
    }

    /**
     * Returns string with history.
     *
     * @return string history.
     */
    public String getStory() {
        try {
            if (size == 0) throw new HistoryIsEmptyExeption();
            String s = "";
            for (int i = start; i < Math.min(8, size); i++) {
                s += story[i] + "\n";
            }

            for (int i = 0; i < start; i++) {
                s += story[i] + "\n";
            }

            return s;
        } catch (HistoryIsEmptyExeption e) {
            return "история пуста\n";
        }
    }


}
