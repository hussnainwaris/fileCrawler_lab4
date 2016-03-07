
import java.io.*;
import java.util.*;
public class FileCrawler { 
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args){
		File currentDir = new File("/Users/macbookpro/Desktop/dir/subdir/file document.txt"); // current directory
		System.out.print("Press 1 to Enter a word to search in local file system \n "
				+ "or Press 2 to list all directories and folders \n");
		int check = sc.nextInt();
		if(check == 2){
		
			traverse(currentDir);
	
		}else if(check == 1){
			compare(currentDir);
		}
		
	}
	
	private static void compare(File currentDir) {
		// TODO Auto-generated method stub
		System.out.print("Enter a keyword to search \n");
		String wor = "";
		String line = "";
		sc = new Scanner(System.in);
		wor = sc.nextLine();
		if ((currentDir.isFile()) && (currentDir.getName().endsWith(".txt"))){
			try {
				BufferedReader input = new BufferedReader(new FileReader(currentDir));
				while ((line = input.readLine()) != null) {
				    
	    			if(line.contains(wor)||(wor == currentDir.getName())){
	    				System.out.print(line);
	    			}else{
	    				System.out.println("Doesnot match anything");
	    			}
        
			    }
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
		
	}
	private static void traverse(File dir){
		
		Map<String, String> map = new HashMap<String, String>();
		
		ArrayList<String> al = new ArrayList<String>();
		
	    if (dir.isDirectory()) {
	    
	    	String[] children = dir.list();
	        
	    	for (int i = 0; children != null && i < children.length; i++) {
	            traverse(new File(dir, children[i]));
	        }
	    }
	    
	    if (dir.isFile()) {
	    
	    	String path = "";
	    	
	    	path = dir.getAbsolutePath();
	        
	    	System.out.println(path);//change it if needed
	        
	    	try {
			
	    		BufferedReader in = new BufferedReader(new FileReader(dir));
				
	    		String line = "";
			    
	    		while ((line = in.readLine()) != null) {
			    
	    			al.add(line);
			        
	    			map.put(dir.getName(),path);
			        
			        }
			        
	    		in.close();
			    
	    		System.out.println(map.toString());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            
	    }
	}
	
	
}
	
