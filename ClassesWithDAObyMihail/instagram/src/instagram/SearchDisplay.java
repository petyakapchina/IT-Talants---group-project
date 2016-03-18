package instagram;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class SearchDisplay {
	private Profile profile;
	static Map<String, Set<Photo>> photoFinder = new TreeMap<String, Set<Photo>>();
	
	public void searchByHashTag(String hashTag) throws Exception {
		if (hashTag != null && hashTag.length() > 0 && hashTag.charAt(0) == '#') {
			for (String tag : photoFinder.keySet()) {
				if (tag.equals(hashTag)) {
					System.out.println(tag);
				}
			}
		} else {
			throw new Exception("Nothing found!");
		}
	}
	
	public static void addPhotoToMap(Photo p, String hashTag) {
		if (p != null && hashTag != null && hashTag.length() > 0 && hashTag.charAt(0)=='#') {
			if (!photoFinder.containsKey(hashTag)) {
				photoFinder.put(hashTag, new TreeSet<Photo>());
			}

			photoFinder.get(hashTag).add(p);
		}
	}

	public void searchByUserName(String userName) throws Exception {
		if (userName != null && userName.length() > 0) {
			for (String name : Profile.profileFinder.keySet()) {
				if (name.equals(userName)) {
					System.out.println(profile);
				}
			}
		} else {
			throw new Exception("Nothing found!");
		}
	}
}
