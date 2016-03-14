package instagram;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import DAOs.PhotoDAO;
import exceptions.DataBaseProblemException;

public class Photo implements IPhoto, Comparable<Photo> {
	private Profile owner;
	private String hashTag;
	private int countLikes;
	private Calendar dataOfUpload;
	private ArrayList<String> comments = new ArrayList<String>();
	
	private PhotoDAO dao = new PhotoDAO();

	public Photo(String hashTag) throws DataBaseProblemException {
		this.setHashTag(hashTag);
		this.countLikes = 0;
		this.dataOfUpload = Calendar.getInstance();
		dao.addPhoto(this);
	}

	Photo() {
		this.hashTag = "";
		this.countLikes = 0;
		this.dataOfUpload = Calendar.getInstance();
	}

	public void makeProfilePictrue() {
		owner.setProfilePic(this);
	}

	public void addComment(String comment) {
		if (comment != null && comment.length() > 0) {
			comments.add(comment);
		}
	}

	public void getAllComments() {
		for (String c : comments) {
			System.out.println(c);
		}
	}

	public void deleteHashTag() {
		this.hashTag = null;
	}

	public void deletePhoto() throws DataBaseProblemException {
		this.owner = null;
		this.hashTag = null;
		this.owner.deletePhotoFromGAlery(this);;
		this.dataOfUpload = null;
		this.comments = null;
		dao.removePhoto(this);
	}

	private void setHashTag(String hashTag) {
		if (hashTag != null && hashTag.length() > 0 && hashTag.indexOf(0) == '#') {
			this.hashTag = hashTag;
		}
	}

	public void setOwner(Profile profile) {
		if (profile != null) {
			this.owner = profile;
		}
	}

	public String getHashTag() {
		return this.hashTag;
	}

	public void upNumberOfLikes() {
		this.countLikes++;
	}

	public int getNumberOfLikes() {
		return this.countLikes;
	}

	public Date getDataOfUpload() {
		return this.dataOfUpload.getTime();
	}

	public int compareTo(Photo photo) {
		if ((this.hashTag).equals(photo.hashTag)) {
			return 0;
		}
		return -1;
	}

	@Override
	public String toString() {
		String result = this.hashTag + " Owner: " + this.owner.getUserName() + " Number of likes: "
				+ this.getNumberOfLikes();
		return result;
	}

	public Profile getOwner() {
		return this.owner;
	}

}
