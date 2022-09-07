import java.util.ArrayList;
import java.util.List;

public class Customer {
	public static final int ONE_DAY_MS = 1000 * 60 * 60 * 24;
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

	public void setRentals(List<Rental> rentals) {
		this.rentals = rentals;
	}

	public void addRental(Rental rental) {
		rentals.add(rental);

	}

	public String getReport() {
		String result = "Customer Report for " + getName() + "\n";

		List<Rental> rentals = getRentals();

		double totalCharge = 0;
		int totalPoint = 0;

		for (Rental each : rentals) {
			double eachCharge = 0;  // Charging, point 두가지 목적 사용 됨. SRP 위배
			int eachPoint = 0 ;
			int daysRented;

			daysRented = each.getDaysRented();

			// TODO: switch가 smell 인지 아닌지는 직접 판단.
			switch (each.getPriceCode()) {
			case Video.REGULAR:
				eachCharge += 2;
				if (daysRented > 2)  // TODO: 2는 매직 넘버?
					eachCharge += (daysRented - 2) * 1.5;
				break;
			case Video.NEW_RELEASE:
				eachCharge = daysRented * 3;
				break;
			}

			eachPoint++;

			if ((each.getPriceCode() == Video.NEW_RELEASE) )
				eachPoint++;

			// TODO: feature envy
			if ( daysRented > each.getDaysRentedLimit() )
				eachPoint -= Math.min(eachPoint, each.getLateReturnPointPenalty()) ;  // chain messaging

			result += "\t" + each.getTitle() + "\tDays rented: " + daysRented + "\tCharge: " + eachCharge
					+ "\tPoint: " + eachPoint + "\n";

			totalCharge += eachCharge;

			totalPoint += eachPoint ;  // 미래 지향적으로 분할하는 것도 좋을듯
		}

		result += "Total charge: " + totalCharge + "\tTotal Point:" + totalPoint + "\n";

		// string generation
		if ( totalPoint >= 10 ) {
			System.out.println("Congrats! You earned one free coupon");
		}
		if ( totalPoint >= 30 ) {
			System.out.println("Congrats! You earned two free coupon");
		}
		return result ;
	}

}
