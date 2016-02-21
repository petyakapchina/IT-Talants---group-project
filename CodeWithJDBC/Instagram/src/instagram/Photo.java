package instagram;

public class Photo implements IPhoto{
	private Profile owner;
	private String comment;
	
	Photo(String comment){
		this.setComment(comment);
		
	}

	@Override
	public void addComment(String comment) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteComment() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletePhoto() {
		this.owner=null;	
		this.comment=null;
	}
	
	void setComment(String comment){
		if (comment!=null && comment.length()>0){
			this.comment=comment;
		}
	}

}
