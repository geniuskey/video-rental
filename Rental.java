import java.util.Date;

public class Rental {
	public static final int ONE_DAY_MS = (1000 * 60 * 60 * 24);
	private Video video ;
	private int status ; // 0 for Rented, 1 for Returned -> explicit 하게 ENUM 사용하는게 좋지 않을까?
	private Date rentDate ;
	private Date returnDate ;

	public Rental(Video video) {
		this.video = video ;
		status = 0 ;
		rentDate = new Date() ;
	}

	public int getLateReturnPointPenalty() {
		return video.getLateReturnPointPenalty();
	}

	public Video getVideo() {
		return video;
	}

	public String getTitle() {
		return video.getTitle();
	}

	public void setRented(boolean rented){
		video.setRented(rented);
	}

	public boolean isRented(){
		return video.isRented();
	}
	public int getPriceCode() {
		return video.getPriceCode();
	}

	public void setVideo(Video video) {
		this.video = video;
	}

	public int getStatus() {
		return status;
	}

	public void returnVideo() {
		if ( status == 1 ) {
			this.status = 1;
			returnDate = new Date() ;
		}
	}
	public Date getRentDate() {
		return rentDate;
	}

	public void setRentDate(Date rentDate) {
		this.rentDate = rentDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	// TODO: duplicate code. feature envy?
	public int getDaysRentedLimit() {
		int limit = 0 ;

		if ( getDaysRented() <= 2) return limit ;

		switch ( video.getVideoType() ) {
			case Video.VHS:
				limit = 5 ;
				break ;
			case Video.CD:
				limit = 3 ;
				break ;
			case Video.DVD:
				limit = 2 ;
				break ;
		}
		return limit ;
	}

	public int getDaysRented() {
		long diff;
		int daysRented;
		if (getStatus() == 1) { // returned Video
			diff = returnDate.getTime() - rentDate.getTime();
		} else { // not yet returned
			diff = new Date().getTime() - rentDate.getTime();
		}
		daysRented = (int) (diff / ONE_DAY_MS) + 1;
		return daysRented;
	}
}
