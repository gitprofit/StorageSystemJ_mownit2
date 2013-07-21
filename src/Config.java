
import java.util.*;

public class Config {
	
	private static Config instance = null;
	
	private Random random = new Random();
	private int rand(int min, int max) {
		return min + random.nextInt(max - min + 1);
	}
	
	public int baseSize = 1024;
	
	public int minStorage = 100;
	public int maxStorage = 150;
	
	public int minFile = 5;
	public int maxFile = 15;
			
	public int minAccess = 500;
	public int maxAccess = 1500;
			
	public int safeFilesPerStorage = minStorage / maxFile;
	public int storages = 20;
			
	public int nextStorageSize() {
		return rand(minStorage, maxStorage) * baseSize;
	}
	
	public int nextFileSize() {
		return rand(minFile, maxFile) * baseSize;
	}
	
	public int nextAccessTime() {
		return rand(minAccess, maxAccess);
	}

	private Config() {
	};
	
	public static synchronized Config getInstance() {
		
		if(instance == null)
			instance = new Config();
		
		return instance;
	}
}