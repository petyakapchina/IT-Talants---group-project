package instagram;

public class MainDispaly {

	public void likePhoto(Photo photo) {
		if (photo != null) {

		}
	}

	public void commentPhoto(Photo photo, String comment) {
		if (photo != null && comment != null && comment.length() > 0)
			photo.addComment(comment);
	}

}
