
public class DictionaryTree {
	public WordNode root;

	public DictionaryTree() {
		root = null;
	}

	public void addWordNode(String word) {
		
		WordNode temp = new WordNode(word);
		assert (!nodeExists(root, temp)): "Node already exists.";
		if (root == null) {
			root = new WordNode(word);
		} else {
			insert(root, temp);
		}
		assert (nodeExists(root, temp)): "Node was not added.";
	}
	

	private void insert(WordNode myRoot, WordNode temp) {
		
		while (true) {
			if (temp.compareTo(myRoot) == 0)
				return;
			
			if (temp.compareTo(myRoot) <= -1) {
				if (myRoot.left != null)
					myRoot = myRoot.left;
				else {
					myRoot.left = temp;
					
					break;
					
				}
			} else {
				if (myRoot.right != null) {
					myRoot = myRoot.right;
				} else {
					myRoot.right = temp;
					
					break;
				}
			}
		}
	}
	public boolean nodeExists(WordNode myRoot, WordNode x) {

		while(true) {
			if (myRoot == null ) return false;
			if (x.compareTo(myRoot) == 0) return true;
			else if (x.compareTo(myRoot) <= -1 ) {
				myRoot = myRoot.left;
			} else if (x.compareTo(myRoot) >= 1) {
				myRoot = myRoot.right;
			}
		}
		
	}

	public void inOrder() {
		inOrderRecursive(root);
	}

	public void inOrderRecursive(WordNode myRoot) {
		if (myRoot != null) {
			inOrderRecursive(myRoot.left);
			System.out.println(myRoot.getWord());
			inOrderRecursive(myRoot.right);
		}
	}
	
	public void checkWord(String del) {
		WordNode delete = new WordNode(del);
		assert nodeExists(root, delete): "Node does not exist";
		root = deleteRec(root, del);
		assert !nodeExists(root, delete): "Node still exists";
	}

	public WordNode deleteRec(WordNode root, String del) {
		WordNode toDelete = new WordNode(del);
		if (root == null) {
			return root;
		}
		if (root.compareTo(toDelete) >= 1) {
			root.left = deleteRec(root.left, del);
		} else if (root.compareTo(toDelete) <= -1) {
			root.right = deleteRec(root.right, del);
		} else {
			// Node is a leaf or has one child
			if (root.left == null) {
				return root.right;
			} else if (root.right == null) {
				return root.left;
			}

			root.word = minValue(root.right);

			root.right = deleteRec(root.right, root.word);
		}
		return root;
	}

	public String minValue(WordNode root) {
		String mval = root.word;
		while (root.left != null) {
			mval = root.left.word;
			root = root.left;
		}
		return mval;
	}
	
	public boolean spellCheck(String str) {
		WordNode myRoot = root;
		WordNode temp = new WordNode(str);
		while(true) {
			if (myRoot == null ) return false;
			if (temp.compareTo(myRoot) == 0) return true;
			else if (temp.compareTo(myRoot) <= -1 ) {
				myRoot = myRoot.left;
			} else if (temp.compareTo(myRoot) >= 1) {
				myRoot = myRoot.right;
			}
		}
	}

	public int childrenNum(WordNode word) {
		if (word.left == null && word.right == null)
			return 0;
		else if ((word.left != null && word.right == null) || (word.left == null && word.right != null))
			return 1;
		else
			return 2;
	}
	
	public boolean isEmpty() {
		return root == null;
	}

}
