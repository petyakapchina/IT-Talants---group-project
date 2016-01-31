package instagram;

public class PhotoDisplay implements IDisplay{
	
	public Photo takePhoto(){
		//...
		return new Photo();
		
	}
	
	public Photo uploadFromTelephone(PhoneGallery gallery){
		return gallery.chooslePhotoFromGallery(1);
	}

    
    
    @Override
	public void changeDisplay(IDisplay display) {
		// TODO Auto-generated method stub
		
	}

}
