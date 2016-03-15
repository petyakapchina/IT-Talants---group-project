package instagram;

import exceptions.DataBaseProblemException;

public class PhotoDisplay {
	private Profile profile;

	public PhotoDisplay(Profile p) {
		this.profile = p;
	}

	public Photo takePhoto(String hashTag) throws DataBaseProblemException {
		Photo photo = null;
		if (hashTag.length() == 0 || hashTag == null) {
			photo = new Photo();
		} else {
			photo = new Photo(hashTag);
		}
		SearchDisplay.addPhotoToMap(photo, hashTag);
		;
		return photo;
	}

	public void uploadTakenPhoto(Photo p) {
		profile.addPhotoToInstagram(p);
	}

	public Object uploadFromTelephone(Photo p) {
		if (p != null) {
			return p;
		}
		return new Exception("Unsuccessful operation!");
	}

}
