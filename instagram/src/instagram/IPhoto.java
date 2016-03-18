package instagram;

import exceptions.DataBaseProblemException;

public interface IPhoto {
	void addComment(String comment);
	void deletePhoto() throws DataBaseProblemException;
	void deleteHashTag();
	void getAllComments();
}
