package OnlineAuctionSystem;

public class AuctionSystem {
    public static void main(String[] args) {

    	Auction auction = new Auction("Antique Watch");

        Bidder bidder1 = new Bidder("Rushank");
        Bidder bidder2 = new Bidder("Mohit");

        auction.addObserver(bidder1);
        auction.addObserver(bidder2);

        auction.startBidding();
        auction.endBidding();

        AuctionProcess standardAuction = new StandardAuction();
        AuctionProcess reserveAuction = new ReserveAuction();

        System.out.println("\nConducting Standard Auction:");
        standardAuction.conductAuction();

        System.out.println("\nConducting Reserve Auction:");
        reserveAuction.conductAuction();
    }
}

