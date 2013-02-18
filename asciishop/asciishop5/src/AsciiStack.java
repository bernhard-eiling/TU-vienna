
public class AsciiStack {
    AsciiImage stack[];
    int increment;
    public AsciiStack(int increment) {
	this.increment = increment;
	this.stack = new AsciiImage[this.increment];
    }
    public int capacity() {
	return this.stack.length;
    }
    public boolean empty() {
	if (this.size() > 0) {
	    return true;
	} else {
	    return false;
	}
    }
    public AsciiImage pop() {
	if (!this.empty()) {
	    AsciiImage returnImage = new AsciiImage(this.stack[this.size() - 1]);
	    if (this.increment > this.capacity() - this.size()) {
		AsciiImage[] shorten = new AsciiImage[this.capacity() - this.increment];
		for(int i = 0; i < shorten.length; i++) {
		    shorten[i] = new AsciiImage(this.stack[i]);
		}
		stack = shorten;
	    }
	    return returnImage;
	} else {
	    return null;
	}
    }
    public AsciiImage peek() {
	if (!this.empty()) {
	    AsciiImage returnImage = new AsciiImage(this.stack[this.size() - 1]);
	    
	    return returnImage;
	} else {
	    return null;
	}
    }
    public void push(AsciiImage img) {
	if (this.stack[this.capacity() - 1] == null) {
	    stack[this.size()] = img;
	    System.out.println("--------------------");
	    System.out.println("capacity: " + this.capacity());
	    System.out.println("stack content at end: " + this.stack[this.capacity() - 1]);
	} else {
	    System.out.println("appended");
	    AsciiImage[] append = new AsciiImage[this.capacity() + this.increment];
	    for(int i = 0; i < this.capacity(); i++) {
		append[i] = new AsciiImage(this.stack[i]);
	    }
	    append[this.capacity()] = img;
	    stack = append;
	    
	}
    }
    public int size() {
	int emptySpace = 0;
	for (int i = 0; i < this.capacity(); i++) {
	    if (this.stack[i] == null) {
		emptySpace ++;
	    }
	}
	return this.capacity() - emptySpace;
    }
}
