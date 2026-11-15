
import java.util.*;

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {

        List<String> result = new ArrayList<>();

        int i = 0;

        while (i < words.length) {

            int j = i;
            int letters = 0;

            // Find maximum words that can fit in one line
            while (j < words.length &&
                   letters + words[j].length() + (j - i) <= maxWidth) {

                letters += words[j].length();
                j++;
            }

            int spaces = maxWidth - letters;
            int gaps = j - i - 1;

            StringBuilder line = new StringBuilder();

            // Last line or only one word
            if (j == words.length || gaps == 0) {

                for (int k = i; k < j; k++) {
                    line.append(words[k]);

                    if (k < j - 1) {
                        line.append(" ");
                    }
                }

                // Add remaining spaces at the end
                while (line.length() < maxWidth) {
                    line.append(" ");
                }

            } else {

                int spacePerGap = spaces / gaps;
                int extraSpaces = spaces % gaps;

                for (int k = i; k < j; k++) {

                    line.append(words[k]);

                    if (k < j - 1) {

                        int count = spacePerGap;

                        // Extra spaces go to left gaps
                        if (k - i < extraSpaces) {
                            count++;
                        }

                        for (int s = 0; s < count; s++) {
                            line.append(" ");
                        }
                    }
                }
            }

            result.add(line.toString());

            i = j;
        }

        return result;
    }
}
