
class Solution {

    public List<String> findRepeatedDnaSequences(String s) {
        // Stores all unique 10-character sequences encountered so far
        Set<String> seenSequences = new HashSet<>();

        // Stores sequences that appear more than once
        Set<String> repeatedSequences = new HashSet<>();

        // Iterate through the string using a sliding window of length 10
        for (int i = 0; i <= s.length() - 10; i++) {
            // Extract the current 10-character substring
            String subsequence = s.substring(i, i + 10);

            // If 'add' returns false, the sequence has been seen before and is added to repeatedSequences
            if (!seenSequences.add(subsequence)) {
                repeatedSequences.add(subsequence);
            }
        }

        // Convert the set of repeated sequences to a list and return
        return new ArrayList<>(repeatedSequences);
    }
}
