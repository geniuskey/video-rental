import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Customer {
	private String name;

	private List<Rental> rentals = new ArrayList<Rental>();

	public Customer(String name) {
		this.setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Rental> getRentals() {
		return rentals;
	}

	public void addRental(Video video) {
		rentals.add(new Rental(video));
	}
	public void clearRental(){
		rentals.clear();
	}
	public void reportRentalList() {
		System.out.println("Name: " + name + "\tRentals: " + rentals.size()) ;
		for ( Rental rental: rentals ) {
			rental.reportRentalState();
		}
	}
	public String getReport() {
		String result = "Customer Report for " + getName() + "\n";

		List<Rental> rentals = getRentals();

		double totalCharge = 0;
		int totalPoint = 0;

		for (Rental each : rentals) {
			double eachCharge = each.getEachCharge();
			int eachPoint = each.getEachPoint();

			result += each.getResult(eachPoint);
			totalCharge += eachCharge;
			totalPoint += eachPoint ;
		}

		result += "Total charge: " + totalCharge + "\tTotal Point:" + totalPoint + "\n";

		checkCoupon(totalPoint);
		return result ;
	}

	private void checkCoupon(int totalPoint) {
		if (isOneCoupon(totalPoint)) {
			System.out.println("Congrat! You earned one free coupon");
		}
		if (isTwoCoupon(totalPoint)) {
			System.out.println("Congrat! You earned two free coupon");
		}
	}

	private boolean isTwoCoupon(int totalPoint) {
		return totalPoint >= 30;
	}

	private boolean isOneCoupon(int totalPoint) {
		return totalPoint >= 10;
	}
}
