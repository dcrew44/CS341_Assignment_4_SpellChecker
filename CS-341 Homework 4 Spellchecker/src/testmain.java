
public class testmain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//Test Cases
		
		//Case 1: A empty dictionary is created
		DictionaryTree dictionary = new DictionaryTree();
		assert dictionary.isEmpty();
		
		//Case 2: A single Node is added which root points to
		dictionary.addWordNode("ghost");
		assert dictionary.root.word.equals("ghost");
		
		//Case 3: A leaf root node is deleted thus the tree is now empty
		dictionary.checkWord("ghost");
		assert dictionary.isEmpty();
		
		//Case 4: A new tree is constructed which is fully populated
		
		dictionary.addWordNode("donut");
		dictionary.addWordNode("apple");
		dictionary.addWordNode("froyo");
		dictionary.addWordNode("lamb");
		dictionary.addWordNode("icee");
		dictionary.addWordNode("nougat");
		
	}

}
