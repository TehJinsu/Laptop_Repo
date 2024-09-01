import java.io.File;

public class TreeMain {

	
	public static String printTree(File folder) {
		int indent = 0;
		
		StringBuilder sb = new StringBuilder();
		printTree(folder, indent, sb);
		
		return sb.toString();
	}
	
	private static void printTree(File folder, int indent, StringBuilder sb) {
		sb.append(getIndentString(indent));
		sb.append("File Name : ");
		sb.append(folder.getName());
		sb.append("Size of File: ");
		sb.append(folder.getTotalSpace());
		sb.append("Number of Files: ");
		sb.append(folder.length());
		sb.append("\n");
		for (File file : folder.listFiles()) {
			if (file.isDirectory()) {
				printTree(file, indent + 1, sb);
			}
			else {
				printNode(file, indent + 1, sb);
			}
		}
		
	}
	
	private static void printNode(File file, int indent, StringBuilder sb) {
		sb.append(getIndentString(indent));
		sb.append("File Name: ");
		sb.append(file.getName());
		sb.append("\n");
	}
	
	private static String getIndentString(int indent) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < indent; i++) {
			sb.append("\t");
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		
		File file = new File("C:\\Users\\ivanl\\Desktop\\Testing depth");
		printTree(file);
	}
	
}

