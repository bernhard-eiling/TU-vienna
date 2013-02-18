import java.util.Scanner;


public class AsciiShop {
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	String dump = "";
	
	while (sc.hasNext()) {
	    String command = sc.next();
	    
	    if (!command.equals("create")) {
		System.out.println("INPUT MISMATCH");
		return;
	    } else {
		int width = sc.nextInt();
		int height = sc.nextInt();
		
		if (width <= 0 || height <= 0) {
		    System.out.println("INPUT MISMATCH");
		    break;
		} else {
		    // creates a new image
		    AsciiImage image = new AsciiImage(width, height);
		    while (sc.hasNext()) {
			command = sc.next();
			// clearing the image
			if(command.equals("clear")) {
			    image.clear();
			}
			
			// draws a line
			else if(command.equals("line")) {
			    int x0 = sc.nextInt();
			    int y0 = sc.nextInt();
			    int x1 = sc.nextInt();
			    int y1 = sc.nextInt();
			    char c = (char)sc.next().charAt(0);
			    
			    if (x0 < 0 || y0 < 0 || x1 < 0 || y1 < 0) {
				System.out.println("INPUT MISMATCH");
				return;
			    } else {
				image.drawLine(x0, y0, x1, y1, c);
			    }
			}
			
			// prints out the image
			else if(command.equals("print")) {
			    System.out.println(image.toString());
			}
			
			// replaces character
			else if(command.equals("replace")) {
			    image.replace((char)sc.next().charAt(0), (char)sc.next().charAt(0));
			}
			
			// transposes the image
			else if(command.equals("transpose")) {
			    image.transpose();
			}
			
			// loads an image with the setPixel() method
			else if(command.equals("load")) {
			    String breaker = "";
			    if(sc.hasNext()){
				breaker = sc.next();
				dump = sc.nextLine();
			    } else {
				System.out.println("INPUT MISMATCH");
				return;
			    }
			    String input = "";
			    for (int i = 0; i < image.getHeight(); i++) {
				input = sc.nextLine();
				if(input.length() != image.getWidth()) {
				    System.out.println("INPUT MISMATCH");
				    return;
				} else {
				    for(int j = 0; j < input.length(); j++) {
				    	image.setPixel(j, i, input.charAt(j));
				    }
				}
			    }
			    if (!breaker.equals(sc.nextLine())) {
			    	    System.out.println("INPUT MISMATCH");
			    	    return;
			    }
			}

			
			// false command
			else {
			    System.out.println("UNKNOWN COMMAND");
			}
		    }
		}
	    }
	}
    }
}
