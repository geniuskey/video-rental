import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VRManager {
    private List<Customer> customers = new ArrayList<Customer>() ;

    private List<Video> videos = new ArrayList<Video>() ;

    public void init() {
        Customer james = new Customer("James") ;
        Customer brown = new Customer("Brown") ;
        customers.add(james) ;
        customers.add(brown) ;

        Video v1 = new Video("v1", VideoType.CD, PriceCode.REGULAR, new Date()) ;
        Video v2 = new Video("v2", VideoType.DVD, PriceCode.NEW_RELEASE, new Date()) ;
        videos.add(v1) ;
        videos.add(v2) ;

        james.addRental(v1) ;
        james.addRental(v2) ;
    }

    public void clearRentals(String customerName) {
        Customer foundCustomer = searchCustomer(customerName);
        if ( foundCustomer == null ) return ;

        foundCustomer.reportRentalList();
        foundCustomer.clearRental();
    }

    public void returnVideo(String customerName, String videoTitle) {
        Customer foundCustomer = searchCustomer(customerName);
        if ( foundCustomer == null ) return ;

        setVideoRented(foundCustomer, videoTitle);
    }

    private static void setVideoRented(Customer foundCustomer, String videoTitle) {
        List<Rental> customerRentals = foundCustomer.getRentals() ;
        for ( Rental rental: customerRentals ) {
            if ( rental.getVideo().getTitle().equals(videoTitle) && rental.getVideo().isRented() ) {
                rental.returnVideo();
                rental.getVideo().setRented(false);
                break ;
            }
        }
    }

    private Customer searchCustomer(String customerName) {
        for ( Customer customer: customers ) {
            if ( customer.getName().equals(customerName)) {
                return customer ;
            }
        }
        System.out.println("No customer found");
        return null;
    }

    public void listVideos() {
        System.out.println("List of videos");

        for ( Video video: videos ) {
            System.out.println("Price code: " + video.getPriceCode() +"\tTitle: " + video.getTitle()) ;
        }
        System.out.println("End of list");
    }

    public void listCustomers() {
        System.out.println("List of customers");
        for ( Customer customer: customers ) {
            customer.reportRentalList();
        }
        System.out.println("End of list");
    }

    public void getCustomerReport(String customerName) {
        Customer foundCustomer = searchCustomer(customerName);
        if ( foundCustomer == null ) return ;

        System.out.println(foundCustomer.getReport());
    }

    public void rentVideo(String customerName, String videoTitle) {
        Customer foundCustomer = searchCustomer(customerName);
        if ( foundCustomer == null ) return ;

        Video foundVideo = searchVideo(videoTitle);
        if ( foundVideo == null ) return ;

        foundVideo.setRented(true);
        foundCustomer.addRental(foundVideo);
    }

    private Video searchVideo(String videoTitle) {
        Video foundVideo = null ;
        for ( Video video: videos ) {
            if ( video.getTitle().equals(videoTitle) && video.isRented() == false ) {
                foundVideo = video ;
                break ;
            }
        }
        return foundVideo;
    }

    public void registerCustomer(String name) {
        Customer customer = new Customer(name) ;
        customers.add(customer) ;
    }
    public void registerVideo(String title, int videoType, int priceCode) {
        Date registeredDate = new Date();
        VideoType type = VideoType.values()[videoType];
        PriceCode code = PriceCode.values()[priceCode];
        Video video = new Video(title, type, code, registeredDate) ;
        videos.add(video) ;
    }

}
