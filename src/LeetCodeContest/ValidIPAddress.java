// Bismillah Hirrahman Nirrahim
// With The Name of Allah, The Most Gracious, The Most Merciful
// Praise be to Allah, and peace and blessings be upon Rasulullah, his Family, his Companions, and his Followers. Ameen.

// Question: 468

package LeetCodeContest;

import java.util.regex.*;

public class ValidIPAddress {

	public static boolean testIP4(String IP) {
		String fourDigits = "(25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9][0-9]|[1-9]|0)";
		Pattern checkIp4 = Pattern.compile(fourDigits+"\\."+fourDigits+"\\."+fourDigits+"\\."+fourDigits);
		Matcher ip4Matcher = checkIp4.matcher(IP);
		boolean matching = false;
		
		while (ip4Matcher.find()) {
			if (ip4Matcher.group().length() != 0) {
				//System.out.println(ip4Matcher.group().trim());
				if (ip4Matcher.start()>0) {
					matching = false;
					continue;
				} else if (ip4Matcher.end()!=IP.length()) {
					matching = false;
					continue;
				}
				matching = true;
			}
		}
		return matching;
	}
	
	public static boolean testIP6(String IP) {
		Pattern checkIp6 = Pattern.compile("([A-Fa-f0-9]{1,4})\\:([A-Fa-f0-9]{1,4})\\:([A-Fa-f0-9]{1,4})\\:([A-Fa-f0-9]{1,4})\\:([A-Fa-f0-9]{1,4})\\:([A-Fa-f0-9]{1,4})\\:([A-Fa-f0-9]{1,4})\\:([A-Fa-f0-9]{1,4})");
		Matcher ip6Matcher = checkIp6.matcher(IP);
		
		while (ip6Matcher.find()) {
			if (ip6Matcher.group().length() != 0) {
				//System.out.println(ip6Matcher.group().trim());
				if (ip6Matcher.start()>0) {
					return false;
				} else if (ip6Matcher.end()!=IP.length()) {
					return false;
				}
				return true;
			}
		}
		return false;
	}
	public static String validIPAddress(String IP) {
        boolean isIP4 = testIP4(IP);
        boolean isIP6 = false;
        
        if (!isIP4) isIP6 = testIP6(IP);
        
        if (isIP4) {
        	return "IPv4";
        } else if (isIP6) {
        	return "IPv6";
        } else {
        	return "Neither";
        }
        
    }
	
	public static void main(String[] args) {
		//valid 
		String test = "172.16.254.1";
		String test1 = "2001:0db8:85a3:0000:0000:8a2e:0370:7334";
		String test5 = "2001:db8:85a3:0:0:8A2E:0370:7334";
		String test7 = "172.16.254.255";
		
		//invalid
		String test2 = "172.16.254.01";
		String test3 = "02001:0db8:85a3:0000:0000:8a2e:0370:7334";
		String test4 = "2001:0db8:85a3::8A2E:0370:7334";
		String test6 = "2001:0db8:85a3:0000:0000:8a2e:0370:73340";
		
		
		System.out.println(test+": "+validIPAddress(test));
		System.out.println(test1+": "+validIPAddress(test1));
		System.out.println(test5+": "+validIPAddress(test5));
		String a = validIPAddress(test7);
		System.out.println(test7+": "+a);

		System.out.println(test2+": "+validIPAddress(test2));
		System.out.println(test3+": "+validIPAddress(test3));
		System.out.println(test4+": "+validIPAddress(test4));
		System.out.println(test6+": "+validIPAddress(test6));
		
	}

}
