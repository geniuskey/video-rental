import java.util.Scanner;

public class VRUI {
	private static Scanner scanner = new Scanner(System.in) ;
	private VRManager mgr;
	public VRUI(){
		mgr = new VRManager();
	}

	public static void main(String[] args) {
		VRUI ui = new VRUI() ;

		boolean quit = false ;
		while ( ! quit ) {
			int command = ui.showCommand() ;
			switch ( command ) {
				case 0: quit = true ; break ;
				case 1: ui.CustomerCommand() ; break ;
				case 2: ui.VideoCommand() ; break ;
				case -1: ui.init() ; break ;
				default: break ;
			}
		}
		System.out.println("Bye");
	}

	public int showCommand() {
		System.out.println("\nSelect a command !");
		System.out.println("\t 0. Quit");
		System.out.println("\t 1. Customers Service");
		System.out.println("\t 2. Videos Service");

		int command = scanner.nextInt() ;

		return command ;

	}
	public int showCustomerCommand() {
		System.out.println("\nSelect a customer command !");
		System.out.println("\t 1. List customers");
		System.out.println("\t 2. Register customer");
		System.out.println("\t 3. Show customer report");
		System.out.println("\t 4. Show customer and clear rentals");
		int command = scanner.nextInt() ;

		return command ;

	}
	public int showVideoCommand() {
		System.out.println("\nSelect a video command !");
		System.out.println("\t 1. List videos");
		System.out.println("\t 2. Register video");
		System.out.println("\t 3. Rent video");
		System.out.println("\t 4. Return video");
		int command = scanner.nextInt() ;

		return command ;

	}
	private void CustomerCommand(){
		int command = showCustomerCommand() ;
		switch ( command ) {
			case 1: listCustomers() ; break ;
			case 2: registerCustomer(); ; break ;
			case 3: getCustomerReport() ; break;
			case 4: clearRentals() ; break ;
			default: break ;
		}

	}
	private void VideoCommand(){
		int command = showVideoCommand() ;
		switch ( command ) {
			case 1: listVideos() ; break ;
			case 2: registerVideo(); ; break ;
			case 3: rentVideo() ; break ;
			case 4: returnVideo() ; break ;
			default: break ;
		}

	}
	private void init(){
		mgr.init();
	}
	private static String inputCustomer() {
		System.out.println("Enter customer name: ") ;
		String customerName = scanner.next() ;
		return customerName;
	}
	private static String inputVideo() {
		System.out.println("Enter video title: ") ;
		String videoTitle = scanner.next() ;
		return videoTitle;
	}

	public void clearRentals() {
		String customerName = inputCustomer();
		mgr.clearRentals(customerName);
	}


	public void returnVideo() {
		String customerName = inputCustomer();
		String videoName = inputVideo();
		mgr.returnVideo(customerName, videoName);
	}
	public void listVideos() {
		mgr.listVideos();
	}

	public void listCustomers() {
		mgr.listCustomers();
	}

	public void getCustomerReport() {
		String customerName = inputCustomer();
		mgr.getCustomerReport(customerName);
	}

	public void rentVideo() {
		String customerName = inputCustomer();
		String videoName = inputVideo();
		mgr.rentVideo(customerName, videoName);
	}

	public void registerCustomer() {
		String name = inputCustomer();
		mgr.registerCustomer(name);
	}
	public void registerVideo() {
		String title = inputVideo();

		System.out.println("Enter video type( 1 for VHD, 2 for CD, 3 for DVD ):") ;
		int videoType = scanner.nextInt();

		System.out.println("Enter price code( 1 for Regular, 2 for New Release ):") ;
		int priceCode = scanner.nextInt();

		mgr.registerVideo(title, videoType, priceCode);
	}

}
