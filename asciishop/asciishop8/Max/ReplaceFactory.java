import java.util.*;

public class ReplaceFactory implements Factory {

	public ReplaceFactory() {
	}

	public Operation create(Scanner sc) throws FactoryException {

		char[] params = new char[2];

		for (int i = 0; i < params.length; i++) {
			if (!sc.hasNext()) {
				throw new FactoryException("Insufficient parameter");
			}
			String s = sc.next();
			if (s.length() > 1) {
				throw new FactoryException("Insufficient parameter");
			}
			params[i] = s.charAt(0);
		}

		return new ReplaceOperation(params[0], params[1]);

	}

}
