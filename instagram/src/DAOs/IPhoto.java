package DAOs;

import exceptions.DataBaseProblemException;
import instagram.Photo;

public interface IPhoto {
	

	void addPhoto(Photo p) throws DataBaseProblemException;

	void removePhoto(Photo p) throws DataBaseProblemException;

	Photo getPhotoByHashTag(String hashTag) throws DataBaseProblemException;
}
