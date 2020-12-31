package LeetCodeContest;

public class CompareVersion {

	
	public int compareVersion(String version1, String version2) {
        int[] ver1 = versionParts(version1);
        int[] ver2 = versionParts(version2);
        
        double v1 = getVersion(ver1);
        double v2 = getVersion(ver2);
        
        return Double.compare(v1, v2);
    }


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
