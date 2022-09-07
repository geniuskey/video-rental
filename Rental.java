import java.util.Date;

public class Rental {
	private Video video ;
	private RentalStatus status ;
	private Date rentDate ;
	private Date returnDate ;

	public Rental(Video video) {
		this.video = video ;
		status = RentalStatus.RENTED ;
		rentDate = new Date() ;
	}

	public Video getVideo() {
		return video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}

	public RentalStatus getStatus() {
		return status;
	}

	public void returnVideo() {
		if (isReturned()) {
			this.status = RentalStatus.RETURNED;
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

	public int getDaysRentedLimit() {
		if ( getDaysRented() <= 2) return 0 ;
		return video.getLimit() ;
	}
	public void reportRentalState() {
		System.out.print("\tTitle: " + video.getTitle() + " ") ;
		System.out.print("\tPrice Code: " + video.getPriceCode()) ;
	}

	public int getDaysRented() {
		int daysRented = 0;
		long diff = 0L;
		Date startDate = new Date();
		if (isReturned()) { // returned Video
			startDate = getReturnDate();
		}
		return (int) (getDiffDate(startDate) / (1000 * 60 * 60 * 24)) + 1;
	}
	private boolean isReturned() {
		return status == RentalStatus.RETURNED;
	}
	private long getDiffDate(Date startDate) {
		return  startDate.getTime() - getRentDate().getTime();
	}

	public double getEachCharge(int daysRented) {
		double eachCharge = 1;
		if(getVideo().isRegularType()){
			eachCharge = 2;
			if (daysRented > 2)
				eachCharge += (daysRented - 2) * 1.5;
		}
		else{
			eachCharge = daysRented * 3;
		}
		return eachCharge;
	}

	public String getResult(int eachPoint) {
		return "\t" + getVideo().getTitle() + "\tDays rented: " + getDaysRented() + "\tCharge: " + getEachCharge(getDaysRented())
				+ "\tPoint: " + eachPoint + "\n";
	}

	public int getEachPoint() {
		int eachPoint = 1;
		if ((getVideo().getPriceCode() == PriceCode.NEW_RELEASE) )
			eachPoint++;

		if ( getDaysRented() > getDaysRentedLimit() )
			eachPoint -= Math.min(eachPoint, getVideo().getLateReturnPointPenalty()) ;
		return eachPoint;
	}
}
