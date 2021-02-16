import model.CardUserModel;
import repository.CardUserRepository;
import repository.impl.CardUserRepositoryImpl;
import java.util.List;


public class Main {
    public static void main(String[] args) {


        CardUserModel user = new CardUserModel();
        CardUserModel user1 = new CardUserModel();
        CardUserRepository cardUserRepository = new CardUserRepositoryImpl();

        //ADDING NEW USERS CARD ON DB
        user.setCardUserData(12345, 1234, "VARDAN", "MKRTCHYAN", "1234567891276543", "12/23", "GEL");
        cardUserRepository.add(user);

        // PRINTING DB ITEMS
        List<CardUserModel> lst = cardUserRepository.getAll();
        lst.forEach(System.out::println);

        // DELETING ROW WHERE ID = ? FROM DB
        // check if exists this id!
        cardUserRepository.delete(6);

        // PRINTING TO CHECK IF CORRECTLY WORKS
        System.out.println();
        lst = cardUserRepository.getAll();
        lst.forEach(System.out::println);

        // GETTING BY ID
        user1 =  cardUserRepository.getById(2);
        System.out.println("we get by id: 2.\n" + user1);

        // UPDATING ID=2 USERS DATA
        user1.setCardUserData(8888, 7777, "POXOS", "PETROSYAN", "0000000000000000", "12/22", "GPA");
        cardUserRepository.update(user1);

        // GETTING BY ID TO CHECK
        user1 =  cardUserRepository.getById(2);
        System.out.println("we UPDATE id: 2.\n" + user1);
    }
}

