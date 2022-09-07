import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class VRUI {
	private static Scanner scanner = new Scanner(System.in) ;
	private static VRManager vrm = new VRManager();

	public static void main(String[] args) {
		VRUI ui = new VRUI() ;
		vrm.setScanner(scanner);

		boolean quit = false ;
		while ( ! quit ) {
			int command = ui.showCommand() ;
			switch ( command ) {
				case 0: quit = true ; break ;
				case 1: vrm.listCustomers() ; break ;
				case 2: vrm.listVideos() ; break ;
				case 3: vrm.register("customer") ; break ;
				case 4: vrm.register("video") ; break ;
				case 5: vrm.rentVideo() ; break ;
				case 6: vrm.returnVideo() ; break ;
				case 7: vrm.getCustomerReport() ; break;
				case 8: vrm.clearRentals() ; break ;
				case -1: vrm.init() ; break ;
				default: break ;
			}
		}
		System.out.println("Bye");
	}

	public int showCommand() {
		System.out.println("\nSelect a command !");
		System.out.println("\t 0. Quit");
		System.out.println("\t 1. List customers");
		System.out.println("\t 2. List videos");
		System.out.println("\t 3. Register customer");
		System.out.println("\t 4. Register video");
		System.out.println("\t 5. Rent video");
		System.out.println("\t 6. Return video");
		System.out.println("\t 7. Show customer report");
		System.out.println("\t 8. Show customer and clear rentals");

		int command = scanner.nextInt() ;

		return command ;

	}
}