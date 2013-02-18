public class Test {
	public static void main(String[] args) {
	
	AsciiImage test=new AsciiImage(30, 9, "#WMBRXVYIti+=;:,.");
	
	System.out.println(test.toString());
	
	
	//String in="abc"+"\r\n"+"cac"+"\r\n"+"abd";
	String in = 
	"============,.V+.;============"+"\r\n"+
	"===========;.X##..;==========="+"\r\n"+
	"===========..####..==========="+"\r\n"+
	"==========,.##M###.:=========="+"\r\n"+
	"=========;.R##WW##=.;========="+"\r\n"+
	"=========..##MWMW##,.========="+"\r\n"+
	"========:.I##WWMWW#W.,========"+"\r\n"+
	"=======;.:##WWWWWW##I.;======="+"\r\n"+
	"=======:.W########M##..=======";
	LoadOperation load = new LoadOperation(in);
	try {
		test = load.execute(test);
	} catch (OperationException ex) {
		System.out.println("failed to load");
	}
	System.out.println(test.toString());
	
	FloodfillOperation fill= new FloodfillOperation(25, 2, '#');
	try {
		test = fill.execute(test);
	} catch (OperationException ffex) {
		System.out.println("failed to flood");
	}
	System.out.println(test.toString());
	
	/*
	BinaryOperation binary = new BinaryOperation(';');
	try {
		test = binary.execute(test);
	} catch (OperationException ex) {
		System.out.println("failed to binarize");
	}
	System.out.println(test.toString());
	
	/*ja
	MedianOperation median = new MedianOperation();
	test = median.execute(test);
	System.out.println(test.toString());
	*/
	
	/*
	try {
		test = load.execute(test);
	} catch(OperationException ex) {
		System.out.println("Failed to load image");
	}
	System.out.println(test.toString());
	*/
	/*
	ReplaceOperation replace=new ReplaceOperation('d', 'c');
	try {
		System.out.println(replace.execute(test));
	} catch(OperationException ef) {
		System.out.println("Failed to replace char");
	}
	*/
	/*
	
	String in="abc"+"\r\n"+"abc"+"\r\n"+"abc";
	
	LoadOperation load=new LoadOperation(in);
	
	AsciiImage test2=load.execute(test);
	
	System.out.println("3"+test2);
	*/
	
	}
}
