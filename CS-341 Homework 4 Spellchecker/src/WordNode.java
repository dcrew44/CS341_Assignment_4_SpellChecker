
public class WordNode implements Comparable<WordNode>{
	
	public String word;
	public WordNode left;
	public WordNode right;
	
	public WordNode(String word) {
		this.word = word;
		left =null;
		right = null;
	}
	public String getWord() {
		return word;
	}
	@Override
	public int compareTo(WordNode node) {
		if (word.compareTo(node.getWord())==0) return 0;
		return word.compareTo(node.getWord());
	}

	
}
