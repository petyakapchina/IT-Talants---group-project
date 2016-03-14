package DAOs;

import exceptions.DataBaseProblemException;
import instagram.Photo;

public interface ILike {

	void addNewRecord(Photo p) throws DataBaseProblemException;

	void incrementLikes(Photo p) throws DataBaseProblemException;

	void derecmentLikes(Photo p) throws DataBaseProblemException;

	
}
