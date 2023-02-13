import java.util.Scanner;

import service.FoodKartController;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        Scanner sc = new Scanner(System.in);
        try {

            
            FoodKartController foodKartController = new FoodKartController();
            int choice = 0;
            while(choice != -1){
                System.out.println("Press 1 for user registration.");
                System.out.println("Press 2 for restaurant registration.");
                System.out.println("Press 3 for user login.");
                System.out.println("Press 4 for showing restaurants.");
                System.out.println("Press 5 for placing order.");
                System.out.println("Press 6 for updating location.");
                System.out.println("Press 7 for creating review.");
                System.out.println("Press -1 to exit");
                choice = sc.nextInt();

                switch(choice){

                    case 1:{
                        System.out.println("Enter user name.");
                        String name = sc.next();
                        System.out.println("Enter user gender.");
                        String gender = sc.next();
                        System.out.println("Enter user phone number");
                        String phone = sc.next();
                        System.out.println("Enter user location");
                        String location = sc.next();
                        foodKartController.registerUser(name,gender,phone,location);
                        break;
                    }

                    case 2:{
                        System.out.println("Enter restaurant name.");
                        String name = sc.next();
                        System.out.println("Enter restaurant location");
                        String location = sc.next();
                        System.out.println("Enter item name.");
                        String item = sc.next();
                        System.out.println("Enter item price");
                        int itemPrice = sc.nextInt();
                        System.out.println("Enter item quantity");
                        int itemQuantity = sc.nextInt();
                    // int itemPrice = 1;
                        foodKartController.registerRestaurant(name,location,item,itemPrice,itemQuantity);
                        break;
                    }

                    case 3:{
                        System.out.println("Enter user phone number");
                        String phone = sc.next();
                        
                        foodKartController.loginUser(phone);
                        break;
                    }

                    case 4:{
                        System.out.println("Enter sorting criteria for restaurants");
                        String criteria = sc.next();
                        foodKartController.showRestaurants(criteria);
                        break;
                    }

                    case 5:{
                        System.out.println("Enter restaurant name.");
                        String restaurantName = sc.next();
                        System.out.println("Enter item quantity");
                        int itemQuantity = sc.nextInt();
                        foodKartController.placeOrder(restaurantName, itemQuantity);
                        break;
                    }

                    case 6:{
                        System.out.println("Enter restaurant name.");
                        String restaurantName = sc.next();
                        System.out.println("Enter new location");
                        String newLocation = sc.next();
                        foodKartController.updateLocation(restaurantName, newLocation);
                        break;
                    }

                    case 7:{
                        System.out.println("Enter restaurant name.");
                        String restaurantName = sc.next();
                        System.out.println("Enter rating");
                        int rating = sc.nextInt();
                        System.out.println("Enter review comments");
                        String comments = sc.next();
                        foodKartController.createReview(restaurantName, rating, comments);
                        break;
                    }
                }
            
        }
            
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Exception at : "+e.getMessage());
        }finally{
            sc.close();
        }
        
       
        
    }
}
