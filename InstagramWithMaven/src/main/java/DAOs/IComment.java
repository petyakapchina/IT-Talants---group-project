package DAOs;

import exceptions.DataBaseProblemException;
import instagram.Photo;

public interface IComment {

	void addComment(Photo p) throws DataBaseProblemException;

	void removeComment(String text) throws DataBaseProblemException;
}
