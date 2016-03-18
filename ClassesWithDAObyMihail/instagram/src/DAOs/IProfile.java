package DAOs;

import exceptions.DataBaseProblemException;
import instagram.Profile;

public interface IProfile {
	

	void addProfile(Profile p) throws DataBaseProblemException;

	void removeProfile(String userName) throws DataBaseProblemException;

	Profile getProfileByUserName(String userName) throws DataBaseProblemException;

	void changeUserName(String newName) throws DataBaseProblemException;
	
	void changePassword(String newPassword) throws DataBaseProblemException;
}
