
public class File extends Node {
	int size = 0;
	
	public File(Folder r, String s) throws DuplicateNameException {
		super(s, r);
	}

	public File(Folder r, String s, int i) throws DuplicateNameException {
		super(s, r);
		size = i;
		r.increaseSize(size);
		
	}

	public int getSize() {
		return size;
	}
	
}
