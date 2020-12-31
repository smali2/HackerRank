// Bismillah Hirrahman Nirrahim
// With The Name of Allah, The Most Gracious, The Most Merciful
// Praise be to Allah, and peace and blessings be upon Rasulullah, his Family, his Companions, and his Followers. Ameen.

// This interview was held around Nov 30, 2016, technical phone interview for Google.

// Question:
// Given a single search term and a single class name, write a function that determines 
// if the search term matches the class name, i.e. returns a boolean.

// e.g. FB will match to FaceBook and FooBar
// 		FoBa will match to FooBar but not FaceBook
//		(more examples in Laurier's Google docs)

package Google2016Interview;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExQuestion {

	public void regExChecker(String theRegex, String classToCheck) {
		Pattern checkRegEx = Pattern.compile(theRegex);
		Matcher regexMatcher = checkRegEx.matcher(classToCheck);
		
		while(regexMatcher.find()) {
			if(regexMatcher.group().length()!=0) {
				System.out.println(regexMatcher.group().trim());
			}
		}
	}
	public static void main(String[] args) {
		String[] classNames = {"FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack"};
		String[] searchQueries = {"FB", "FoBa", "FoBaT", "FT"};
		
		
	}

}
